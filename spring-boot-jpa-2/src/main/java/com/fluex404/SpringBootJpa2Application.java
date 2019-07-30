package com.fluex404;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fluex404.repository.BookBorrowRepository;
import com.fluex404.repository.BookRepository;
import com.fluex404.repository.UserRepository;

@SpringBootApplication
public class SpringBootJpa2Application {

	private static BookRepository bookRepository;
	private static BookBorrowRepository bookBorrowRepository;
	private static UserRepository userRepository;
	
	@Autowired
	public SpringBootJpa2Application(BookRepository bookRepository, 
			BookBorrowRepository bookBorrowRepository, 
			UserRepository userRepository) {
		this.bookRepository = bookRepository;
		this.bookBorrowRepository = bookBorrowRepository;
		this.userRepository = userRepository;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa2Application.class, args);
		
		/* ManyToOne */
//		bookRepository.saveAll(Arrays.asList(
//				new Book("The Evil Programming language", "Isa"),
//				new Book("Java Cloud Native", "Josh Long")
//				));
		
//		Book b1 = bookRepository.findById(new Long(1)).get();
//		Book b2 = bookRepository.findById(new Long(2)).get();
		
//		bookBorrowRepository.saveAll(Arrays.asList(
//				
//				new BookBorrow(b2),
//				new BookBorrow(b2),
//				new BookBorrow(b2)
//				
//				
//				));
		
//		List<BookBorrow> list = bookBorrowRepository.findByBook(b2);
//		
//		for(BookBorrow b : list) {
//			System.out.println(b);
//		}
		
//		userRepository.saveAll(Arrays.asList(
//				
//				new User("Test1", "test", 17, 1),
//				new User("Test2", "test", 19, -1),
//				new User("Test3", "test", 16, 2),
//				new User("Empul", "Jaya", 21, 1)
//				
//				));
		
		/* Query From Method Name */
//		userRepository.findByLastnameAndFirstname("Subani", "Isa").ifPresent(user -> System.out.println(user));
//		userRepository.findByAgeBetween(17, 19).forEach(user -> System.out.println(user));
//		userRepository.findByAgeLessThan(18).forEach(user -> System.out.println(user));
//		userRepository.findByAgeLessThanEqual(18).forEach(user -> System.out.println(user));
//		userRepository.findByAgeGreaterThan(19).forEach(user -> System.out.println(user));
//		userRepository.findByAgeGreaterThanEqual(19).forEach(user -> System.out.println(user));
//		userRepository.findByCreateddateIsNull().forEach(user -> System.out.println(user));
//		userRepository.findByFirstnameLike("%e%").forEach(user -> System.out.println(user));
//		userRepository.findByCreateddateNotNull().forEach(user -> System.out.println(user));
//		userRepository.findByFirstnameStartingWith("i").forEach(user -> System.out.println(user));
//		userRepository.findByFirstnameContaining("e").forEach(user -> System.out.println(user));
//		userRepository.findByAgeIn(Arrays.asList(17, 21)).forEach(user -> System.out.println(user));
//		userRepository.findByFirstnameIgnoreCase("Isa").forEach(user -> System.out.println(user));
		
		/* Query */
		List<?> result = new ArrayList<>();
		
		result = bookBorrowRepository.findAllByQuery();
		
		for(Object object : result) {
			Object d[] = (Object[]) object;
		}
		
	}

}
