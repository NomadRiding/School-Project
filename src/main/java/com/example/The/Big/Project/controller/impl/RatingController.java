package com.example.The.Big.Project.controller.impl;


import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.impl.RatingService;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {
    @Autowired
    RatingService ratingService;



    //  ****************************************************  GET  ****************************************************

    @GetMapping("/ratings")
    public List<Rating> getAllRatings(){
        return ratingService.updateAverageRating();
    }



    //  ****************************************************  POST  ****************************************************


    @PostMapping("/{bookId}/ratings")
    public Rating createRating(@PathVariable Integer bookId, @RequestBody Rating rating) {
        return ratingService.saveRating(bookId, rating);
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
}
