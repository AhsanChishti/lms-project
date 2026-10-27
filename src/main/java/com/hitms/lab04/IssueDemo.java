package com.hitms.lab04;

import com.hitms.lms.BookUnavailableException;
import com.hitms.lms.LibraryService;

/**
 * Lab task showing the custom exception end to end: issue copies of a
 * book until the shelf is empty and let the exception carry the failure
 * to the console instead of crashing.
 */
public final class IssueDemo {

    /** Prevents instantiation of this demo class. */
    private IssueDemo() {
    }

    /**
     * Runs a small issue flow through the LMS service.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) {
        LibraryService service = new LibraryService(); // in-memory session state
        service.addBook("Clean Code", 2);
        try {
            System.out.println("Remaining copies: " + service.issueBook("Clean Code"));
            System.out.println("Remaining copies: " + service.issueBook("Clean Code"));
            service.issueBook("Clean Code"); // shelf is empty now
            System.out.println("Issued a third copy."); // never reached
        } catch (BookUnavailableException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
