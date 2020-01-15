package com.demo.model;

public class Product {
	private String productId;
	private String productName;
	private int productPrice;

	public Product() {
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}
	public int getProductPrice() {
		return productPrice;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + " ]";
	}
}

