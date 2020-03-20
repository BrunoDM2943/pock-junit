package github.com.brunodm.pock.junit.library.repository;

import github.com.brunodm.pock.junit.library.model.Book;

public interface LibraryRepository {

    Book saveBook(Book book);

    Book getBook(Long id);
}
