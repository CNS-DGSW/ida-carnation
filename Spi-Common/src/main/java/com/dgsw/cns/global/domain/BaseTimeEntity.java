package com.dgsw.cns.global.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class BaseTimeEntity<Entity extends Serializable>
        extends BaseIdEntity<Entity> {

    @CreatedDate
    private final LocalDateTime createAt = LocalDateTime.now();

}
