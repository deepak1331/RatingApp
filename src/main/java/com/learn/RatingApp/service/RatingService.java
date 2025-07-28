package com.learn.RatingApp.service;

import com.learn.RatingApp.entity.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    //Create Rating
    Rating saveRating(Rating rating);

    //Get All ratings
    List<Rating> getRatings();

    //Get All ratings by RatingID
    Rating getRatingByID(String ratingId);

    //Get All ratings by UserID
    List<Rating> getRatingByUserID(String userId);

    //Get All ratings by HotelID
    List<Rating> getRatingByHotelID(String hotelId);
}
