package br.edu.unifalmg.domain.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidDescriptionException extends RuntimeException{


    public InvalidDescriptionException(String message){
        super(message);
    }


}
