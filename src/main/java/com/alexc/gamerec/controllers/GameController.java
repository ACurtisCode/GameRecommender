package com.alexc.gamerec.controllers;

import com.alexc.gamerec.models.Game;
import com.alexc.gamerec.models.Tag;
import com.alexc.gamerec.services.GameServ;
import com.alexc.gamerec.services.TagServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    GameServ gameServ;
    @Autowired
    TagServ tagServ;

    //Read Operations
    @RequestMapping("/{id}")
    @ResponseBody
    public Game findGame(@PathVariable("id") Long id) {
        Game game = gameServ.findGameById(id);
//        HashMap<String, Object> object = new HashMap<>();
//        object.put("gameId", game.getId());
//        object.put("gameTitle", game.getTitle());
//        object.put("gameDescription", game.getDescription());
//        object.put("tagList", game.getTagList());
//        return object;
        return game;
    }
    @RequestMapping("/find")
    @ResponseBody
    public List<Game> findGamesTitle(@RequestParam("title") String title) {
        return gameServ.findGamesByTitle(title);
    }
    //Create Operations
    @PostMapping("/create")
    @ResponseBody
    public Game createGame(@RequestBody Game game) {
        return gameServ.createGame(game);
    }

    //Update Operations
    @PostMapping("/update/{id}")
    @ResponseBody
    public Game updateGame(@RequestBody Game game, @PathVariable("id") Long id) {
        Game updateGame = gameServ.findGameById(id);
        updateGame.setTitle(game.getTitle());
        updateGame.setDescription(game.getDescription());
        return gameServ.updateGame(updateGame);
    }
        //with IDs
    @PostMapping("/attachtag/{gameId}/{tagId}")
    public void attachTag(@PathVariable("gameId") Long gameId, @PathVariable("tagId") Long tagId) {
        Tag tag = tagServ.getTagById(tagId);
        Game game = gameServ.findGameById(gameId);
        gameServ.addTag(game, tag);
    }
        //with JSON objects
    @PostMapping("/attachtag")
    public void attachTag(@RequestBody Game game, @RequestBody Tag tag) {
        gameServ.addTag(game, tag);
    }

    //Delete Operations
        //With ID
    @GetMapping("/delete/{id}")
    public void deleteGame(@PathVariable("id") Long id) {
        Game game = gameServ.findGameById(id);
        gameServ.deleteGame(game);
    }
        //With JSON object
    @GetMapping("/delete")
    public void deleteGame(@RequestBody Game game) {
        gameServ.deleteGame(game);
    }
}
