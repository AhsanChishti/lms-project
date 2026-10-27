package com.hitms.lab04;

/**
 * Basic exception handling from the lab sheet: division that survives a
 * zero denominator without crashing the program.
 */
public final class DivisionDemo {

    /** Prevents instantiation of this demo class. */
    private DivisionDemo() {
    }

    /**
     * Divides two integers. Throws an ArithmeticException when the
     * denominator is zero, which the caller handles.
     *
     * @param numerator   the number to divide
     * @param denominator the number to divide by
     * @return the integer quotient
     */
    public static int safeDivide(int numerator, int denominator) {
        return numerator / denominator;
    }

    /**
     * Runs the division demo.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        try {
            System.out.println("Result: " + safeDivide(10, 2));
            System.out.println("Result: " + safeDivide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }
    }
}
