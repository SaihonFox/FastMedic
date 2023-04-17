package com.polus_plus.fast_medic.Requests.APIs.OrderUser;

public class OrderItems {
	String catalog_id;
	String price;
	
	public OrderItems(String catalog_id, String price) {
		this.catalog_id = catalog_id;
		this.price = price;
	}
	
	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}