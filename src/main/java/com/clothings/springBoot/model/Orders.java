package com.clothings.springBoot.model;

import java.util.Date;

public class Orders {
	private Integer id;
	private String status;
	private String address;
	private Date ordtime;
	private Date delitime;
	private Double totalprice;
	private Integer totalquantity;
	private String note;
	private Long userid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
	public Date getOrdtime() {
		return ordtime;
	}
	public void setOrdtime(Date ordtime) {
		this.ordtime = ordtime;
	}
	public Date getDelitime() {
		return delitime;
	}
	public void setDelitime(Date delitime) {
		this.delitime = delitime;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(Integer totalquantity) {
		this.totalquantity = totalquantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
}