package hellojpa;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Member;

import java.time.LocalDateTime;

@Entity
public class MemberProduct {

    @Id @GeneratedValue
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private MemberOld memberOld;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private int count;
    private int price;
    private LocalDateTime orderdateTime;

}
