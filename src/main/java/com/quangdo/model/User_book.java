package com.quangdo.model;

import java.sql.Timestamp;

public class User_book {
	private int userId;
	private int bookId;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Timestamp getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Timestamp getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}
	
}
