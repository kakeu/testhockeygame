
package com.maplr.testhockeygame.validators;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.entities.Position;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;


public class PlayerValidator {

    public static List<String> validate(PlayerDto playerDto){
    
    List<String> errors = new ArrayList<>();
    
    if(playerDto == null || !StringUtils.hasLength(playerDto.getLastname())){
     errors.add("please enter the lastname of player");
    }
     if(playerDto == null || !StringUtils.hasLength(playerDto.getName())){
     errors.add("please enter the Name of player");
    }
    if(playerDto == null || !StringUtils.hasLength(String.valueOf(playerDto.getNumber()))){
     errors.add("please enter the Number of player, This number must be unique");
    }
    if(playerDto == null || !StringUtils.hasLength((playerDto.getPosition()).toString())){
     errors.add("please the player's position from the following positions: defenseman, forward, goaltender");
    }
     if(playerDto == null || !StringUtils.hasLength(playerDto.getIsCaptain().toString())){
     errors.add("please specify whether it is a captain or not");
    }
     
     return errors;
    }
    
}
