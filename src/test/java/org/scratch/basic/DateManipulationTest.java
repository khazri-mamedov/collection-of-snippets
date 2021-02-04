package org.scratch.basic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Naming convention for tests: unitOfWork_StateUnderTest_ExpectedValue
 */
public class DateManipulationTest {
    private final DateManipulation dateManipulation = new DateManipulation();
    
    @Test
    public void customPattern_ParseValue_ExpectedLocalDate() {
        final String date = "2020-01-23";
        final String pattern = "yyyy-MM-dd";
        
        assertEquals(dateManipulation.customPattern(date, pattern).toString(), date);
    }
    
    @Test
    public void convertToLocalDate_Converted_Equals() {
        final Date date = new Date();
        final LocalDate convertedLocalDate = dateManipulation.convertToLocalDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(calendar.get(Calendar.DAY_OF_MONTH), convertedLocalDate.getDayOfMonth());
        assertEquals(calendar.get(Calendar.MONTH), convertedLocalDate.getMonth().ordinal());
        assertEquals(calendar.get(Calendar.YEAR), convertedLocalDate.getYear());
    }

    @Test
    public void calculateAge_CalculatingWithNow_CorrectAge() {
        final LocalDate localDate = LocalDate.of(1991, 1, 23);

        assertSame(dateManipulation.calculateAge(localDate), 30L);
    }
}
