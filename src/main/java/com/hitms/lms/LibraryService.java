package com.hitms.lms;

import com.hitms.lms.model.Book;
import com.hitms.lms.util.LibraryUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Business logic of the library: adding books, issuing and returning
 * copies. All state lives in plain collections for the lifetime of the
 * program.
 */
public class LibraryService {

    /** Catalogue of books keyed by normalised title. */
    private final Map<String, Book> catalogue = new HashMap<>();   // title -> book

    /**
     * Adds copies of a title to the catalogue. The first add creates the
     * entry, later adds simply top up the shelf.
     *
     * @param title  the book title
     * @param copies the number of copies to add
     */
    public void addBook(String title, int copies) {
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
     * Issues one copy of the given title and updates the shelf count.
     *
     * @param title the book title
     * @return the number of copies left on the shelf after the issue
     * @throws BookUnavailableException if no copy of the title is available
     */
    public int issueBook(String title) throws BookUnavailableException {
        // Issues one copy of the given title.
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
}
