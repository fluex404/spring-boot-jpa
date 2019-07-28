package com.fluex404.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fluex404.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
