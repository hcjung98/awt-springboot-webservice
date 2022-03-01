package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Main Class
@EnableJpaAuditing //JPA Auditing 어노테이션들을 모두 활성화
@SpringBootApplication // springboot의 자동설정, 스프링 bean 읽기와 생성을 자동으로 설정,
                        // 여기부터 설정을 읽기 시작, 프로젝트의 최상단에 위치
                        // 내장 WAS 실행
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
