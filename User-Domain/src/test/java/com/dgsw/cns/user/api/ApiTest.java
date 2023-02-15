package com.dgsw.cns.user.api;

import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.Parent;
import com.dgsw.cns.user.spi.UserInfoSpi;
import com.dgsw.cns.user.spi.UserParentSpi;
import com.dgsw.cns.user.spi.UserVeteranSpi;
import com.dgsw.cns.user.usecase.UserInfoUseCase;
import com.dgsw.cns.user.usecase.UserParentUseCase;
import com.dgsw.cns.user.usecase.UserVeteranUseCase;
import com.dgsw.cns.user.vo.MemberInfoVO;
import com.dgsw.cns.user.vo.MemberParentVO;
import com.dgsw.cns.user.vo.MemberVeteranVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 간단한 API 들과 SPI 임의 구현체들이 잘 동작하는 지 테스트한 클래스
// UseCase 테스트는 UseCaseTest 로 진행
class ApiTest {

    @Test
    void userInfoApiTest() {
        // given
        final MemberInfoVO memberInfoVO = new MemberInfoVO("name", "yyyy-mm-dd", "MALE",
                "010-xxxx-zzzz");
        UserInfoSpi userInfoSpi = id -> memberInfoVO;
        UserInfoApi userInfoApi = new UserInfoUseCase(userInfoSpi);

        // when
        final MemberInfoVO data = userInfoApi.getUserInfo(1L);

        // verify
        assertEquals(memberInfoVO, data);
    }

    @Test
    void userParentApiTest() {
        // given
        final MemberParentVO memberParentVO = new MemberParentVO("name", "NOTHING",
                "yyyy-mm-dd", "010-xxxx-zzzz", "address", "detail", (short) 0);
        UserParentSpi userParentSpi = new UserParentSpi() {
            @Override
            public void modifyParentInfo(long id, Parent parent, Address address) {
                // test-skip
            }

            @Override
            public MemberParentVO findParentInfoById(long id) {
                return memberParentVO;
            }
        };
        UserParentApi userParentApi = new UserParentUseCase(userParentSpi);

        // when
        final MemberParentVO data = userParentApi.getParentInfo(1L);

        // verify
        assertEquals(memberParentVO, data);
    }

    @Test
    void userVeteranApiTest() {
        // given
        final MemberVeteranVO memberVeteranVO = new MemberVeteranVO("어디보훈청", "xx-xxxxxx");
        UserVeteranSpi userVeteranSpi = new UserVeteranSpi() {
            @Override
            public MemberVeteranVO getVeteranInfo(long id) {
                return memberVeteranVO;
            }

            @Override
            public void updateVeteranInfo(long id, String department, String veteranId) {
                // test-skip
            }
        };
        UserVeteranApi userVeteranApi = new UserVeteranUseCase(userVeteranSpi);

        // when
        final MemberVeteranVO data = userVeteranApi.getVeteranInfo(1L);

        // verify
        assertEquals(memberVeteranVO, data);
    }

}
