
package com.maplr.testhockeygame.exception;
import lombok.Getter;

public class RessourceNotFoundException extends RuntimeException{


    public RessourceNotFoundException(String message) {
        super(message);
    }

    public RessourceNotFoundException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }    
    
}
