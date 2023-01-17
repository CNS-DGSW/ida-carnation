package com.dgsw.cns.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 내부 스토리지 혹은 S3 를 참조하여, 보관된 지원자의 이미지를 담는 Value Object class
 */
@Getter
@AllArgsConstructor
public class MemberImageVO {

    private final String image;

}
