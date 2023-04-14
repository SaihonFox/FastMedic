package com.polus_plus.fast_medic.Requests.APIs.User;

public class SendCode {
	String message;
	String errors;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
}