package com.polus_plus.fast_medic;

public class UserCard {
	String name = "";
	String patronymic = "";
	String lastname = "";
	String birth = "";
	String pol = "";
	
	public UserCard() {
		this.name = "";
		this.patronymic = "";
		this.lastname = "";
		this.birth = "";
		this.pol = "";
	}
	
	public UserCard(String name, String patronymic, String lastname, String birth, String pol) {
		this.name = name;
		this.patronymic = patronymic;
		this.lastname = lastname;
		this.birth = birth;
		this.pol = pol;
	}
}