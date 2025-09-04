package com.example.bibliotecaIngSoftII.service.impl;

import com.example.bibliotecaIngSoftII.model.Review;
import com.example.bibliotecaIngSoftII.repository.ReviewRepository;
import com.example.bibliotecaIngSoftII.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review previewReview(Review review) {
        review.setPreview(true);
        return review;
    }

    @Override
    public Review submitReview(Review review) {
        review.setPreview(false);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByBook(String bookId) {
        return reviewRepository.findByBookId(bookId);
    }
}
