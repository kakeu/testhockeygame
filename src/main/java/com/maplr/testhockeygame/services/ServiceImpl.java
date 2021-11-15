
package com.maplr.testhockeygame.services;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.Position;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.exception.DupplicateNumberException;
import com.maplr.testhockeygame.exception.InvalidEntityException;
import com.maplr.testhockeygame.exception.RessourceNotFoundException;
import com.maplr.testhockeygame.mappers.PlayerMapper;
import com.maplr.testhockeygame.mappers.TeamMapper;
import com.maplr.testhockeygame.repositories.PlayerRepository;
import com.maplr.testhockeygame.repositories.TeamRepository;
import com.maplr.testhockeygame.validators.PlayerValidator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class ServiceImpl implements IService{
    

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    
    private TeamMapper teamMapper;
    private PlayerMapper playerMapper;

    public ServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, TeamMapper teamMapper, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.playerMapper = playerMapper;
    }

    @Override
    public TeamDto CreateTeam(TeamDto teamDto) {
        Team team = teamMapper.fromTeamDto(teamDto);
        team = teamRepository.save(team);
        return teamMapper.fromTeam(team);
    }

    @Override
    public TeamDto findTeamById(Long id) {
        Team team = teamRepository.getById(id);
        if(team ==null || (team.toString()).isEmpty()){
        throw new RessourceNotFoundException("Team not found with id:" + id);
        }
        return teamMapper.fromTeam(team);
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        Team team = teamRepository.getById(teamDto.getId());
        team = teamRepository.save(team);
        return teamMapper.fromTeam(team);
    }

    @Override
    public List<TeamDto> findAllTeam() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> teamMapper.fromTeam(team))
                .collect(Collectors.toList());
    }

    @Override
    public TeamDto findTeamByYear(long year) {
        Team team = teamRepository.findByYear(year);
        if(team ==null || (team.toString()).isEmpty()){
        throw new RessourceNotFoundException("Team not found in:" + year);
        }
        return teamMapper.fromTeam(team);
    }

    @Override
    public PlayerDto CreatePlayer(PlayerDto playerDto) {
        Player player = playerMapper.fromPlayerDto(playerDto);
        Optional<Team> teams = teamRepository.findById(playerDto.getTeamId());
        player.setTeam(teams.get());
        player = playerRepository.save(player);
        return playerMapper.fromPlayer(player);
    }

    @Override
    public PlayerDto findPlayerById(Long id) {
         Player player = playerRepository.getById(id);
        if(player ==null || (player.toString()).isEmpty()){
        throw new RessourceNotFoundException("Player not found with id:" + id);
        }
         return playerMapper.fromPlayer(player);
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        Player player = playerRepository.getById(playerDto.getId());
        if(player ==null || (player.toString()).isEmpty()){
        throw new RessourceNotFoundException("The player you want to update does not exist");
        }
        player = playerRepository.save(player);
        return playerMapper.fromPlayer(player);
    }

    @Override
    public List<PlayerDto> findAllPlayer() {
        List<Player> players = playerRepository.findAll();
        
        return players.stream()
                .map(player -> playerMapper.fromPlayer(player))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDto addPlayerToTeam(PlayerDto playerDto, long year) {
        
      
        List<String> errors = PlayerValidator.validate(playerDto);
        if(!errors.isEmpty()){
         throw new InvalidEntityException("player is not valide", errors);
        }
        Team team = teamRepository.findByYear(year);
        if(team ==null){
        throw new RessourceNotFoundException("You cannot add a player to a team that does not exist in :" + year);
        }
        
        Player player = playerMapper.fromPlayerDto(playerDto);
        player.setTeam(team);
        
         List<Player> players = playerRepository.findPlayerByNumberAndTeam(team.getId(), player.getNumber());
        
        if(players.isEmpty()){
         player = playerRepository.save(player);
         
        }else{
       
            throw new DupplicateNumberException("there is already a player with this number :" + player.getNumber());
        }
       
        return playerMapper.fromPlayer(player);
    }

    @Override
    public PlayerDto setNewCapitain(Long id) {
        Team team = teamRepository.findTeamByPlayerId(id);
        if(team ==null){
        throw new RessourceNotFoundException("Player does not belong to any team so he cannot be captain");
        }
        Player player = playerRepository.findCapitainByTeamId(team.getId());
        
        if(player ==null){
        throw new RessourceNotFoundException("The team to which the player belongs does not have a captain");
        }
        player.setIsCaptain(Boolean.FALSE);
        playerRepository.save(player);
        Optional<Player> player1 = playerRepository.findById(id);
        Player p = player1.get();
        p.setIsCaptain(Boolean.TRUE);
        p = playerRepository.save(p);
        return playerMapper.fromPlayer(p);
    }
    
}
