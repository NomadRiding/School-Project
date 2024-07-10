package com.example.The.Big.Project.controller.impl;


import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {
    @Autowired
    IRatingService ratingService;


    //  ****************************************************  GET  ****************************************************

    @GetMapping("/ratings")
        public List<Rating> getAllRatings(){
        return ratingService.updateAverageRating();
      }
    }
