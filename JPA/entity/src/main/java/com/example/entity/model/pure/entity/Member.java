package com.example.entity.model.pure.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MEMBER_SAMPLE")
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
