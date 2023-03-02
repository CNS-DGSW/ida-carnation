package com.dgsw.cns.user.vo.certification;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 엑세스, 리프레시 토큰을 반환하는 클래스 <br>
 * 반드시 반환용으로 사용할 것!
 */
@Getter
@RequiredArgsConstructor
public class TokenVO {

    @NotBlank
    private final String accessToken;

    @NotBlank
    private final String refreshToken;

}
