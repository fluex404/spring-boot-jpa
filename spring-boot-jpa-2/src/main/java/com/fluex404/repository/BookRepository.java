package com.fluex404.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fluex404.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query(nativeQuery = true, 
			value = "select * from book order by athor")
	List<Book> findAllByQuery();
	
//	@Query(nativeQuery = true, 
//			value = "select b.* from book b where b.title like '%:title%'")
	@Query(nativeQuery = true, 
	value = "select b.* from book b where b.title like %:title%")
	List<Book> findAllByTitleQuer(@Param("title") String title);
}
