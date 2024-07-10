package com.example.The.Big.Project.service.impl;


import com.example.The.Big.Project.controller.impl.RatingController;
import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.BookRepository;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements IRatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public double calculateAverageRating(Rating rating) {
        return (rating.getPlot() + rating.getPace() + rating.getTone() + rating.getWorldDevelopment() + rating.getReRead()) / 5.0;
    }

    public Rating updateAverageRating(Rating rating) {
        double averageRating = calculateAverageRating(rating);
        rating.setAverageRating(averageRating);
        return rating;
    }

    public Rating saveRating(Integer bookId, Rating rating) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        rating.setBook(book);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> updateAverageRating() {
        return List.of();
    }

}
