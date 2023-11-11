package com.clothings.springBoot.model;

public class CartItem {
	private Integer productId;
	private String productName;
	private Float unitPrice;
	private Float totalPrice;
	private Integer quantity;
	private String picture;
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Float getTotalPrice() {
		return unitPrice * quantity;
	}
	public void setTotalPrice(Float unitPrice) {
		this.totalPrice = unitPrice * quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity() {
		this.quantity++;
	}
	public CartItem(Product product) {
		quantity = 1;
		productId = product.getId();
		picture = product.getPicture();
		productName = product.getName();
		unitPrice = product.getUnitprice();
	}
	
}
