package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="MEMBER")
//@SequenceGenerator(name="member_seq_generator", sequenceName = "member_seq")
public class MemberOld extends BaseEntity2 {


    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;


    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID",insertable = false,updatable = false) // 읽기 전용으로 강제함
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "memberOld")
    private List<MemberProduct> memberProducts = new ArrayList<>();
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        //연관관계 편의성 메소드 실수방지
//        team.getMembers().add(this);
//    }
//
//    @ManyToOne
//    @JoinColumn(name="TEAM_ID")
//    private  Team team;
//    @Column(name="TEAM_ID")
//    private Long teamId;
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
    public MemberOld()
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

    @Override
    public String toString() {
        return "MemberOld{" +
                "id=" + id +
                ", username='" + username + '\'' +
//                ", team=" + team +
                '}';
    }
}
