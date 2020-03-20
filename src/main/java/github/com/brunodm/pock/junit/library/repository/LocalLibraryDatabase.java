package github.com.brunodm.pock.junit.library.repository;

import github.com.brunodm.pock.junit.library.model.Book;

import java.util.HashMap;
import java.util.Map;

public class LocalLibraryDatabase implements LibraryRepository {

    private Map<Long, Book> books = new HashMap<>();

    private long counter = 0;

    @Override
    public Book saveBook(Book book) {
        book.setId(++counter);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book getBook(Long id) {
        return books.get(id);
    }
}
