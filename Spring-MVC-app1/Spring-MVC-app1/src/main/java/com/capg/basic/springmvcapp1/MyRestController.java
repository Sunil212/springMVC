package com.capg.basic.springmvcapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@Autowired
	ProductDAOImpl dao;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
    
	//            localhost:9090:\product\10000\40000
	//  endpoint :- www.abc.com\product\10000\40000
	
	@GetMapping("/product/p")
	public List<Product> getProduct()
	{
		return dao.getAllProducts();
	}
	
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProductsbyrange(@PathVariable int r1 ,@PathVariable int r2)
	{
		return dao.getProductsByRange(r1, r2);
	}
	
	// ..../product/101
	@GetMapping("/product/{searchid}")
	public Product getProductByid(@PathVariable int searchid)
	{
		return dao.getProductById(searchid);
	}
	
	
	@GetMapping("/product/rating/{ratingid}")
	public List<Product> getProductByRating(@PathVariable int ratingid)
	{
		return  dao.getProductByRating(ratingid);
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody Product product)
	{
		if(dao.doAdd(product))
		{
			return product;
		}
		else return null;
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product)
	{
		return dao.doUpdate(product, product.getProductId());
	}
	
	@GetMapping("/product/delete/{id}")
	public Product deleteProductById(@PathVariable int id)
	{
		return dao.deleteProductById(id);
	}
}