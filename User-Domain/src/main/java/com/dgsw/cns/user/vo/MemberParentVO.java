package com.dgsw.cns.user.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 유저(지원생)의 학부모 정보를 담고 있는 Value Object class <br>
 * <pre>
 *     - 보호자 성함
 *     - 관계
 *     - 생년월일
 *     - 전화번호
 *     - 주소
 *     - 상세 주소
 * </pre>
 */
@Getter
@RequiredArgsConstructor
public class MemberParentVO {

    private final String name;

    private final String relationShip;

    private final String birthday;

    private final String telephone;

    private final String address;

    private final String addressDetail;

}
