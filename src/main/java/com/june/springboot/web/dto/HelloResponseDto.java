package com.june.springboot.web.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/*
 * RequireArgsContstructor 은 final 필드가 포함된 생성자를 생성한다.
 */
@RequiredArgsConstructor
@Data
public class HelloResponseDto {

    private final String name;
    private final int amount;

}








