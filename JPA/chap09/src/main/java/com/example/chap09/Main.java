package com.example.chap09;

import com.example.chap09.start.Address;
import com.example.chap09.start.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by 1001218 on 15. 4. 5..
 */
@Slf4j
public class Main {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
            logic(em);
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    private static void logic(EntityManager em) {
        Member member = new Member();
        member.getFavoriteFoods().add("짬뽕");
        member.getFavoriteFoods().add("짜장");
        member.getFavoriteFoods().add("탕수육");

        member.getAddressHistory().add(new Address("서울"));
        member.getAddressHistory().add(new Address("경기"));
        member.getAddressHistory().add(new Address("인천"));
        em.persist(member);

    }
}
