package com.hitms.lab04;

/**
 * The debugging exercise from the lab sheet. findMax used to start the
 * running maximum at 0, so an array of negative numbers returned 0. The
 * fix starts it from the first element instead.
 */
public final class MaxDebug {

    /** Prevents instantiation of this demo class. */
    private MaxDebug() {
    }

    /**
     * Returns the largest number in an array. The running maximum is
     * taken from the first element, not from 0, so all-negative arrays
     * still work.
     *
     * @param numbers the values to scan, must be non-empty
     * @return the largest value found
     */
    public static int findMax(int[] numbers) {
        int maxValue = numbers[0]; // starts from the first element
        for (int n : numbers) {
            if (n > maxValue) {
                maxValue = n;
            }
        }
        return maxValue;
    }

    /**
     * Prints the result for the arrays used in the debugger session.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        System.out.println("Max of {-5, -2, -9} is " + findMax(new int[]{-5, -2, -9}));
        System.out.println("Max of {3, 7, 4} is " + findMax(new int[]{3, 7, 4}));
    }
}
