
package com.maplr.testhockeygame.entities;


public enum Position {
   
    goaltender("goaltender"),
    forward("forward"),
    defenseman("defenseman");

    private String description;

    Position(String description){
        this.description = description;
    }

}
