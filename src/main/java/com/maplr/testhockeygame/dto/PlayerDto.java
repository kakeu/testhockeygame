
package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.maplr.testhockeygame.entities.Position;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    @JsonIgnore
    private Long id;
    private long number;
    private String  name;
    private String  lastname;
    private Position position;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Boolean isCaptain;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long teamId;
    
    
    
    
}
