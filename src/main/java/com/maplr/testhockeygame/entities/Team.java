
package com.maplr.testhockeygame.entities;
import java.io.Serializable;
import java.util.Collection;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "team")
public class Team extends AbstractEntity implements Serializable{

    private String coach;
   //on ne peut pas avoir plusieurs equipe la même année, d'ou l'unicité du paramètre year
    @Column(unique = true)
    private long year;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Collection<Player> players;
}