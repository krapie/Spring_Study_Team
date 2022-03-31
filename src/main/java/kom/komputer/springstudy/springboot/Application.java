package kom.komputer.springstudy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 부트의 자동 설정 -> classpath 를 참고하여 스프링 Bean 을 생성함 (ex: spring-webmvc 가 classpath 에 있으면 DispatcherServlet + 내장 WAS(Tomcat)을 자동 설정해줌)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // (웹) 애플리케이션(WAS (Tomcat))을 실행함 -> ApplicationContext 이 생성됨
    }
}
