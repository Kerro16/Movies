package com.movies.Movies.dto;

import lombok.Getter;
import lombok.Setter;

public class Message {

    @Getter @Setter
    private String message;

    public Message(String message) {
        this.message = message;
    }
}
