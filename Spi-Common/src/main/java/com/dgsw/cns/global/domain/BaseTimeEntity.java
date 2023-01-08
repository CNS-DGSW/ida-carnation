package com.dgsw.cns.global.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 데이터베이스 삽입(추가)할 때 CURRENT_TIMESTAMP 을 default 로 주입되도록 하는 추상 클래스
 * {@link BaseIdEntity} 을 상속하여, {@link Serializable}를 구현한 클래스를 제네릭으로
 * 구현해야한다.
 * @param <T> {@link Serializable}을 구현한 클래스만 허용하며, {@link BaseIdEntity}에
 *                적용되는 param입니다.
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseTimeEntity<T extends Serializable>
        extends BaseIdEntity<T> {

    @CreatedDate
    @Builder.Default
    private final LocalDateTime createAt = LocalDateTime.now();

}
