package com.capg.basic.springmvcapp1;

import org.springframework.stereotype.Component;

@Component
public class Product {

	
	private int productId;
	private String productName;
	private int productCost;
	private int productRating;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Product(int productId, String productName, int productCost, int productRating) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.productRating = productRating;
	}



	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCost() {
		return productCost;
	}
	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}



	public int getProductRating() {
		return productRating;
	}



	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productCost;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productRating;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productCost != other.productCost)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productRating != other.productRating)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", productRating=" + productRating + "]";
	}
	
	
	
	
}
