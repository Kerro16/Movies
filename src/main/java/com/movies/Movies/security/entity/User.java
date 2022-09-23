package com.movies.Movies.security.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
    @NotNull
    @Getter @Setter
    private String name;

    @NotNull
    @Column(unique = true)
    @Getter @Setter
    private String username;

    @NotNull
    @Column(unique = true)
    @Getter @Setter
    private String email;

    @NotNull
    @Getter @Setter
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Getter @Setter
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
