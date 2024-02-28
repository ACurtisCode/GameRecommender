package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.services.GameServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
