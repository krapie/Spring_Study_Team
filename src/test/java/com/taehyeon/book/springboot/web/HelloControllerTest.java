package com.taehyeon.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)    //잘 모르겠음
@WebMvcTest(controllers = HelloController.class)    //여러스프링 어노테이션중 Web(Spring MVC)에 집중할 수 있게하는 것
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 Bean을 주입받는다
    private MockMvc mvc;    //웹 API테스트시 사용, 스프링MVC테스트의 시작점, 이 클래스를 통해 HTTP GET, POST등에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        //JSONParser content;
        mvc.perform(get("/hello"))  //MockMvc를 통해 /hello 주소로 HTTP GET요청을 합니다
                .andExpect(status().isOk())     //mve.perform의 결과를 검증, (200, 404, 500등의 상태 검증)
                .andExpect(content().string(hello));    //mvc.perform의 결과를 검증, Controller에서 "hello"를 리턴하기 때문에 이값이 맞는지 검증
    }

    //추가
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name",name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}