package com.fluex404.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fluex404.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query(nativeQuery = true, 
			value = "select * from book order by athor")
	List<Book> findAllByQuery();
}
