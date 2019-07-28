package com.fluex404.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Table(name = "bookborrow")
@Entity
public class BookBorrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(
			fetch = FetchType.LAZY
			)
	@JoinColumn(
			name = "book_id",
			nullable = false
			)
	private Book book;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	
	public BookBorrow() {
		// TODO Auto-generated constructor stub
	}
	
	public BookBorrow(Book book) {
		this.book = book;
		this.created_date = new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "BookBorrow [id=" + id + ", book=" + book.getId() + ", created_date=" + created_date + "]";
	}
	
	
}
