package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        PersistenceUnitUtil persistenceUnitUtil = emf.getPersistenceUnitUtil();
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
            Team team = new Team();
            team.setName("teamA");
//            team.getMembers().add(memberOld);

            Team teamB = new Team();
            teamB.setName("teamB");
//            teamB.getMembers().add(memberOld2);
            em.persist(teamB);
            em.persist(team);
            MemberOld memberOld = new MemberOld();
            memberOld.setUsername("member1");
            memberOld.setTeam(team);
            memberOld.setCreatedBy("adm");
            memberOld.setCreatedDate(LocalDateTime.now());
            em.persist(memberOld);

            MemberOld memberOld2 = new MemberOld();
            memberOld2.setUsername("member2");
            memberOld2.setCreatedBy("adm");
            memberOld2.setTeam(teamB);
            memberOld2.setCreatedDate(LocalDateTime.now());
            em.persist(memberOld2);

            em.flush();
            em.clear();
            List<MemberOld> resultList = em.createQuery("select m from MemberOld m").getResultList();
//            MemberOld findM = em.find(MemberOld.class, memberOld.getId());
//            MemberOld findM = em.getReference(MemberOld.class, memberOld.getId());
//            System.out.println("findM.getClass() = " + findM.getClass());
//            System.out.println("findM.getId() = " + findM.getId());
//            //아이디는 이미 저장되 있어 DB접근 필요 없으나 나머지는 없기에 DB접근 시작
//            System.out.println("findM.getName() = " + findM.getUsername());
////            printMemberAndTeam(findM);
//            printMember(findM);
//            System.out.println("findM.getClass()2 = " + findM.getClass());

//            MemberOld refMember = em.getReference(MemberOld.class, memberOld.getId());
//            System.out.println("findM.getClass() = " + refMember.getClass());
//            System.out.println("persistenceUnitUtil.isLoaded() = " + persistenceUnitUtil.isLoaded(refMember));
//            refMember.getUsername();// force init
//            Hibernate.initialize(refMember);// force init
//            em.detach(refMember);
//            em.clear();
//            String username = refMember.getUsername();//proxy init
//            System.out.println(username);

            MemberOld findMember = em.find(MemberOld.class, memberOld.getId());
//            System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass());
//            System.out.println("===============================");
//            findMember.getTeam();
//            System.out.println("===============================");
//            System.out.println("findMember.getTeam().getName()= " + findMember.getTeam().getName());
//            System.out.println("reference.getClass() = " + findMember.getClass());
//            System.out.println("(reference==findM) = " + (findMember==refMember));
//            MemberOld findM2 = em.getReference(MemberOld.class, memberOld2.getId());
//            memberOld.logicSout(findM, findM2);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            em.close();
        }
        //code
        emf.close();
    }

    private static void printMember(MemberOld findM) {
        String userName= findM.getUsername();
        System.out.println("userName = " + userName);
    }

    private static void printMemberAndTeam(MemberOld findM) {
        String userName= findM.getUsername();
        System.out.println("userName = " + userName);
        System.out.println("team = " + findM.getTeam().getName());
    }
}
