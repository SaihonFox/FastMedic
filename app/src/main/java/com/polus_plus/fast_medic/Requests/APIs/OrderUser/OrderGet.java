package com.polus_plus.fast_medic.Requests.APIs.OrderUser;

public class OrderGet {
	String order_id;
	
	public OrderGet(String order_id) {
		this.order_id = order_id;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
}