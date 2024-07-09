package com.example.The.Big.Project.repository;

import com.example.The.Big.Project.model.Rating;

import java.util.List;

public interface RatingRepository {
    List<Rating> findAll();
}
