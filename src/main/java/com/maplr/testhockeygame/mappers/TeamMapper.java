
package com.maplr.testhockeygame.mappers;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entities.Team;
import java.util.Optional;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TeamMapper {
    Team fromTeamDto(TeamDto teamDto);
    TeamDto fromTeam(Team team);
}
