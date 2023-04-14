package com.polus_plus.fast_medic.Requests.APIs.OrderUser;

public class OrdersOrder {
	String created_at;
	String updated_at;
	int id;
	String address;
	String date_time;
	String phone;
	String comment;
	String audio_comment;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getAudio_comment() {
		return audio_comment;
	}
	public void setAudio_comment(String audio_comment) {
		this.audio_comment = audio_comment;
	}
}