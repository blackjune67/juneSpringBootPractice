package com.june.springboot.web.dto;

import com.june.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponeseDto {

    private Long id;
    private String title;
    private String content;
    private String author;


    public PostsResponeseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }


}
