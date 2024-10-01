package hellojpa;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            MemberOld memberOld = new MemberOld();
//            memberOld.setUsername("Member1");
//            memberOld.changeTeam(team);
//
////            team.addMember(memberOld);
//            em.persist(memberOld);
//            team.getMembers().add(memberOld);
////            em.flush();
////            em.clear();
//
//            Team team1 = em.find(Team.class, team.getId());//1차 캐시에 team이 있음
//            // 이러면 컬렉션에 값이 없음
//            List<MemberOld> members = team1.getMembers();
//            for (MemberOld member : members) {
//                System.out.println("member = " + member);
//            }
////            MemberOld memberOld1 = em.find(MemberOld.class, memberOld.getId());
////            List<MemberOld> members = memberOld1.getTeam().getMembers();
////            for (MemberOld member : members) {
////                System.out.println("m ="+member);
////            }
            MemberOld memberOld = new MemberOld();
            memberOld.setUsername("member1");
            memberOld.setCreatedBy("adm");
            memberOld.setCreatedDate(LocalDateTime.now());
            em.persist(memberOld);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(memberOld);
            em.persist(team);

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
