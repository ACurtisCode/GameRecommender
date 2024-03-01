package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.models.Rating;

import com.alexc.gamerec.models.User;
import com.alexc.gamerec.services.GameServ;
import com.alexc.gamerec.services.RatingServ;
import com.alexc.gamerec.services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingServ ratingServ;
    @Autowired
    UserServ userServ;
    @Autowired
    GameServ gameServ;

    //Read Operations
    @GetMapping("/{id}")
    public Object findRating(@PathVariable("id") Long id) {
        Rating rating = ratingServ.getRatingById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("ratingId", rating.getId());
        object.put("ratingScore", rating.getRating());
        object.put("ratingReview", rating.getReviewText());
        object.put("ratingGame", rating.getReviewedGame().getTitle());
        object.put("ratingUser", rating.getReviewCreator().getFirstName() + " " + rating.getReviewCreator().getLastName());
        return object;
    }

    //Create Operations
    @PostMapping("/create/{userId}/{gameId}")
    @ResponseBody
    public Rating createRating(@RequestBody Rating rating, @PathVariable("userId") Long userId, @PathVariable("gameId") Long gameId) {
        User user = userServ.findUserById(userId);
        Game game = gameServ.findGameById(gameId);
        rating.setReviewCreator(user);
        rating.setReviewedGame(game);
        return ratingServ.createRating(rating);
    }

    //Update Operations
    @PostMapping("/update/{ratingId}")
    @ResponseBody
    public Rating updateRating(@RequestBody Rating rating, @PathVariable("ratingId") Long id) {
        Rating updateRating = ratingServ.getRatingById(id);
        updateRating.setRating(rating.getRating());
        updateRating.setReviewText(rating.getReviewText());
        return ratingServ.updateRating(updateRating);
    }

    //Delete Operations
    @GetMapping("/delete/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") Long id) {
        ratingServ.deleteRating(ratingServ.getRatingById(id));
    }

}
