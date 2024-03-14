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

    private Long rawgId;

    private String slug;

    private String title;

    private String description;

    @Column(updatable = false)
    @OneToMany(mappedBy="reviewedGame", fetch = FetchType.LAZY)
    List<Rating> ratingList = new ArrayList<Rating>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "games_tags",
        joinColumns = @JoinColumn(name = "game_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tagList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "games_genres",
        joinColumns = @JoinColumn(name = "game_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genreList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "games_developers",
        joinColumns = @JoinColumn(name = "game_id"),
        inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<Developer> developerList;

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
