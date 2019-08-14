package com.fluex404.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String athor;
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
	
	public Book(String title, String athor) {
		super();
		this.title = title;
		this.athor = athor;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", athor=" + athor + "]";
	}
	
	
}
