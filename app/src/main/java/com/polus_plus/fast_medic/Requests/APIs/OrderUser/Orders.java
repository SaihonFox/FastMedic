package com.polus_plus.fast_medic.Requests.APIs.OrderUser;

public class Orders {
	int id;
	int patient_id;
	String created_at;
	String updated_at;
	int order_id;
	int catalog_id;
	String price;
	OrdersPatient patient;
	OrdersOrder order;
	OrdersItem item;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public OrdersPatient getPatient() {
		return patient;
	}
	public void setPatient(OrdersPatient patient) {
		this.patient = patient;
	}
	
	public OrdersOrder getOrder() {
		return order;
	}
	public void setOrder(OrdersOrder order) {
		this.order = order;
	}
	
	public OrdersItem getItem() {
		return item;
	}
	public void setItem(OrdersItem item) {
		this.item = item;
	}
}