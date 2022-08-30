package jpabook.model.team;

import lombok.*;

import javax.persistence.*;

@Table(name = "MEMBER")
@Data
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
