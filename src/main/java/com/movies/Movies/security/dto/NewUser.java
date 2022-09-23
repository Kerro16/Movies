package com.movies.Movies.security.dto;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NewUser {

    @NotBlank
    @Getter @Setter
    private String name;

    @NotBlank
    @Getter @Setter
    private String username;

    @Email
    @Getter @Setter
    private String email;

    @NotBlank
    @Getter @Setter
    private String password;

    @Getter @Setter
    private Set<String> roles = new HashSet<>();
}
