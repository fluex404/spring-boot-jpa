package com.fluex404.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluex404.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
