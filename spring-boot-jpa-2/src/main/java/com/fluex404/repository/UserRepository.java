package com.fluex404.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluex404.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByLastnameAndFirstname(String lastname, String firstname);
	Optional<User> findByLastnameOrFirstname(String lastname, String firstname);
	List<User> findByAgeBetween(Integer age1, Integer age2);
	List<User> findByAgeLessThan(Integer age);
	List<User> findByAgeLessThanEqual(Integer age);
	List<User> findByAgeGreaterThan(Integer age);
	List<User> findByAgeGreaterThanEqual(Integer age);
//	List<User> findByStartCreateddateAfter(Date createddate);
//	List<User> findByStartCreateddateBefore(Date createddate);
	List<User> findByCreateddateIsNull();
	List<User> findByCreateddateNotNull();
	List<User> findByFirstnameLike(String first_name);
	List<User> findByFirstnameNotLike(String first_name);
	List<User> findByFirstnameStartingWith(String first_name);
	List<User> findByFirstnameEndingWith(String first_name);
	List<User> findByFirstnameContaining(String first_name);
	List<User> findByAgeIn(Collection<Integer> age);
	List<User> findByAgeNotIn(Collection<Integer> age);
	List<User> findByActiveTrue();
	List<User> findByActiveFalse();
	List<User> findByFirstnameIgnoreCase(String firstname);

}
