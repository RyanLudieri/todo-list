package br.edu.unifalmg.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDeadlineException extends RuntimeException{

    public InvalidDeadlineException(String message){
        super(message);
    }


}
