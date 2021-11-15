
package com.maplr.testhockeygame.repositories;

import com.maplr.testhockeygame.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TeamRepository extends JpaRepository<Team, Long>{
    
    public Team  findByYear(long year);
    
    @Query("select  t \n" +
        "from com.maplr.testhockeygame.entities.Team t, com.maplr.testhockeygame.entities.Player p \n" +
        "where p.id = :id \n" +
        "and t.id = p.team.id "
    )
    public  Team findTeamByPlayerId(@Param("id") Long id);
    
}
