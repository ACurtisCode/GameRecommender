package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.services.GameServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    GameServ gameServ;

    @RequestMapping("/{id}")
    @ResponseBody
    public Object findUser(@PathVariable("id") Long id) {
        Game game = gameServ.findGameById(id);
        HashMap<String, Object> object = new HashMap<>();
        object.put("gameId", game.getId());
        object.put("gameTitle", game.getTitle());
        object.put("gameDescription", game.getDescription());
        return object;
    }

    @PostMapping("/create")
    @ResponseBody
    public Game createGame(@RequestBody Game game) {
        return gameServ.createGame(game);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    public Game updateGame(@RequestBody Game game, @PathVariable("id") Long id) {
        Game updateGame = gameServ.findGameById(id);
        updateGame.setTitle(game.getTitle());
        updateGame.setDescription(game.getDescription());
        return gameServ.updateGame(updateGame);
    }

    @GetMapping("/delete/{id}")
    public void deleteGame(@PathVariable("id") Long id) {
        Game game = gameServ.findGameById(id);
        gameServ.deleteGame(game);
    }
}
