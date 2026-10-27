package com.hitms.lms;

import com.hitms.lms.model.Book;
import com.hitms.lms.model.Member;
import com.hitms.lms.util.LibraryUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Business logic of the library: adding books, issuing and returning
 * copies, and looking up members. All state lives in plain collections
 * for the lifetime of the program.
 */
public class LibraryService {

    /** Catalogue of books keyed by normalised title. */
    private final Map<String, Book> catalogue = new HashMap<>();   // title -> book

    /** Registered members keyed by membership number. */
    private final Map<String, Member> members = new HashMap<>();   // id -> member

    /**
     * Adds copies of a title to the catalogue. The first add creates the
     * entry, later adds simply top up the shelf.
     *
     * @param title  the book title
     * @param copies the number of copies to add
     */
    public void addBook(String title, int copies) {
        if (title == null || title.strip().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        if (copies <= 0) {
            throw new IllegalArgumentException("Copies must be positive.");
        }
        String key = LibraryUtils.formatTitle(title);
        Book book = catalogue.get(key);
        if (book == null) {
            book = new Book(key, copies);
            catalogue.put(key, book);
        } else {
            for (int i = 0; i < copies; i++) {
                book.returnCopy();
            }
        }
    }

    /**
     * Registers a member with the given id and name.
     *
     * @param id   the membership number, for example M101
     * @param name the member name
     */
    public void addMember(String id, String name) {
        if (id == null || !id.strip().toUpperCase().matches("M\\d+")) {
            // membership numbers follow the M + digits pattern used at the desk
            throw new IllegalArgumentException("Member id must look like M101.");
        }
        members.put(new Member(id, name).getId(), new Member(id, name));
    }

    /**
     * Issues one copy of the given title and updates the shelf count.
     *
     * @param title the book title
     * @return the number of copies left on the shelf after the issue
     * @throws BookUnavailableException if no copy of the title is available
     */
    public int issueBook(String title) throws BookUnavailableException {
        // Issues one copy of the given title.
        if (title == null || title.strip().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        Book book = findBook(title);
        if (book.getAvailableCopies() == 0) {
            throw new BookUnavailableException("'" + book.getTitle() + "' has no copies available.");
        }
        book.issueCopy();
        return book.getAvailableCopies();
    }

    /**
     * Returns one copy of the given title to the catalogue.
     *
     * @param title the book title
     * @return the number of copies on the shelf after the return
     */
    public int returnBook(String title) {
        Book book = findBook(title);
        book.returnCopy();
        return book.getAvailableCopies();
    }

    /**
     * Finds a book by title. The lookup ignores case and extra spaces
     * because every title is normalised when it is stored.
     *
     * @param title the book title
     * @return the matching book
     */
    public Book findBook(String title) {
        String key = LibraryUtils.formatTitle(title);
        Book book = catalogue.get(key);
        if (book == null) {
            throw new IllegalArgumentException("Unknown title: " + title);
        }
        return book;
    }

    /**
     * Lists every book in the catalogue.
     *
     * @return the books in no guaranteed order
     */
    public List<Book> listBooks() {
        return new ArrayList<>(catalogue.values());
    }

    /**
     * Finds a member by their membership number, accepting "m101" and
     * "M101" alike.
     *
     * @param id the membership number
     * @return the matching member
     * @throws MemberNotFoundException when the id was never registered
     */
    public Member findMemberById(String id) throws MemberNotFoundException {
        if (id == null || id.strip().isEmpty()) {
            throw new MemberNotFoundException("Member id cannot be blank.");
        }
        Member member = members.get(id.strip().toUpperCase());
        if (member == null) {
            throw new MemberNotFoundException("No member found with id " + id.strip().toUpperCase() + ".");
        }
        return member;
    }

    /**
     * Lists every registered member.
     *
     * @return the members in no guaranteed order
     */
    public List<Member> listMembers() {
        return new ArrayList<>(members.values());
    }
}
