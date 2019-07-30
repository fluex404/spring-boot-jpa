package com.fluex404.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "book")
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Transient
	private String title;
	private String athor;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String athor) {
		this.title = title;
		this.athor = athor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAthor() {
		return athor;
	}
	public void setAthor(String athor) {
		this.athor = athor;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", athor=" + athor + "]";
	}
	
	
}
