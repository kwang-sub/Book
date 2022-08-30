package com.example.entity.model.pure.entity;

import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {
    @PersistenceUnit
    EntityManagerFactory emf;
    @PersistenceContext
    EntityManager em;

    @Test
    void testSave() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team = new Team("team1", "팀1");
        em.persist(team);

        Member member1 = new Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        member1.setTeam(team);
        em.persist(member1);

        Member member2 = new Member();
        member2.setId("member1");
        member2.setUsername("회원1");
        member2.setTeam(team);
        em.persist(member2);
        tx.commit();
        em.close();

    }
}