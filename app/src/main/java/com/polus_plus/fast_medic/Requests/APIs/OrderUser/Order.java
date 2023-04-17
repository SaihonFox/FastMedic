package com.polus_plus.fast_medic.Requests.APIs.OrderUser;

public class Order {
	String address;
	String date_time;
	String phone;
	OrderPatients patients;
	
	public Order(String address, String date_time, String phone, OrderPatients patients) {
		this.address = address;
		this.date_time = date_time;
		this.phone = phone;
		this.patients = patients;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public OrderPatients getPatients() {
		return patients;
	}
	public void setPatients(OrderPatients patients) {
		this.patients = patients;
	}
}