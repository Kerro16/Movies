package com.movies.Movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private int role;


}
