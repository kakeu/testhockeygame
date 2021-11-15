
package com.maplr.testhockeygame.mappers;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.Team;
import java.util.Optional;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PlayerMapper {
    Player fromPlayerDto(PlayerDto playerDto);
    PlayerDto fromPlayer(Player player);
}
