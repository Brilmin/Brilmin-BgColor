package com.example.codestates.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        private String nickName;
        private String password;
        private String email;

    }
    @Getter
    public static class Patch{
        private Long memberId;
        private String nickName;


        public void setMemberId(Long memberId){
            this.memberId =memberId;
        }
    }
}
