package com.jojoldu.book.springboot.web.web;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // 테스트를 진행할때 Juint에 내장된 실행자
                             // 스프링 부트와 Junit 사이의 연결자
@WebMvcTest(controllers = HelloController.class) // Web에 집중된 어노테이션
public class HelloControllerTest {

    @Autowired // 빈 주입
    private MockMvc mvc; // Web API를 테스트할때 사용, 스프링 MVC 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
        // MockMvc를 통해 /hello 주소로 HTTP GET 요철
        // 체이닝 지원, 여러 검증을 이어서 가능
        // isOk = 200 (status), 내용 (content) hello 인지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
