package com.alexc.gamerec.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinTable(name="game_id")
    private Game taggedGame;

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getTaggedGame() {
        return taggedGame;
    }

    public void setTaggedGame(Game taggedGame) {
        this.taggedGame = taggedGame;
    }
}
