package com.POJO;

public class Data {

	public String id;
	public String email;
	public String first_name;
	public String last_name;
	public String avatar;

	public Data() {
		
	}
	
	public Data(String id, String email, String first_name, String last_name, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}
	
	public String getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public String getFirst_name() {
		return first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public String getAvatar() {
		return avatar;
	}
	
	
}
