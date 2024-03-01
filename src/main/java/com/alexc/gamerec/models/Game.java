package com.alexc.gamerec.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(updatable = false)
    @OneToMany(mappedBy="reviewedGame", fetch = FetchType.LAZY)
    List<Rating> ratingList = new ArrayList<Rating>();

    @ManyToMany(mappedBy = "gamesWithTag")
    @JoinTable(
        name = "games_tags",
        joinColumns = @JoinColumn(name = "game_id")
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tagList;

    public Game() {

    }

    public Game(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
