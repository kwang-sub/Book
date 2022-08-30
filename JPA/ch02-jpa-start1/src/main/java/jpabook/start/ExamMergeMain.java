package jpabook.start;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExamMergeMain {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    public static void main(String[] args) {
        MemberMain member = createMember("memberA", "회원1");
        member.setUsername("회원명 변경");
        mergeMember(member);
    }

    private static MemberMain createMember(String id, String username) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        MemberMain member = new MemberMain();
        member.setId(id);
        member.setUsername(username);
        member.setAge(20);
        em.persist(member);
        tx.commit();
        em.close();
        return member;
    }

    private static void mergeMember(MemberMain member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        MemberMain mergeMember = em.merge(member);
        tx.commit();

        System.out.println("member = " + member.getUsername());
        System.out.println("mergeMember = " + mergeMember.getUsername());

        System.out.println("em contains member = " + em.contains(member));
        System.out.println("em contains mergeMember = " + em.contains(mergeMember));
        em.close();

    }
}
