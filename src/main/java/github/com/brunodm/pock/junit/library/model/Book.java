package github.com.brunodm.pock.junit.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Book {

    private Long id;

    private String name;
    private String author;
    private Long isbn;

    public Book(String name, String author, Long isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }
}
