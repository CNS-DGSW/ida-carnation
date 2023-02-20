package com.dgsw.cns.user.domain;

import com.dgsw.cns.exception.BusinessException;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Builder
public class Parent {

    private final Long id;
    private final Long userId;          // related on Member
    private final LocalDate birth;
    private final String contact;
    private final String name;
    private final String relation;

    public static final class ParentNotFoundException extends BusinessException {
        @Serial
        private static final long serialVersionUID = -7270571150357608874L;

        public ParentNotFoundException() {
            super(404, "부모 정보가 존재하지 않습니다.");
        }

        public ParentNotFoundException(int code, String message) {
            super(code, message);
        }

        public ParentNotFoundException(String message, Throwable cause) {
            super(404, message);
            super.initCause(cause);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(id, parent.id) && Objects.equals(userId, parent.userId)
                && Objects.equals(birth, parent.birth) && Objects.equals(contact, parent.contact)
                && Objects.equals(name, parent.name) && Objects.equals(relation, parent.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, birth, contact, name, relation);
    }
}
