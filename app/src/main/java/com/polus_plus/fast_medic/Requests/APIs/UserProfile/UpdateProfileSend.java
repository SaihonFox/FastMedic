package com.polus_plus.fast_medic.Requests.APIs.UserProfile;

public class UpdateProfileSend {
	String firstname;
	String lastname;
	String middlename;
	String bith;
	String pol;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	public String getBith() {
		return bith;
	}
	public void setBith(String bith) {
		this.bith = bith;
	}
	
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
}