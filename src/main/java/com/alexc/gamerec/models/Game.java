package com.alexc.gamerec.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String Description;

    @Column(updatable = false)
    @OneToMany(mappedBy="reviewedGame", fetch = FetchType.LAZY)
    List<Rating> ratingList;
}
