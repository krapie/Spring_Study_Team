package kom.komputer.springstudy.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { // 인터페이스로 생성 후 JpaRepository 를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됌
}
