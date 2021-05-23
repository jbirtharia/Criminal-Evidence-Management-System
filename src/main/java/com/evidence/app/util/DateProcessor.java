package com.evidence.app.util;

import com.evidence.app.contants.Constants;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Date processor.
 *
 * @author JayendraB
 * @createdOn 5 /13/2021
 */
@Slf4j
public class DateProcessor {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATA_TIME_FORMAT);

    /**
     * To date local date time.
     *
     * @param date the date
     * @return the local date time
     */
    public static LocalDateTime toDate(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    /**
     * To string string.
     *
     * @param date the date
     * @return the string
     */
    public static String toString(final LocalDateTime date){
        return date.format(formatter);
    }

    /**
     * Gets current date and time.
     *
     * @return the current date and time
     */
    public static String getCurrentDateAndTime() {
        return LocalDateTime.now().withNano(0).toString().replace("T", " ");
    }
}
