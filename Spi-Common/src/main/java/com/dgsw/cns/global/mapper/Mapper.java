package com.dgsw.cns.global.mapper;

/**
 * Domain 클래스를 Entity 클래스로, Entity 클래스를 Domain 클래스로 변환해주는 인터페이스 <br>
 * 반드시 각각의 타입은 변환이 가능한 형태이어야 합니다.
 * @param <T> Domain 모듈에 위치한 Domain 클래스
 * @param <S> SPI 모듈에 위치한 Entity 클래스
 */
public interface Mapper<T, S> {

    /**
     * Domain 클래스를 인자로 Entity 클래스로 변환합니다.
     * @param domain Domain 인스턴스를 인자로 받습니다.
     * @return Entity 클래스를 반환합니다.
     */
    S domainToEntity(T domain);

    /**
     * Entity 클래스를 인자로 Domain 클래스로 변환합니다.
     * @param entity Entity 인스턴스를 인자로 받습니다.
     * @return Domain 클래스를 반환합니다.
     */
    T entityToEntity(S entity);

}
