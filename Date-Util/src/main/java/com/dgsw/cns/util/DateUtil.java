package com.dgsw.cns.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateUtil {

    /** Don't let anyone instantiate this class. */
    private DateUtil() {
    }

    public LocalDate stringToLocalDate(String data) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return stringToLocalDate(data, format);
    }

    public LocalDate stringToLocalDate(String data, DateFormat format)
            throws ParseException {
        return LocalDate.from(format.parse(data).toInstant().atZone(ZoneId.of("Asia/Seoul"))
                .toLocalDate());
    }

    public String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateToString(date, format);
    }

    public String dateToString(Date date, DateFormat format) {
        return format.format(date);
    }
}
