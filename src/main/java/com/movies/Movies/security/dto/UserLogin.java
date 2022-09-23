package com.movies.Movies.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class UserLogin {


    @Getter @Setter
    @NotBlank
    private String username;


    @Getter @Setter
    @NotBlank
    private String password;
}
