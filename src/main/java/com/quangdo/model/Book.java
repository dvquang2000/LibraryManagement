package com.quangdo.model;

public class Book {
	private int id;
	private String title;
	private String author;
	private String published_year;
	private int categoryId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublished_year() {
		return published_year;
	}
	public void setPublished_year(String published_year) {
		this.published_year = published_year;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public Book(int id, String title, String author, String published_year, int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.published_year = published_year;
		this.categoryId = categoryId;
	}
	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+title+" "+author+" "+published_year+" "+categoryId+"\n";
	}*/
	

	
	
	
	
	
}
