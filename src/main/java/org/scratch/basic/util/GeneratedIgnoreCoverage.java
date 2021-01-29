package org.scratch.basic.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation for ignoring from Jacoco coverage.
 * <b>Please, refer to documentation about RetentionPolicy and Jacoco relationship</b>
 */
@Retention(RetentionPolicy.CLASS)
public @interface GeneratedIgnoreCoverage {
}
