package com.fluex404;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fluex404.model.Book;
import com.fluex404.model.BookBorrow;
import com.fluex404.repository.BookBorrowRepository;
import com.fluex404.repository.BookRepository;

@SpringBootApplication
public class SpringBootJpa2Application {

	private static BookRepository bookRepository;
	private static BookBorrowRepository bookBorrowRepository;
	
	@Autowired
	public SpringBootJpa2Application(BookRepository bookRepository, BookBorrowRepository bookBorrowRepository) {
		this.bookRepository = bookRepository;
		this.bookBorrowRepository = bookBorrowRepository;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa2Application.class, args);
		
//		bookRepository.saveAll(Arrays.asList(
//				new Book("The Evil Programming language", "Isa"),
//				new Book("Java Cloud Native", "Josh Long")
//				));
		
		Book b1 = bookRepository.findById(new Long(1)).get();
		Book b2 = bookRepository.findById(new Long(2)).get();
		
//		bookBorrowRepository.saveAll(Arrays.asList(
//				
//				new BookBorrow(b2),
//				new BookBorrow(b2),
//				new BookBorrow(b2)
//				
//				
//				));
		
		List<BookBorrow> list = bookBorrowRepository.findByBook(b2);
		
		for(BookBorrow b : list) {
			System.out.println(b);
		}
		
	}

}
