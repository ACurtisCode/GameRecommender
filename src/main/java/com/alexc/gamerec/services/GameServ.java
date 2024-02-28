package com.alexc.gamerec.services;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.repositories.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServ {
    @Autowired
    GameRepo gameRepo;

    public Game findGameById(Long id) {
        return gameRepo.findById(id).get();
    }
}
