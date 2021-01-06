package com.sistema_empresarial.model;

public class Admin {
	private String user = "admin";
	private String password = "admin";
	public Admin(String user, String password) {
		this.user = user;
		this.password = password;
	}
	public Admin() {}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
