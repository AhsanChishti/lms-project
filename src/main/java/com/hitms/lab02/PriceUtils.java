package com.hitms.lab02;

/**
 * Undocumented "PriceUtils" class from the lab sheet, now documented with
 * Javadoc and an inline comment.
 */
public final class PriceUtils {

    /** Prevents instantiation of this utility class. */
    private PriceUtils() {
    }

    /**
     * Returns the sum of a list of item prices.
     *
     * @param prices the item prices
     * @return the total of all the prices
     */
    public static double total(double[] prices) {
        double sum = 0;
        for (double price : prices) {
            sum += price; // accumulate running total
        }
        return sum;
    }

    /**
     * Returns the average of a list of item prices.
     *
     * @param prices the item prices
     * @return the mean price
     */
    public static double average(double[] prices) {
        return total(prices) / prices.length;
    }

    /**
     * Runs a sample total so the class can be checked quickly.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        double[] fines = {12.5, 6.0, 9.75};
        System.out.printf("Total fine: %.2f%n", total(fines));
        System.out.printf("Average fine: %.2f%n", average(fines));
    }
}
