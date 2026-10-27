package com.hitms.lms;

import java.time.LocalDate;

import com.hitms.lms.model.Member;
import com.hitms.lms.util.LibraryUtils;

/**
 * Driver class for the LMS. It exercises the modules from the labs so the
 * whole thing can be checked from one console run: lab 03 checks the two
 * helpers, the rest walks through add, issue, return, and a lookup on the
 * service.
 */
public final class Main {

    /** Prevents instantiation of this driver class. */
    private Main() {
    }

    /**
     * Runs the lab walkthrough.
     *
     * @param args command line arguments, ignored
     */
    public static void main(String[] args) throws MemberNotFoundException {
        // lab 03: importing and reusing the util package
        System.out.println(LibraryUtils.formatTitle(" the great gatsby "));
        System.out.println(LibraryUtils.daysBetween(
                LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 15)));

        // labs 03 and 04: the LMS module on top of the model classes
        System.out.println("-- LMS walkthrough --");
        LibraryService library = new LibraryService();
        library.addBook("Clean Code", 3);
        library.addBook("effective java", 1);

        try {
            System.out.println("Remaining copies: " + library.issueBook("Clean Code"));
            System.out.println("Remaining copies: " + library.issueBook("Effective Java"));
            library.returnBook("Effective Java");
            System.out.println("Remaining copies: " + library.returnBook("Effective Java"));
        } catch (BookUnavailableException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        // lab 05: member lookup added on the feature branch
        System.out.println(library.findMemberById("m101"));
        try {
            library.findMemberById("m999"); // never registered, raises the custom exception
        } catch (MemberNotFoundException e) {
            System.out.println("Lookup failed: " + e.getMessage());
        }
    }
}
