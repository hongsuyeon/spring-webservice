package com.hongsu.springwebservice.web;

import com.hongsu.springwebservice.service.PostService;
import com.hongsu.springwebservice.web.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
       model.addAttribute("posts", postService.findAllDesc());
       return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/select/{id}")
    public String selectIdView(@PathVariable Long id, Model model){
        System.out.println("parth ......"+id);
        model.addAttribute("posts", postService.findById(id));
       // model.addAttribute("posts", id);

        return "posts-update";
    }
}
