package com.example.codestates.member.entity;

import com.example.codestates.bgcolor.entity.BgColor;
import com.example.codestates.mbti.entity.Mbti;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 6, unique = true)
    private String nickName;    //닉네임

    @Column(nullable = false)
    private String password;

    private String role = "USER";

    @ManyToOne
    @JoinColumn(name = "bgcolor_id")
    private BgColor bgColor;    //닉네임 배경색

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    private Mbti mbti;

}
