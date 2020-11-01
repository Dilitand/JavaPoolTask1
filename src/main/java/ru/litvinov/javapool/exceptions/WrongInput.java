package ru.litvinov.javapool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "wrong input. Speed and mileage cannot be less than 0")
public final class WrongInput extends RuntimeException {
    //  class definition
    public WrongInput(String textInput) {
        super(textInput);
    }
}