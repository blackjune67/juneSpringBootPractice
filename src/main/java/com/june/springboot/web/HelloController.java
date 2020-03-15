package com.june.springboot.web;

import com.june.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        //외부에서 API 로 넘긴 파라미터를 가져오는 어노테이션.
        //외부에서 name @RequestParam("name") 이라는 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name) 에 저장한다.
        System.out.println(">>>>> DTO : " + name + amount);
        return new HelloResponseDto(name, amount);
    }


}
