package kom.komputer.springstudy.springboot.service.posts;

import kom.komputer.springstudy.springboot.domain.BaseTimeEntity;
import kom.komputer.springstudy.springboot.domain.posts.Posts;
import kom.komputer.springstudy.springboot.domain.posts.PostsRepository;
import kom.komputer.springstudy.springboot.web.dto.PostsResponseDto;
import kom.komputer.springstudy.springboot.web.dto.PostsSaveRequestDto;
import kom.komputer.springstudy.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // 스프링이 가장 권장하는 생성자를 통한 Bean 주입을 Lombok 의 RequiredArgsConstructor (자동으로 final 이 선언된 모든 필드를 인자값으로 하는 생성자를 생성함)를 통해 해결함
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id) // JPA 의 영속성 컨텍스트: 트랜잭션 안에서 테이터베이스에서 테이서트를 가져오면 이 테이터는 영속성 컨텍스트가 유지된 상태임
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent()); // 더티 체킹: 영속성 컨텍스트가 유지된 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영함 (별도로 Update 쿼리를 날릴 필요가 없음)

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
