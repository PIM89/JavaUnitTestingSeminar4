import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    @Test
    public void checkFindBookById() {
        BookRepository bookRepository = mock(BookRepository.class);
        when(bookRepository.findById("1")).thenReturn(new Book("1", "book1", "author1"));

        BookService bookService = new BookService(bookRepository);
        Book book = bookService.findBookById("1");
        Assertions.assertEquals("1", book.getId());
        Assertions.assertEquals("book1", book.getTitle());
        Assertions.assertEquals("author1", book.getAuthor());
    }

    @Test
    public void checkFindAllBooks() {
        BookRepository bookRepository = mock(BookRepository.class);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(
                        new Book("1", "book1", "author1"),
                        new Book("2", "book2", "author2"),
                        new Book("3", "book3", "author3")
                ));

        BookService bookService = new BookService(bookRepository);
        List<Book> books = bookService.findAllBooks();

        Assertions.assertEquals(3, books.size());
        Assertions.assertEquals(books.get(0).getId(), "1");
        Assertions.assertEquals(books.get(1).getId(), "2");
        Assertions.assertEquals(books.get(2).getId(), "3");

        Assertions.assertEquals(books.get(0).getTitle(), "book1");
        Assertions.assertEquals(books.get(1).getTitle(), "book2");
        Assertions.assertEquals(books.get(2).getTitle(), "book3");

        Assertions.assertEquals(books.get(0).getAuthor(), "author1");
        Assertions.assertEquals(books.get(1).getAuthor(), "author2");
        Assertions.assertEquals(books.get(2).getAuthor(), "author3");

    }
}