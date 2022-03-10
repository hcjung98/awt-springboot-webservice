package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 Json을 반환하는 컨트롤러로 만듬
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/sorry")
    public String sorry() {
        return "sorry";
    }

    @GetMapping("/hello/dto") // Rest Get 요청을 받을 수 있는 API1
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
    
    //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
}
