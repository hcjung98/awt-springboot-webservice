package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함
public abstract class BaseTimeEntity {
    //  모든 Entity의 상위 클래스가 되어 Entity등의 createdDate, ModifiedDate들 자동으로 관리하는 역할

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동으로 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 때 시간이 자동으로 저장
    private LocalDateTime modifiedDate;
}
