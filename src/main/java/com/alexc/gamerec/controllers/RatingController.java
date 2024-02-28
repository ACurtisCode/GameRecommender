package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Rating;

import com.alexc.gamerec.services.RatingServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingServ ratingServ;

    @GetMapping("/{id}")
    public Object findUser(@PathVariable("id") Long id) {
        Rating rating = ratingServ.getRatingById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("ratingId", rating.getId());
        object.put("ratingScore", rating.getRating());
        object.put("ratingReview", rating.getReviewText());
        object.put("ratingGame", rating.getReviewedGame().getTitle());
        object.put("ratingUser", rating.getReviewCreator().getFirstName() + " " + rating.getReviewCreator().getLastName());
        return object;
    }
}
