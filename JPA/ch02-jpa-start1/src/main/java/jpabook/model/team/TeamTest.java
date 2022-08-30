package jpabook.model.team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

class TeamTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        teamTest(em);
        queryLogicJoin(em);
        updateRelation(em);
        deleteRelation(em);
        em.close();
    }

    private static void deleteRelation(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);
        tx.commit();
    }

    private static void teamTest(EntityManager em) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team = new Team("team1", "팀1");
        em.persist(team);
        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team);
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team);

        em.persist(member2);
        tx.commit();
    }

    private static void queryLogicJoin(EntityManager em) {
        String jpql = "select m from Member m join m.team t where t.name=:teamName";
        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for (Member member : resultList) {
            System.out.println("[query] member.username=" +  member.getUsername());
        }
    }

    private static void updateRelation(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
        tx.commit();
    }
}