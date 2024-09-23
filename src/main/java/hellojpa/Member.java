package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name="MEMBER")
//@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq")
public class Member {


    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;
//    private Integer age;
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;
//    @Transient
//    private int tempData;
    public Member()
    {
        //jpa 동적 객체 관리 위해 기본 생성자 추가
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
