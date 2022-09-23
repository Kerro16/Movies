package com.movies.Movies.security.entity;

import com.movies.Movies.security.enums.RoleName;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @NotNull
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role() {
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
}

