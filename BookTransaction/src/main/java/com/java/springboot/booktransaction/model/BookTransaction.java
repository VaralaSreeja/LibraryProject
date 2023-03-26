package com.java.springboot.booktransaction.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BooksTransaction")

public class BookTransaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "issueId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long issueId;
	
	@Column(name= "bookId")
	private long bookId;
	
	@Column(name = "userId")
	private long userId;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "issued_to")
	private long issuedTo;
	
	@Column(name = "issue_date")
	private LocalDate issueDate;
	
	@Column(name = "return_date")
	private LocalDate returnDate;
	
	private LocalDate dueDate;
	
	private boolean isIssued;

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getUserId() {
		return userId;
	}
	

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public long getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(long issuedTo) {
		this.issuedTo = issuedTo;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate localDate) {
		this.returnDate = localDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isIssued() {
		return isIssued;
	}

	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}

	public BookTransaction(long issueId, long bookId, long userId, long quantity, long issuedTo, LocalDate issueDate,
			LocalDate returnDate, LocalDate dueDate, boolean isIssued) {
		super();
		this.issueId = issueId;
		this.bookId = bookId;
		this.userId = userId;
		this.quantity = quantity;
		this.issuedTo = issuedTo;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.dueDate = dueDate;
		this.isIssued = isIssued;
	}

	public BookTransaction() {
		
	}

}
