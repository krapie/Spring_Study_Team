package kom.komputer.springstudy.springboot.web;

import kom.komputer.springstudy.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자(SpringRunner)를 실행시키는 어노테이션
@WebMvcTest(controllers = HelloController.class) // Web(Spring MVC) 테스트 어노테이션
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 웹 API 를 테스트할 때 사용하는 mock 오브젝트, 이를 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트가 가능함

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param(("amount"), String.valueOf(1000)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name)))
            .andExpect(jsonPath("$.amount", is(amount)));
    }
}
