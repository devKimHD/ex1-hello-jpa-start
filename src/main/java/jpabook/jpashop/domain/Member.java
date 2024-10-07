package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    private String name;

    @Embedded
    private Period period;
    @Embedded
    private Adress adress;
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY"))
//            ,@AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//            ,@AttributeOverride(name = "street", column = @Column(name = "WORK_STREET"))
//    })
//    private Adress workadress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")// 컬럼이 하나라서 예외적으로 가능
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS_HISTORY", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Adress> adresseHistory = new ArrayList<>();

    //실무에서 1대 다로
    //값타입 처럼 설정 걸기
    @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AdressEntity> adresseHistory = new ArrayList<>();

    public List<AdressEntity> getAdresseHistory() {
        return adresseHistory;
    }

    public void setAdresseHistory(List<AdressEntity> adresseHistory) {
        this.adresseHistory = adresseHistory;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

//    public List<Adress> getAdresseHistory() {
//        return adresseHistory;
//    }
//
//    public void setAdresseHistory(List<Adress> adresseHistory) {
//        this.adresseHistory = adresseHistory;
//    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
