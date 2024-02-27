package com.alexc.gamerec.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(updatable = false)
    @OneToMany(mappedBy="reviewCreator", fetch = FetchType.LAZY)
    private List<Rating> userRatings;

}
