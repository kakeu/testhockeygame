
package com.maplr.testhockeygame.services;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import java.util.List;
import java.util.Optional;


public interface IService {
  
    public TeamDto CreateTeam(TeamDto teamDto);
    public TeamDto findTeamById(Long id);
    public TeamDto updateTeam(TeamDto teamDto);
    public List<TeamDto> findAllTeam();
    public TeamDto findTeamByYear(long year);
    
    public PlayerDto CreatePlayer(PlayerDto playerDto);
    public PlayerDto findPlayerById(Long id);
    public PlayerDto updatePlayer(PlayerDto playerDto);
    public List<PlayerDto> findAllPlayer();
    public PlayerDto addPlayerToTeam(PlayerDto playerDto, long year);
    public PlayerDto setNewCapitain(Long id);
    
}
