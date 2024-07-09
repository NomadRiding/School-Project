package com.example.The.Big.Project.repository;

import com.example.The.Big.Project.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
