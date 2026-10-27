package com.hitms.lms.service;

import com.hitms.lms.BookUnavailableException;
import com.hitms.lms.LibraryService;
import com.hitms.lms.MemberNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for adding, issuing, and returning books plus the
 * unavailable-title exception.
 */
class LibraryServiceTest {

    /**
     * Adding a fresh title creates the entry with the requested copies.
     */
    @Test
    void addingABookStoresItsCopies() {
        LibraryService service = new LibraryService();
        service.addBook("Clean Code", 3);
        assertEquals(3, service.findBook("Clean Code").getTotalCopies());
        assertEquals(3, service.findBook("clean  code").getAvailableCopies());
    }

    /**
     * Issue reduces the shelf count and return restores it.
     */
    @Test
    void issuingThenReturningRestoresTheShelf() throws BookUnavailableException {
        LibraryService service = new LibraryService();
        service.addBook("Effective Java", 2);
        assertEquals(1, service.issueBook("effective java"));
        assertEquals(2, service.returnBook("Effective Java"));
    }

    /**
     * Issuing the last copy and then trying again raises the custom
     * checked exception and the message names the title.
     */
    @Test
    void issuingWithoutCopiesThrows() throws BookUnavailableException {
        LibraryService service = new LibraryService();
        service.addBook("The Great Gatsby", 1);
        service.issueBook("The Great Gatsby");
        BookUnavailableException thrown = assertThrows(BookUnavailableException.class,
                () -> service.issueBook("The Great Gatsby"));
        assertEquals("'The Great Gatsby' has no copies available.", thrown.getMessage());
    }

    /**
     * Looking up a membership number that was never registered raises
     * the member lookup exception.
     */
    @Test
    void lookingUpUnknownMemberThrows() {
        LibraryService service = new LibraryService();
        service.addMember("M101", "Sara Khan");
        MemberNotFoundException thrown = assertThrows(MemberNotFoundException.class,
                () -> service.findMemberById("M999"));
        assertEquals("No member found with id M999.", thrown.getMessage());
    }
}
