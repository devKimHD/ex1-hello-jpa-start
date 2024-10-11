package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class Delivery extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Adress adress;

    public Long getId() {
        return id;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public Order getOrder() {
        return order;
    }

    public Adress getAdress() {
        return adress;
    }
}
