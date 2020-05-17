package com.june.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() throws Exception {
        //given 정해진
        String title = "테스트 게시글1";
        String content = "테스트 본문1";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("fnffn0607@naver.com")
                .build());

        //when 언제
        //모든 데이터를 조회하는 것. findAll
        List<Posts> postsList = postsRepository.findAll();

        //then 그리고나서
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {

        LocalDateTime now = LocalDateTime.of(2020,05,15,11,59,0);
        postsRepository.save(Posts.builder().title("제목").content("생성시간 테스트").author("작성자 최하준").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);


        System.out.println("========================>>> createTime : " + posts.getCreateDate() + ", 수정날짜 modifiedDate : " + posts.getModifiedDate());

        assertThat(posts.getCreateDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));



    }



}