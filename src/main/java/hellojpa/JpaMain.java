package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
////
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);
//            Member findMember = em.find(Member.class, 2L);
//            System.out.println("findMember"+findMember.getName());
//            System.out.println("findMember"+findMember.getId());
//            findMember.setName("nameUp");
//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(5)
//                    .getResultList();
//            for (Member member : resultList) {
//                System.out.println("member "+member.getName());
//                }
            //비영속
//            Member member = new Member();
//            member.setName("nameJpa");
//            member.setId(101L);
            //
            //영속
//            System.out.println("==Before==");
//            em.persist(member);
//            System.out.println("==After==");

//            Member member1 = em.find(Member.class, 101L);
//            Member member2 = em.find(Member.class, 101L);
//            System.out.println(member1 == member2);
//            Member memberA = new Member(150L, "A");
//            Member memberB = new Member(160L, "B");
//            em.persist(memberA);
//            em.persist(memberB);
//            System.out.println("=========================");
//            Member member = em.find(Member.class, 150L);
////            member.setName("A-Edit");
//            member.setName("A-Edit2");
////            em.detach(member);
//            em.clear(); // 1차캐시 다 비움
//            Member member2 = em.find(Member.class, 150L);
//            System.out.println("=========================");

//            Member member = new Member(200L, "newMem");
//            em.persist(member);
//            em.flush();
//            System.out.println("tx before");
            Member member = new Member();
//            member.setId("usr_A");
            member.setUsername("usr_nm1");
            em.persist(member);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            em.close();
        }
        //code
        emf.close();
    }
}
