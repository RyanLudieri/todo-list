package br.edu.unifalmg.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChoreNotFoundException extends RuntimeException {
    public ChoreNotFoundException(String message){
        super(message);
    }
}
