
package com.maplr.testhockeygame.repositories;
import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.Team;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PlayerRepository extends JpaRepository<Player, Long>{
    
    
    @Query("select  p \n" +
        "from com.maplr.testhockeygame.entities.Team t, com.maplr.testhockeygame.entities.Player p \n" +
        "where t.id = :id \n" +
        "and t.id = p.team.id and p.isCaptain = true"
    )
    public  Player findCapitainByTeamId(@Param("id") Long id);
    
    
    @Query("select  p \n" +
        "from com.maplr.testhockeygame.entities.Team t, com.maplr.testhockeygame.entities.Player p \n" +
        "where t.id = :id \n" +
        "and p.number = :number \n" +
        "and t.id = p.team.id"
    )
    public List<Player> findPlayerByNumberAndTeam(@Param("id") Long id, @Param("number") long number);
    
}
