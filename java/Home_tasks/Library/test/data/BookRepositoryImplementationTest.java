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
    void saveBook_CountIncreases(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertEquals(1L, bookRepositoryImpl.count());
    }

    @Test
    void saveBook_BookIsReturned(){
        Book book = new Book();
        assertEquals(book, bookRepositoryImpl.save(book));
    }

    @Test
    void saveBook_BookIdIsSet(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertEquals(1,book.getId());
    }

    @Test
    void findById_BookIsReturned(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        assertEquals(book, bookRepositoryImpl.findById(1));
    }

    @Test
    void findByIdWithNumberGreaterThanCount_ThrowException(){
        assertThrows(InvalidIdException.class, () -> bookRepositoryImpl.findById(1));
    }

    @Test
    void findByIdWithNumberEqualTo0OrLessThan0_ThrowException(){
        assertThrows(InvalidIdException.class, () -> bookRepositoryImpl.findById(0));
        assertThrows(InvalidIdException.class, () -> bookRepositoryImpl.findById(-1));
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
    void deleteById_BookIsDeleted_CountDecreases(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        bookRepositoryImpl.deleteById(1);
        assertEquals(0L, bookRepositoryImpl.count());
    }

    @Test
    void deleteByIdWithInvalidId_ThrowException(){
        assertThrows(InvalidIdException.class, () -> bookRepositoryImpl.deleteById(1));
        assertThrows(InvalidIdException.class, () -> bookRepositoryImpl.deleteById(-1));
        assertThrows(InvalidIdException.class, () -> bookRepositoryImpl.deleteById(0));
    }

    @Test
    void deleteAll_CountIs0(){
        Book book = new Book();
        bookRepositoryImpl.save(book);
        bookRepositoryImpl.deleteAll();
        assertEquals(0L, bookRepositoryImpl.count());
    }


}