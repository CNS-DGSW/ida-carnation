package com.dgsw.cns.user.domain;

import com.dgsw.cns.exception.BusinessException;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.util.Objects;

@Getter
@Builder
public class Address {

    private final Long id;
    private final Long userId;              // related on Member
    private final String detailAddress;
    private final String streetAddress;
    private final short zipCode;

    public static final class AddressNotFoundException extends BusinessException {
        @Serial
        private static final long serialVersionUID = -2811835751455258639L;

        public AddressNotFoundException() {
            super(404, "주소가 존재하지 않습니다.");
        }

        public AddressNotFoundException(int code, String message) {
            super(code, message);
        }

        public AddressNotFoundException(String message, Throwable cause) {
            super(404, message);
            super.initCause(cause);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode && Objects.equals(id, address.id)
                && Objects.equals(userId, address.userId)
                && Objects.equals(detailAddress, address.detailAddress)
                && Objects.equals(streetAddress, address.streetAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, detailAddress, streetAddress, zipCode);
    }
}
