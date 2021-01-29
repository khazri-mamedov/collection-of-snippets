package org.scratch.basic;

import org.scratch.basic.util.GeneratedIgnoreCoverage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    
    /**
     * Get ZonedDateTime for all time zones
     * @return collection of ZonedDateTime for all zones
     */
    @GeneratedIgnoreCoverage
    public List<ZonedDateTime> getLocalDateTimeForAllZones() {
        final ZonedDateTime dateTime = ZonedDateTime.now();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        
        return zoneIds.stream()
                .map(zoneId -> dateTime.withZoneSameInstant(ZoneId.of(zoneId)))
                .collect(Collectors.toList());
    }
}
