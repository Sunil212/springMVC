package com.capg.basic.springmvcapp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl {

	List<Product> list ;

	public ProductDAOImpl() {
		
		Product p1 = new Product(101, "HP-101",45000,4);
		Product p2 = new Product(102, "HP-102",15000,3);
		Product p3 = new Product(103, "HP-103",25000,3);
		Product p4 = new Product(104, "HP-104",20000,4);
		Product p5 = new Product(105, "HP-105",145000,5);
		
		list = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5));
	
	}
	
	public List<Product> getAllProducts()
	{
		return list;
	}
	
	public List<Product> getProductsByRange(int r1,int r2)
	{
		
		Comparator<Product> comp = (p1,p2)->p1.getProductCost() - p2.getProductCost();
		
		List<Product> productList = list.stream().
		filter((product)->product.getProductCost()>=r1&&product.getProductCost()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	public Product getProductById(int searchid)
	{
		boolean isIdFound = false;
		Product searchedProduct = null;
		for (Product product : list) {
			if(product.getProductId() == searchid)
			{
				isIdFound = true;
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}
	
	
	public List<Product> getProductByRating(int rating)
	{
		List<Product> productList = list.stream().
				filter((product)->product.getProductRating()==rating).
				collect(Collectors.toList());
		
		return productList;
	}
	
	
	public boolean doAdd(Product product)
	{
		return list.add(product);
	}
	
	public Product doUpdate(Product updatedProduct,int productId)
	{
		Product p = getProductById(productId);
		if(p!=null)
		{
			p.setProductCost(updatedProduct.getProductCost());
			p.setProductName(updatedProduct.getProductName());
			p.setProductId(updatedProduct.getProductId());
			p.setProductRating(updatedProduct.getProductRating());
		}
		return p;
	}
	
	public Product deleteProductById(int id) {
		
		Product p = getProductById(id);
		boolean x = false;
		if(p != null)
		{
			System.out.println(" ===> DAO List Size before delete "+list.size()+" and p "+p);
			x = list.remove(p);
			System.out.println(" ===> DAO List Size after delete "+list.size());
			System.out.println(" ===>> DAO Delete operation "+x);
		}
		
		if(x) return p;
		else return null;
		
		
	}
}//end class