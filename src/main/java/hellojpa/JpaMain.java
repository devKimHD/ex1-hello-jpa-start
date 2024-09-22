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
            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(5)
                    .getResultList();
            for (Member member : resultList) {
                System.out.println("member "+member.getName());
                }
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
