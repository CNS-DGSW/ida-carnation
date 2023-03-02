package com.dgsw.cns.user.vo.certification;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 리프레시 토큰을 담는 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class RefreshTokenVO {

    @NotBlank
    private final String refreshToken;

}
