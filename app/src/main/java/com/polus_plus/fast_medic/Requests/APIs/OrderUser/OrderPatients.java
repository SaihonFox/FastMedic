package com.polus_plus.fast_medic.Requests.APIs.OrderUser;

public class OrderPatients {
	String name;
	OrderItems items;
	
	public OrderPatients(String name, OrderItems items) {
		this.name = name;
		this.items = items;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public OrderItems getItems() {
		return items;
	}
	public void setItems(OrderItems items) {
		this.items = items;
	}
}