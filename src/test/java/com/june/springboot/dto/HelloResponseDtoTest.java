package com.june.springboot.dto;

import com.june.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given 주어지는
        String name = "test";
        int amount = 1000;

        //when 언제
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then 그 다음에
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
