package com.quangdo.model;

public class User {
	private  int id;
	private String email;
	private String password;
	private String name;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User() {
		super();
	}
	public User(int id, String email, String password, String name, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+email+" "+password+" "+name+" "+role;
	}
	
}
