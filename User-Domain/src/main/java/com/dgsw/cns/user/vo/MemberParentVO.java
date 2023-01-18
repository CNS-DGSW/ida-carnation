package com.dgsw.cns.user.vo;

import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.Parent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 유저(지원생)의 학부모 정보를 담고 있는 Value Object class <br>
 * <pre>
 *     - 보호자 성함
 *     - 관계
 *     - 생년월일
 *     - 전화번호
 *     - 주소
 *     - 상세 주소
 *     - 우편 번호 (5자리)
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

    private final short zipCode;

    public Parent toParentDomain() {
        return toParentDomain(null);
    }

    public Parent toParentDomain(Long parentId) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Parent.builder()
                .id(parentId)
                .birth(LocalDate.from(formatter.parse(birthday)))
                .contact(telephone)
                .name(name)
                .relation(relationShip)
                .build();
    }

    public Address toAddressDomain() {
        return toAddressDomain(null);
    }

    public Address toAddressDomain(Long addressId) {
        return Address.builder()
                .id(addressId)
                .streetAddress(address)
                .detailAddress(addressDetail)
                .zipCode(zipCode)
                .build();
    }

}
