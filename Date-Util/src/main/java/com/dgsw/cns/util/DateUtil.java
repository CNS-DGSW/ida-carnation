package com.dgsw.cns.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * 날짜 변환 유틸 클래스 <br>
 * 유틸 클래스이므로 생성자를 생성하지 못하도록 합니다.
 * {@link NoArgsConstructor}
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtil {

    /** Don't let anyone instantiate this class. */

    public static LocalDate stringToLocalDate(String data) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return stringToLocalDate(data, format);
    }

    public static LocalDate stringToLocalDate(String data, DateFormat format)
            throws ParseException {
        return LocalDate.from(format.parse(data).toInstant().atZone(ZoneId.of("Asia/Seoul"))
                .toLocalDate());
    }

    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateToString(date, format);
    }

    public static String dateToString(Date date, DateFormat format) {
        return format.format(date);
    }
}
