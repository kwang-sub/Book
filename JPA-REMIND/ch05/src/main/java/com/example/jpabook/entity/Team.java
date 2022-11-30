package com.example.jpabook.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;
}
