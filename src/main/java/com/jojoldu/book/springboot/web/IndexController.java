package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
        // 컨트롤러에서 문자열을 반환할때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    // 수정할 데이터 조회하는 API로 PostsApiController에 정의하지 않고 IndexController에 정의
    // 해당 게시물을 조회해서 수정페이지에 로딩 
    @GetMapping("/posts/update/{id}") 
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
