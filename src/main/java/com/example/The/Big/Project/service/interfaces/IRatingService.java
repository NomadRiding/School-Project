package com.example.The.Big.Project.service.interfaces;

import com.example.The.Big.Project.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRatingService {

    List<Rating> getAllRatings();
    Rating getRatingById(Integer id);
    Rating saveRating(Integer bookId, Rating rating);
    void deleteRating(Integer id);
    void updateRating(Integer id);

    List<Rating> updateAverageRating();
}
