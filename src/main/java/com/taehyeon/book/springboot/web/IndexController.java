package com.taehyeon.book.springboot.web;

import com.taehyeon.book.springboot.config.auth.dto.SessionUser;
import com.taehyeon.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {


    //@GetMapping("/")
    //public String index(){
    //    return "index";
   // }
//머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정
//즉 여기서는 index를 반환하므로 src/main.resources/templates/index.mustache로 전환되어 View Resolver가 처리하게 된다
    /*
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    */
    private final PostsService postsService;

    /*
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }
    */
    //이거 빠트리지말자
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}

