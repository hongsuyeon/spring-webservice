package com.hongsu.springwebservice.service;

import com.hongsu.springwebservice.domain.posts.PostRepository;
import com.hongsu.springwebservice.domain.posts.Posts;
import com.hongsu.springwebservice.web.dto.PostUpdateRequestDto;
import com.hongsu.springwebservice.web.dto.PostsListResponseDto;
import com.hongsu.springwebservice.web.dto.PostsResponseDto;
import com.hongsu.springwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postsRepository;

    public Long save(PostsSaveRequestDto post){
       return postsRepository.save(post.toEntity()).getId();
    }

    @Transactional//(readOnly = true)
    public List<PostsListResponseDto>  findAllDesc() {
        return postsRepository.findAll().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }
    
    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=>"+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id; 
    }

    @Transactional//(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
