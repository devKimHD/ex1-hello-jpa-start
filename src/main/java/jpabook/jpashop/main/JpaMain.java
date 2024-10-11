package jpabook.jpashop.main;


import hellojpa.Item2;
import hellojpa.Movie2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpabook.jpashop.domain.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
//            List<Member> resultList = em.createQuery("select m from Member m where m.name like '%kim%'", Member.class)
//                    .getResultList();
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//
//            }
            //Criteria 사용 준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//            //루트 클래스 (조회를 시작할 클래스)
//            Root<Member> m = query.from(Member.class);
//            //쿼리 생성
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"), "kim"));
//            List<Member> resultList = em.createQuery(cq).getResultList();
            Member member = new Member();
            member.setName("usr1");
            em.persist(member);
            //if DB connect direct get -> query execute list
            //no result -> force flush need
//            List<Member> resultList = em.createNativeQuery("select * from MEMBER", Member.class)
//                    .getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1.getName() = " + member1.getName());
//            }
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
