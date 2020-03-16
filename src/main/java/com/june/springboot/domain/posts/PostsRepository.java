package com.june.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository Layer 데이터 저장소에 접근하는 영역.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
