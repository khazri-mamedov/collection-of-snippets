package org.scratch.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Common date manipulations
 */
public class DateManipulation {
    
    /**
     * LocalDate from string with custom pattern instead of predefined DateTimeFormatter
     * @param date for parsing
     * @param pattern for formatter
     * @return LocalDate representing parsed value
     */
    public LocalDate customPattern(final String date, final String pattern) {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, customFormatter);
    }
}
