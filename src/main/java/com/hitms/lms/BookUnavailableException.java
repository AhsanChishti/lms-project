package com.hitms.lms;

/**
 * Checked exception raised when a copy of a title cannot be issued
 * because none are left on the shelf.
 */
public class BookUnavailableException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates the exception with a human readable message.
     *
     * @param message the explanation shown to the user
     */
    public BookUnavailableException(String message) {
        super(message);
    }
}
