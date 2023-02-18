package com.dgsw.cns.user.api;

import com.dgsw.cns.user.spi.UserInfoSpi;
import com.dgsw.cns.user.usecase.UserInfoUseCase;
import com.dgsw.cns.user.vo.MemberInfoVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 순수 JUnit 만을 사용한 테스트이므로 굳이 실패와 동시에 성공 테스트까지 작성할 필요는 없습니다.
 * 물론, @Service 어노테이션이 포함된 클래스를 테스트해야하는 경우, 반드시 실패와 성공 테스트 둘 다 작성해야만 합니다.
 */
class UserInfoApiTest {

    private static final String NAME = "name";
    private static final String BIRTH = "2023-02-18";
    private static final String GENDER = "MALE";
    private static final String TELEPHONE = "010-1111-2222";

    private final UserInfoSpi spi =
            id -> new MemberInfoVO(NAME, BIRTH, GENDER, TELEPHONE);
    private final UserInfoApi api = new UserInfoUseCase(spi);

    @Test
    @DisplayName("회원 정보 조회")
    void findUserById() {
        // given
        final long memberId = 1L;

        // when
        MemberInfoVO infoVO = api.getUserInfo(memberId);

        // verify
        assertThat(infoVO).isNotNull();
        assertThat(infoVO.getName()).isEqualTo(NAME);
        assertThat(infoVO.getBirth()).isEqualTo(BIRTH);
        assertThat(infoVO.getGender()).isEqualTo(GENDER);
        assertThat(infoVO.getTelephone()).isEqualTo(TELEPHONE);
    }

}
