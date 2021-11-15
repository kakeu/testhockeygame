
package com.maplr.testhockeygame.exception;

import java.util.List;
import lombok.Getter;


public class InvalidEntityException extends RuntimeException{
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }
    
    public InvalidEntityException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
    
}
