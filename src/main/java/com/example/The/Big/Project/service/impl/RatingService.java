package com.example.The.Big.Project.service.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.BookRepository;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Rating getRatingById(Integer id) {
        return null;
    }

    public double calculateAverageRating(Rating rating) {
        return (rating.getPlot() + rating.getPace() + rating.getTone() + rating.getWorldDevelopment() + rating.getReRead()) / 5.0;
    }

    public Rating updateAverageRating(Rating rating) {
        double averageRating = calculateAverageRating(rating);
        rating.setAverageRating(averageRating);
        return rating;
    }

    @Override
    public Rating saveRating(Integer bookId, Rating rating) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        rating.setBook(book);
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Integer id) {
        Optional<Rating> ratingOptional = ratingRepository.findById(id);
        if (ratingOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating " + id + " not found.");
    }



    @Override
    public void updateRating(Integer id) {
    }

    @Override
    public List<Rating> updateAverageRating() {
        return List.of();
    }

}

