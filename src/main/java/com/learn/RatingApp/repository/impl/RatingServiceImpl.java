package com.learn.RatingApp.repository.impl;

import com.learn.RatingApp.entity.Rating;
import com.learn.RatingApp.exception.ResourceNotFoundException;
import com.learn.RatingApp.repository.RatingRepository;
import com.learn.RatingApp.service.RatingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository repository;

    /**
     * @param rating
     * @return Rating
     */
    @Override
    public Rating saveRating(Rating rating) {
        log.info("Saving rating : {} ", rating);
        rating.setRatingId(UUID.randomUUID().toString());
        return repository.save(rating);
    }

    /**
     * @return List<Rating>
     */
    @Override
    public List<Rating> getRatings() {
        log.info("Fetching all ratings");
        return repository.findAll();
    }

    /**
     * @param ratingId
     * @return
     */
    @Override
    public Rating getRatingByID(String ratingId) {
        log.info("Fetching ratings by RatingID: {}", ratingId);
        return repository.findById(ratingId).orElseThrow(() ->
                new ResourceNotFoundException("Records not found for ID: " + ratingId));
    }

    /**
     * @param userId
     * @return List<Rating>
     */
    @Override
    public List<Rating> getRatingByUserID(String userId) {
        log.info("Fetching all ratings by UserID: {}", userId);
        return repository.findByUserId(userId);
    }

    /**
     * @param hotelId
     * @return List<Rating>
     */
    @Override
    public List<Rating> getRatingByHotelID(String hotelId) {
        log.info("Fetching all ratings by HotelID: {}", hotelId);
        return repository.findByHotelId(hotelId);
    }
}
