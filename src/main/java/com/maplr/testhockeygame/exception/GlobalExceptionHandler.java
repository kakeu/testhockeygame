
package com.maplr.testhockeygame.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RessourceNotFoundException.class)
    public ResponseEntity<?> handleRessourceNotFoundException(RessourceNotFoundException exception, WebRequest webRequest){
    
        ErrorDetail errorDetail = new ErrorDetail(new Date(),exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity(errorDetail,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<?> handleInvalidEntityException(InvalidEntityException exception, WebRequest webRequest){
    
        ErrorDetail1 errorDetail1 = new ErrorDetail1(new Date(),exception.getMessage(), webRequest.getDescription(false), exception.getErrors());
        
        return new ResponseEntity(errorDetail1,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DupplicateNumberException.class)
    public ResponseEntity<?> handleDupplicateFoundException(DupplicateNumberException exception, WebRequest webRequest){
    
        ErrorDetail errorDetail = new ErrorDetail(new Date(),exception.getMessage(), webRequest.getDescription(false));
        
        return new ResponseEntity(errorDetail,HttpStatus.CONFLICT);
    }


}
