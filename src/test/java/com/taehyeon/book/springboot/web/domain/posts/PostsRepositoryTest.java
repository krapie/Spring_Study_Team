package com.taehyeon.book.springboot.web.domain.posts;


import com.taehyeon.book.springboot.domain.posts.Posts;
import com.taehyeon.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Repository
@RunWith(SpringRunner.class)
@SpringBootTest //별다른 설정없이 사용시  H2 데이터베이스자동실행
public class PostsRepositoryTest {

    @Autowired   //필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다. 생성자,setter,필드 위의 3가지의 경우에 Autowired를 사용할 수 있다.
    PostsRepository postsRepository;

    @After  // Junit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test   //@Test가 선언된 메서드는 테스트를 수행하는 메소드가 된다
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()    //테이블  posts에 insert/update 쿼리를 실행해준다.
                .title(title)
                .content(content)
                .author("tahen922@naver.com")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();  //테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_등록(){

        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>> createDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifiedDate());


        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
