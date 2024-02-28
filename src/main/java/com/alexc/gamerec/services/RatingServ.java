package com.alexc.gamerec.services;

import com.alexc.gamerec.models.Rating;
import com.alexc.gamerec.repositories.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServ {
    @Autowired
    RatingRepo ratingRepo;

    public Rating getRatingById(Long id) {
        return ratingRepo.findById(id).get();
    }
}
