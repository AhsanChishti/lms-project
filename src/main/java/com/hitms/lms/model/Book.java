package com.hitms.lms.model;

import com.hitms.lms.util.LibraryUtils;

/**
 * A title held by the library, with its current copy counts. Titles are
 * normalised through LibraryUtils so a book can be found no matter how
 * the user typed its name.
 */
public class Book {

    /** Title of the book, stored in normalised title case. */
    private final String title; // normalised once at construction time

    /** How many copies the library owns in total. */
    private int totalCopies;

    /** How many copies are on the shelf right now. */
    private int availableCopies;

    /**
     * Creates a book with the given title and number of copies.
     *
     * @param title  the book title in normalised title case
     * @param copies the number of copies the library owns
     */
    public Book(String title, int copies) {
        this.title = LibraryUtils.formatTitle(title);
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    /**
     * Returns the title of the book.
     *
     * @return the normalised title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns how many copies the library owns.
     *
     * @return the total copy count
     */
    public int getTotalCopies() {
        return totalCopies;
    }

    /**
     * Returns how many copies are on the shelf right now.
     *
     * @return the available copy count
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Removes one copy from the shelf after an issue.
     */
    public void issueCopy() {
        availableCopies -= 1;
    }

    /**
     * Puts one copy back on the shelf after a return.
     */
    public void returnCopy() {
        if (availableCopies < totalCopies) {
            availableCopies += 1;
        }
    }

    /**
     * Returns a short description used by the console listings.
     *
     * @return text showing the title and both copy counts
     */
    @Override
    public String toString() {
        return title + " (available " + availableCopies + "/" + totalCopies + ")";
    }
}
