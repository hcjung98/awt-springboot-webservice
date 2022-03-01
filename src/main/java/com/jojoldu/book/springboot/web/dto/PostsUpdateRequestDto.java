package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 클래스 내 모든 필드의 getter 메소드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
/*
    복합 객체의 생성과정과 표현방법을 분리하여 동일한 생성절차에서 서로 다른 표현결과를 만들수 있게 하는 패턴
    빌더 패턴은 setter 메소드가 없는 객체를 생성하여 변경 불가능하게 하는데 좋다.
    한번 만들어진 객체를 이리저리 수정하지 못하게 고정시켜놓음으로써 제 역할을 다할수 있도록 돕는것이 빌더 패턴이다.

    변경 불가능하게 만드는 이유는 변수가 공유되면서 발생할 문제를 사전에 예방하는 것이다.
*/

}
