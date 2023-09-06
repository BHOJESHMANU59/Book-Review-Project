package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entitys.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>
{

}
