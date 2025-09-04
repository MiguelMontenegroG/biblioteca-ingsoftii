package com.example.bibliotecaIngSoftII.repository;

import com.example.bibliotecaIngSoftII.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByBookId(String bookId);
}
