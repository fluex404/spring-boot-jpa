package com.fluex404.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluex404.model.Book;
import com.fluex404.model.BookBorrow;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
	List<BookBorrow> findByBook(Book book);
}
