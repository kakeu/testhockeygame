
package com.maplr.testhockeygame.web;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entities.Position;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.exception.RessourceNotFoundException;
import com.maplr.testhockeygame.services.IService;
import com.maplr.testhockeygame.services.ServiceImpl;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author doumtsop
 */
@RestController
@RequestMapping(path = "/api")
public class HockeyRestController {
    
    private IService iService;

    public HockeyRestController(IService iService) {
        this.iService = iService;
    }
    
    @GetMapping(path = "/team/{year}")
    public ResponseEntity<Object> getTeamByYear(@PathVariable long year){
        TeamDto team = iService.findTeamByYear(year);
            return ResponseEntity.status(HttpStatus.OK).body(team);
    }
    
    @PostMapping(path = "/team/{year}")
    public ResponseEntity<Object> addPlayerToTeam(@RequestBody PlayerDto playerDto, @PathVariable long year){
            PlayerDto playerDto1 = iService.addPlayerToTeam(playerDto, year);
            return ResponseEntity.status(HttpStatus.CREATED).body(playerDto1);
    }
        
    @PutMapping(path = "/player/captain/{id}")
    public PlayerDto updateTeam(@PathVariable Long id){
        return iService.setNewCapitain(id);
    }
    
    @PostMapping(path = "/teams")
    public TeamDto createTeam(@RequestBody TeamDto teamDto){
        return iService.CreateTeam(teamDto);
    }
    
    @GetMapping(path = "/teams")
    public List<TeamDto> getAllTeam(){
        return iService.findAllTeam();
    }
    
    @GetMapping(path = "/teams/{id}")
    public TeamDto getTeamById(@PathVariable Long id){
        return iService.findTeamById(id);
    }
    
    @PutMapping(path = "/teams/{id}")
    public TeamDto updateTeam(@PathVariable Long id, @RequestBody TeamDto teamDto){
        return iService.updateTeam(teamDto);
    }
   
    @PostMapping(path = "/players")
    public PlayerDto createPlayer(@RequestBody PlayerDto playerDto){
        return iService.CreatePlayer(playerDto);
    }
    
    @GetMapping(path = "/players")
    public List<PlayerDto> getAllPlayer(){
        return iService.findAllPlayer();
    }
    
    @GetMapping(path = "/players/{id}")
    public PlayerDto getPlayerById(@PathVariable Long id){
        return iService.findPlayerById(id);
    }
    
    @PutMapping(path = "/players/{id}")
    public PlayerDto updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto){
        return iService.updatePlayer(playerDto);
    }
    
}
