package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.models.Rating;

import com.alexc.gamerec.models.User;
import com.alexc.gamerec.services.GameServ;
import com.alexc.gamerec.services.RatingServ;
import com.alexc.gamerec.services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public ResponseEntity<Rating> findRating(@PathVariable("id") Long id) {
        Rating rating = ratingServ.getRatingById(id);
        if(rating != null) {
            Rating returnRating = new Rating();
            returnRating.setReviewText(rating.getReviewText());
            returnRating.setRating(rating.getRating());
            returnRating.setId(rating.getId());
            return new ResponseEntity<Rating>(returnRating, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Create Operations
    @PostMapping("/create/{userId}/{gameId}")
    @ResponseBody
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating, @PathVariable("userId") Long userId, @PathVariable("gameId") Long gameId) {
        User user = userServ.findUserById(userId);
        Game game = gameServ.findGameById(gameId);
        if(user!=null && game!=null) {
            rating.setReviewCreator(user);
            rating.setReviewedGame(game);
            return new ResponseEntity<Rating>(ratingServ.createRating(rating), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Update Operations
    @PostMapping("/update/{ratingId}")
    @ResponseBody
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable("ratingId") Long id) {
        Rating updateRating = ratingServ.getRatingById(id);
        if(updateRating != null) {
            updateRating.setRating(rating.getRating());
            updateRating.setReviewText(rating.getReviewText());
            return new ResponseEntity<Rating>(ratingServ.updateRating(updateRating), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //Delete Operations
    @GetMapping("/delete/{ratingId}")
    @ResponseBody
    public ResponseEntity deleteRating(@PathVariable("ratingId") Long id) {
        Rating rating = ratingServ.getRatingById(id);
        if(rating != null) {
            ratingServ.deleteRating(rating);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
