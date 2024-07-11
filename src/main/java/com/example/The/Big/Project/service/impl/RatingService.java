package com.example.The.Big.Project.service.impl;

import com.example.The.Big.Project.model.Book;
import com.example.The.Big.Project.model.User;
import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.BookRepository;
import com.example.The.Big.Project.repository.UserRepository;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RatingService implements IRatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(Integer id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found"));
    }

    public double calculateAverageRating(Rating rating) {
        return (rating.getPlot() + rating.getPace() + rating.getTone() + rating.getWorldDevelopment() + rating.getReRead()) / 5.0;
    }

    public void updateAverageRating(Rating rating) {
        double averageRating = calculateAverageRating(rating);
        rating.setAverageRating(averageRating);
    }

    @Override
    @Transactional
    public Rating saveRating(Integer bookId, Integer userId, Rating rating) {
        // Ensure the book exists
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        // Ensure the user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // Set the book and user in the rating
        rating.setBook(book);
        rating.setUser(user);

        // Calculate and set the average rating
        updateAverageRating(rating);

        // Save rating to repository
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Integer id) {
        // Check if rating exists, if not throw exception
        ratingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating " + id + " not found."));
        // If exists, delete by ID
        ratingRepository.deleteById(id);
    }

    @Override
    public void updateRating(Integer id) {
        // Placeholder for update logic
    }

    @Override
    public List<Rating> updateAverageRating() {
        // Placeholder for bulk update function, returns empty list
        return List.of();
    }

    @Override
    public Rating saveRating(Integer bookId, Rating rating) {
        // Redundant method, provide clear instruction to use the correct method
        throw new UnsupportedOperationException("Use saveRating(Integer bookId, Integer userId, Rating rating) instead.");
    }
}