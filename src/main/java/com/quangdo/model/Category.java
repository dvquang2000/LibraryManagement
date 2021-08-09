package com.quangdo.model;

public class Category {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNameString(String nameString) {
		this.name = nameString;
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+name;
	}
	
}
