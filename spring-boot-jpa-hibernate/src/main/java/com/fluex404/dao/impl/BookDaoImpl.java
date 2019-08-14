package com.fluex404.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluex404.dao.BookDao;
import com.fluex404.entity.Book;

@Service
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private static EntityManagerFactory emf;

	@Override
	public List<Book> findAll() {
		List<Book> list = null;
		
		Session session = emf.unwrap(Session.class);
		Transaction tx = null;
		
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Book.class);
		list = criteria.list();
		tx.commit();
		
		return list;
	}

	@Override
	public Book saveOrUpdate(Book book) {
		
		Session session = emf.unwrap(Session.class);
		Transaction tx = null;
		
		tx = session.beginTransaction();
		
		session.saveOrUpdate(book);
		
		tx.commit();
		
		return true;
	}

}
