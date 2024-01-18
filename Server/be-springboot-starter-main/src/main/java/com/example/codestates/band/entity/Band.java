package com.example.codestates.band.entity;

import com.example.codestates.audit.Auditable;
import com.example.codestates.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Band extends Auditable {

    @Id //엔티티의 기본키임을 명시함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키의 자동생성을 지정하는 어노베이션.
    private Long bandId;

    @Column(length = 100, nullable = false)
    private String school; //학교명

    @Column(length = 100, nullable = false)
    private String schoolCode; //학교등급

    @Column(nullable = false)
    private int grade; //학년

    @Column(nullable = false)
    private int banNumber; //반

    @Column(length = 300, nullable = false)
    private String joinPass; // 반 가입 신청에 관련한 비밀번호

//    @Column(length = 100, nullable = false)
//    private String userName; // 신청자 성명


    @ManyToOne
    @JoinColumn(name = "MEMBER_NICKNAME") // Member 테이블에서 참조할 외래키의 이름
    private Member member;


    @OneToMany(mappedBy = "band", cascade = CascadeType.PERSIST)
    private List<BandJoinList> bandJoinLists = new ArrayList<>();


    //반 신청 상태에 대한 코드
    @Enumerated(value = EnumType.STRING)
    @Column(length = 200, nullable = false)
    private StatusUpdate statusUpdate = StatusUpdate.ApplicationCompleted; //기본값으로 신청완료를 나타냄.


    public enum StatusUpdate  {

        ApplicationCompleted("신청완료"), //신청완료
        ApplicationPending("개설중"), //개설중
        SignUp("가입하기"); // 가입하기

        @Getter
        private String status;

        StatusUpdate(String status) {
            this.status = status;
        }


    }



}
