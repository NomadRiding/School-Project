package com.example.The.Big.Project.service.impl;


import com.example.The.Big.Project.controller.impl.RatingController;
import com.example.The.Big.Project.model.Rating;
import com.example.The.Big.Project.repository.RatingRepository;
import com.example.The.Big.Project.service.interfaces.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService implements IRatingService {
    @Autowired
    RatingRepository ratingRepository;


    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
