package com.fluex404.dao;

import java.util.List;

import com.fluex404.entity.Book;

public interface BookDao {
	public List<Book> findAll();
	public Book saveOrUpdate(Book book);
}
