package com.taehyeon.book.springboot.service;

import com.taehyeon.book.springboot.web.dto.PostsSaveRequestDto;
import domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor    //final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성 (얘가 다 해줌)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
