package com.movies.Movies.security.dto;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NewUser {


    @Getter @Setter
    @NotBlank
    private String name;


    @Getter @Setter
    @NotBlank
    private String username;


    @Getter @Setter
    @NotBlank
    @Email
    private String email;


    @Getter @Setter
    @NotBlank
    private String password;

    @Getter @Setter
    private Set<String> roles = new HashSet<>();
}
