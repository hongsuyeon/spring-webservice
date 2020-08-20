package com.hongsu.springwebservice.web;

import com.hongsu.springwebservice.domain.posts.PostRepository;
import com.hongsu.springwebservice.domain.posts.Posts;
import com.hongsu.springwebservice.service.PostService;
import com.hongsu.springwebservice.web.dto.HelloResponseDto;
import com.hongsu.springwebservice.web.dto.PostUpdateRequestDto;
import com.hongsu.springwebservice.web.dto.PostsResponseDto;
import com.hongsu.springwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/posts/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }
}
