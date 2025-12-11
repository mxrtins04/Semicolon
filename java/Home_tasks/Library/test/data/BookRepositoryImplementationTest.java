package data;

import data.models.Book;
import data.repositories.BookRepositoryImpl;
import exceptions.InvalidIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryImplementationTest {

    BookRepositoryImpl bookRepositoryImpl;
    @BeforeEach
    void setup() {
        bookRepositoryImpl = new BookRepositoryImpl();
    }

    @Test
    void repositoryIsEmptyUponCreation(){
        assertEquals(0L, bookRepositoryImpl.count());
    }

    @Test
    void saveBookCountIncreases(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertEquals(1L, bookRepositoryImpl.count());
    }

    @Test
    void saveBookIsReturned(){
        Book book = new Book();
        assertEquals(book, bookRepositoryImpl.save(book));
    }

    @Test
    void saveBookIdIsSet(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertEquals(1,book.getId());
    }

    @Test
    void findByIdBookIsReturned(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertEquals(book, bookRepositoryImpl.findById(1));
    }

    @Test
    void findByIdWithNumberGreaterThanCountReturnsNull(){
        assertNull(bookRepositoryImpl.findById(1));
    }

    @Test
    void findByIdWithNumberEqualTo0OrLessThan0ReturnsNull(){
        assertNull(bookRepositoryImpl.findById(0));
        assertNull(bookRepositoryImpl.findById(-1));
    }

    @Test
    void existsByIdTest(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertTrue(bookRepositoryImpl.existsById(1));
    }

    @Test
    void existsByIdWithInvalidIdTest(){
        assertFalse(bookRepositoryImpl.existsById(1));
        assertFalse(bookRepositoryImpl.existsById(-1));
        assertFalse(bookRepositoryImpl.existsById(0));
    }

    @Test
    void deleteByIdBookIsDeletedCountDecreases(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        bookRepositoryImpl.deleteById(1);
        assertEquals(0L, bookRepositoryImpl.count());
    }

    @Test
    void deleteAll_CountIs0(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        bookRepositoryImpl.deleteAll();
        assertEquals(0L, bookRepositoryImpl.count());
    }


}