package com.clothings.springBoot.model;

import java.util.Date;

public class Product {
	private Integer id;
	private Integer categoryid;
	private String picture;
	private String name;
	private String code;
	private Float costprice;
	private Float unitprice;
	private Integer sold;
	private Integer sale;
	private Date stockindate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture == null ? null : picture.trim();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}
	public Float getCostprice() {
		return costprice;
	}
	public void setCostprice(Float costprice) {
		this.costprice = costprice;
	}
	public Float getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Date getStockindate() {
		return stockindate;
	}
	public void setStockindate(Date stockindate) {
		this.stockindate = stockindate;
	}
}