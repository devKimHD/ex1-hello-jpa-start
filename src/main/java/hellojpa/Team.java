package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity2{
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
//    @OneToMany(mappedBy = "team") //반대편 연관에 대한 변수명적기
    private List<MemberOld> members = new ArrayList<>();

    public List<MemberOld> getMembers() {
        return members;
    }

    public void setMembers(List<MemberOld> members) {
        this.members = members;
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

//    public void addMember(MemberOld memberOld) {
//        memberOld.setTeam(this);
//        members.add(memberOld);
//    }

//    @Override
//    public String toString() {
//        return "Team{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", members=" + members +
//                '}';
//    }
    //실무에서 엔티티 반환하지 말기 무한 루프 걸릴수 있음 서로 참조하기때문에
}
