package org.scratch.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
