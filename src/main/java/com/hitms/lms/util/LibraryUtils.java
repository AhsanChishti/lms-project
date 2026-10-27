package com.hitms.lms.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Reusable helpers shared by the console front end and the library
 * service. Kept in a separate package so any part of the program can
 * import them without dragging console code along.
 */
public final class LibraryUtils {

    /** Prevents instantiation of this utility class. */
    private LibraryUtils() {
    }

    /**
     * Returns a title in Title Case with surrounding whitespace removed.
     *
     * @param title the raw title text as typed by the user
     * @return the cleaned, title case version of the text
     */
    public static String formatTitle(String title) {
        String trimmed = title.strip().toLowerCase();
        String[] words = trimmed.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty()) {
                result.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1)).append(" ");
            }
        }
        return result.toString().strip();
    }

    /**
     * Returns the number of whole days between two dates.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return the absolute number of days between the two dates
     */
    public static long daysBetween(LocalDate date1, LocalDate date2) {
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }
}
