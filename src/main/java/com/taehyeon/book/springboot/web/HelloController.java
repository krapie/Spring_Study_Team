package com.taehyeon.book.springboot.web;

import com.taehyeon.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러와 관련된 클래스들은 모두 web패키지에 담는다
@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
public class HelloController {

    @GetMapping("/hello")   //HTTP 메소드인 GET의 요청을 받을 수 있는 API를 만들어 준다
    public String hello(){

        return "hello";
    }

    //추가
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name,amount);
    }
}