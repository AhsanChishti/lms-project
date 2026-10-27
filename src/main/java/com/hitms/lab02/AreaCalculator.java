package com.hitms.lab02;

/**
 * Renamed version of the badly named "calc" class from the lab sheet. The
 * class computes the area of simple rectangles.
 */
public final class AreaCalculator {

    /** Prevents instantiation of this utility class. */
    private AreaCalculator() {
    }

    /**
     * Returns the area of a rectangle.
     *
     * @param length the side length of the rectangle
     * @param width  the side width of the rectangle
     * @return the area, length times width
     */
    public static int calculateArea(int length, int width) {
        int area = length * width; // every unit of length multiplies out to a unit of area
        return area;
    }

    /**
     * Small run so the renamed version can be verified from the console.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        System.out.println("Area of a 7x5 room: " + calculateArea(7, 5));
    }
}
