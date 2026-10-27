package com.hitms.lms;

/**
 * Checked exception raised when a member lookup fails, for example a
 * membership number that was never registered.
 */
public class MemberNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Creates the exception with a human readable message.
     *
     * @param message the explanation shown to the user
     */
    public MemberNotFoundException(String message) {
        super(message);
    }
}
