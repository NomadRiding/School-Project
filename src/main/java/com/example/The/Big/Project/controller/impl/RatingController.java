package com.example.The.Big.Project.controller.impl;


import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.impl.RatingService;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController implements IRatingService{
    @Autowired
    RatingService ratingService;




    //  ****************************************************  GET  ****************************************************

    @GetMapping("/ratings")
    public List<Rating> getAllRatings(){
        return ratingService.updateAverageRating();
    }

    @Override
    public Rating getRatingById(Integer id) {
        return null;
    }

    @Override
    public Rating saveRating(Integer bookId, Rating rating) {
        return null;
    }


    //  ****************************************************  POST  ****************************************************


    @PostMapping("/{bookId}/ratings")
    public Rating createRating(@PathVariable Integer bookId, @RequestBody Rating rating) {
        return ratingService.saveRating(bookId, rating);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<Rating> addRating(@PathVariable Integer bookId, @RequestBody Rating rating) {
        Rating savedRating = ratingService.saveRating(bookId, rating);
        return ResponseEntity.ok(savedRating);
    }

    //  ****************************************************  PUT  ****************************************************

    @PutMapping("/ratings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRating(@RequestBody @Valid Rating rating, @PathVariable Integer id){
        ratingService.updateRating(id);
    }

    //  ****************************************************  DELETE  ****************************************************

    public void deleteRating(@PathVariable Integer id){
        ratingService.deleteRating(id);
    }

    @Override
    public void updateRating(Integer id) {

    }

    @Override
    public List<Rating> updateAverageRating() {
        return List.of();
    }
}
