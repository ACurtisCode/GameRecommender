package com.alexc.gamerec.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long rawgId;

    private String slug;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "games_developers",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> gameList;

    public Developer() {
    }

    public Long getId() {
        return id;
    }

    public Long getRawgId() {
        return rawgId;
    }

    public void setRawgId(Long rawgId) {
        this.rawgId = rawgId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
