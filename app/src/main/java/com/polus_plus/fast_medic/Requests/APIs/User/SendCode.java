package com.polus_plus.fast_medic.Requests.APIs.User;

public class SendCode {
	String message;
	String error;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
}