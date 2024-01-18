package com.example.codestates.band.dto;


import com.example.codestates.member.dto.MemberDto;
import lombok.Getter;
import lombok.NonNull;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;




@Getter
public class BandPostDto {

    @NotBlank
    private String school;//학교명

    @NotBlank
    private String schoolCode;// 초등학교, 중학교, 고등학교


    @Range(min=1, max = 6)
    private int grade; //학년 초등학교 선택시 1~6까지만.7이상 불가. 중고등학교 선택시 1~3학년까지만 4이상불가.

    @Range(min=1, max = 15) // 1~15반까지 생성가능.
    private int banNumber;//반

    @NotBlank
    //@Pattern() 현재 미설정
    private String joinPass; //반 가입 신청시 비밀번호

    private String nickName;

//    private String userName; // 신청자 성명


    //  @NotBlank는 문자열 타입.. integer에 붙이면 에러남.


    }//postDto


