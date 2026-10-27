package com.hitms.lms.model;

import com.hitms.lms.util.LibraryUtils;

/**
 * A registered library member identified by a membership number.
 */
public class Member {

    /** Membership number, for example M101. */
    private final String id;   // membership number

    /** Member name, stored in normalised title case. */
    private final String name; // "sara khan" becomes "Sara Khan"

    /**
     * Creates a member with the given id and name.
     *
     * @param id   the membership number
     * @param name the member name
     */
    public Member(String id, String name) {
        this.id = id.strip().toUpperCase();
        this.name = LibraryUtils.formatTitle(name);
    }

    /**
     * Returns the membership number.
     *
     * @return the id, upper case
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the member name.
     *
     * @return the name in title case
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a friendly one line description of the member.
     *
     * @return text showing the id and the name
     */
    @Override
    public String toString() {
        return "Member " + id + ": " + name;
    }
}
