package com.example.codestates.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class CommentDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotNull
        private String context;
        private String nickname;
    }
    @Getter
    public static class Patch{
        private Long commentId;
        private String context;

        public void setContext(Long commentId){
            this.context =context;
        }
    }

}
