package jpabook.model.team;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;
}
