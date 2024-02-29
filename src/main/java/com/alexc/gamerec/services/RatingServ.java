package com.alexc.gamerec.services;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.models.Rating;
import com.alexc.gamerec.models.User;
import com.alexc.gamerec.repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServ {
    @Autowired
    RatingRepo ratingRepo;

    public Rating getRatingById(Long id) {
        if(ratingRepo.findById(id).isEmpty()){
            return null;
        }
        return ratingRepo.findById(id).get();
    }

    public Rating createRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    public Rating createRating(Double rating, String reviewText, Game game, User user) {
        return ratingRepo.save(new Rating(rating, reviewText, game, user));
    }

    public Rating updateRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    public void deleteRating(Rating rating) {
        ratingRepo.delete(rating);
    }
}
