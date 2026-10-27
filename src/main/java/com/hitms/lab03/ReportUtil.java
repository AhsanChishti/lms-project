package com.hitms.lab03;

/**
 * Refactor of the one long "average and print" block from the lab sheet
 * into two focused methods.
 */
public final class ReportUtil {

    /** Prevents instantiation of this demo class. */
    private ReportUtil() {
    }

    /**
     * Returns the average of an array of numeric scores.
     *
     * @param scores the scores to average
     * @return the mean of the scores
     */
    public static double calculateAverage(int[] scores) {
        int total = 0;
        for (int s : scores) {
            total += s;
        }
        return (double) total / scores.length;
    }

    /**
     * Prints a short summary for an array of scores.
     *
     * @param scores the scores to report on
     */
    public static void printReport(int[] scores) {
        System.out.println("Average: " + calculateAverage(scores));
    }

    /**
     * Runs the report demo.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        int[] studentScores = {78, 92, 55, 88};
        printReport(studentScores);
    }
}
