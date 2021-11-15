
package com.maplr.testhockeygame.exception;
import lombok.Getter;

public class DupplicateNumberException extends RuntimeException{


    public DupplicateNumberException(String message) {
        super(message);
    }

    public DupplicateNumberException(String message, Throwable thrwbl) {
        super(message, thrwbl);
    }    
    
}
