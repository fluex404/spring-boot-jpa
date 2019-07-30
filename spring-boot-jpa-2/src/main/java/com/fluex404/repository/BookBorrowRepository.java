package com.fluex404.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fluex404.model.Book;
import com.fluex404.model.BookBorrow;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {
	List<BookBorrow> findByBook(Book book);
	
	@Query(nativeQuery = true, 
	value = "select bb.id, bb.created_date, b.id bId, b.title, b.athor, (b.id*2) as test from bookborrow bb inner join book b on b.id = bb.book_id")
	List<?> findAllByQuery();
}
