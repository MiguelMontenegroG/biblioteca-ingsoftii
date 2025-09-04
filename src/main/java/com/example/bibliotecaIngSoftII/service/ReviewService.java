package com.example.bibliotecaIngSoftII.service;

import com.example.bibliotecaIngSoftII.model.Review;
import java.util.List;

public interface ReviewService {
    Review previewReview(Review review);
    Review submitReview(Review review);
    List<Review> getReviewsByBook(String bookId);
}