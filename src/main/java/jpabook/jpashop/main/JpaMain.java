package jpabook.jpashop.main;


import hellojpa.Item2;
import hellojpa.Movie2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
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

            Adress adress = new Adress("1", "2", "3");
            Member member = new Member();
            member.setName("hello");
            member.setAdress(adress);
            member.setPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("치킨2");
            member.getFavoriteFoods().add("치킨3");

            member.getAdresseHistory().add(new AdressEntity(adress));
            member.getAdresseHistory().add(new AdressEntity(new Adress("4","5","6")));
            em.persist(member);
            //setter 제거해서 불변객체로 생성자 초기화만 가능하게 변경
//            member.getAdress().setCity("newCity");
//            Adress newaAdress = new Adress("newCity", adress.getStreet(), adress.getZipcode());
//            member.setAdress(newaAdress);
            em.flush();
            em.clear();
            System.out.println(" ===============");
            Member findMember = em.find(Member.class, member.getId());
            Adress newaAdress = new Adress("newCity", adress.getStreet(), adress.getZipcode());
            findMember.setAdress(newaAdress);

//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
            //equals hashcode 로 컬렉션이 찾아올것
            System.out.println(" =============== up");
//            findMember.getAdresseHistory().remove(new AdressEntity(new Adress("4","5","6")));
//            findMember.getAdresseHistory().add(new AdressEntity(new Adress("city2","5","6")));

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
