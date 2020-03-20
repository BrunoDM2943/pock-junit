package github.com.brunodm.pock.junit.library.service;

import github.com.brunodm.pock.junit.library.model.Book;
import github.com.brunodm.pock.junit.library.repository.LibraryRepository;

import java.util.Optional;

public class LibraryService {

    private LibraryRepository repository;

    private static int ISBN_SIZE = 10;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public Book saveBook(Book book){
        Long isbn = book.getIsbn();
        if(isbn == null){
            throw new IllegalArgumentException("ISBN cannot be null");
        }
        if(String.valueOf(isbn).length() != ISBN_SIZE) {
            throw new IllegalArgumentException("Invalid ISBN size");
        }
        return repository.saveBook(book);
    }

    public Optional<Book> getBook(Long id){
        return Optional.ofNullable(repository.getBook(id));
    }

}
