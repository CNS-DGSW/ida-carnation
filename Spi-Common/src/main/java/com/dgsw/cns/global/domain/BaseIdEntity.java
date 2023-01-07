package com.dgsw.cns.global.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * {@link Serializable} 을 구현한 클래스를 id로 갖을 수 있도록 하는 추상 클래스
 * 복합키를 제외한 일반 식별키를 사용하는 엔티티들 대부분이 사용하도록 구성된 클래스
 * @param <T> {@link Serializable} 을 구현한 클래스만 허용하며, 해당 타입을 식별키의 타입으로 결정합니다.
 */
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseIdEntity<T extends Serializable> {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;

}
