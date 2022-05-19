package com.taehyeon.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication // 스프링부트의 자동설정, 스프링 bean읽기와 생성을 모두 자동으로 설정, 프로젝트의 최상단에 위치해야함
//@EnableJpaRepositories(basePackageClasses = PostsRepository.class)
//@EntityScan(basePackageClasses = Posts.class)
//@ComponentScan(basePackages={"com.taehyeon.book.springboot.domain"})
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args); //내장 was실행
    }
}
//내장 was를 사용할 수 있으며 이를 권장한다(스프링부트에서), 장점은 외장 WAS에 비해 언제 어디서나 같은 환경에서
//스프링 부트를 배포할 수 있기 때문이다.

//test