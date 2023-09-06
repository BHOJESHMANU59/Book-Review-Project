package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entitys.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
