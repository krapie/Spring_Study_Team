package com.jojoldu.book.dto;

import com.jojoldu.book.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amout = 1000;


    //when
    HelloResponseDto dto = new HelloResponseDto(name, amout);

    //then
    assertThat(dto.getName()).
    isEqualTo(name);
    assertThat(dto.getAmount()).
    isEqualTo(amout);
    }
}
