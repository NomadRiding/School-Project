package com.example.The.Big.Project.controller.impl;

import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.service.impl.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // ****************************************************  GET  ****************************************************

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/ratings/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Integer id) {
        Rating rating = ratingService.getRatingById(id);
        return ResponseEntity.ok(rating);
    }

    // ****************************************************  POST  ****************************************************

    @PostMapping("/{bookId}/{userId}")
    public ResponseEntity<Rating> addRating(@PathVariable Integer bookId, @PathVariable Integer userId, @RequestBody Rating rating) {
        Rating savedRating = ratingService.saveRating(bookId, userId, rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    // ****************************************************  PUT  ****************************************************

    @PutMapping("/ratings/{id}")
    public ResponseEntity<Void> updateRating(@RequestBody @Valid Rating rating, @PathVariable Integer id) {
        ratingService.updateRating(id);
        return ResponseEntity.noContent().build();
    }

    // ****************************************************  DELETE  ****************************************************

    @DeleteMapping("/ratings/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Integer id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }
}
