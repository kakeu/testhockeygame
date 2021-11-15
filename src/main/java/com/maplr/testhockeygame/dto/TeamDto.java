
package com.maplr.testhockeygame.dto;

import com.maplr.testhockeygame.entities.Player;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    
    private Long id;
    private String coach;
    private long year;
    private Collection<PlayerDto> players;
    
}
