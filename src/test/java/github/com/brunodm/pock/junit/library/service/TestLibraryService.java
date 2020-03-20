package github.com.brunodm.pock.junit.library.service;

import github.com.brunodm.pock.junit.library.model.Book;
import github.com.brunodm.pock.junit.library.repository.LibraryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class TestLibraryService {

    private LibraryService service;

    private LibraryRepository repository;

    @Before
    public void before(){
        repository = Mockito.mock(LibraryRepository.class);
        service = new LibraryService(repository);
    }

    @Test
    public void testSaveBook(){
        Book book = new Book("The Dark Tower", "Stephen King", 1416524525l);
        service.saveBook(book);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveBookError(){
        Book book = new Book("The Dark Tower", "Stephen King", 141652452l);
        service.saveBook(book);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveBookErrorNullISBN(){
        Book book = new Book("The Dark Tower", "Stephen King", null);
        service.saveBook(book);
    }

    @Test
    public void testGetBookSuccess(){
        Mockito.when(repository.getBook(19l)).thenReturn(new Book("The Dark Tower", "Stephen King", 0l));
        Optional<Book> book = service.getBook(19l);
        Assert.assertTrue(book.isPresent());
        Assert.assertEquals("The Dark Tower", book.get().getName());
    }

    @Test
    public void testGetBookNotFound(){
        Mockito.when(repository.getBook(19l)).thenReturn(null);
        Optional<Book> book = service.getBook(19l);
        Assert.assertFalse(book.isPresent());
    }
}
