package com.cardumen.makigero.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author fernando.perez
 * @version 0.1
 *
 * Utils to work with dates
 */
public class DateUtils {

    //region Constructor
    private DateUtils() {
        // Private constructor to avoid instantiation.
    }
    //endregion

    //region Public Static Implementation
    /**
     * @param value The date string in format yyyy-dd-MM.
     * @return A {@link Date} instance with the parsed date from value. If value was null it will return a an instance with the current date.
     * @throws ParseException
     */
    public static Date getDate(String value) throws ParseException {
        if (value != null) {
            return new SimpleDateFormat("yyyy-dd-MM", Locale.US).parse(value);
        }

        return new Date();
    }
    //endregion
}