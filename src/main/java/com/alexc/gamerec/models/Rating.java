package com.alexc.gamerec.models;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table(name="ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=0, max=10)
    private double rating;

    private String reviewText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id")
    private Game reviewedGame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User reviewCreator;

    public Rating() {}

    public Rating(double rating, String reviewText, Game game, User user) {
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewedGame = game;
        this.reviewCreator = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setReviewedGame(Game reviewedGame) {
        this.reviewedGame = reviewedGame;
    }

    public Game getReviewedGame() {
        return reviewedGame;
    }

    public User getReviewCreator() {
        return reviewCreator;
    }

    public void setReviewCreator(User reviewCreator) {
        this.reviewCreator = reviewCreator;
    }
}
