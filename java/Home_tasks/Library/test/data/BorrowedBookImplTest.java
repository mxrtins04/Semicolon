package data;
import data.models.BorrowedBook;

import data.repositories.BorrowedBookRepository;
import data.repositories.BorrowedBookRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BorrowedBookImplTest {

    BorrowedBookRepository borrowedBookRepositoryImpl;
    @BeforeEach
    void startWith() {
        borrowedBookRepositoryImpl = new BorrowedBookRepositoryImpl();
    }

    @Test
    void repositoryIsEmptyUponCreation(){
        assertEquals(0L,borrowedBookRepositoryImpl.count());
    }

    @Test
    void saveBookCountIncreases(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        assertEquals(1L,borrowedBookRepositoryImpl.count());
    }

    @Test
    void saveBookIsReturned(){
        BorrowedBook book = new BorrowedBook();
        assertEquals(book, borrowedBookRepositoryImpl.save(book));
    }

    @Test
    void saveBookIdIsSet(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        assertEquals(1,book.getBookId());
    }

    @Test
    void findByIdBookIsReturned(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        assertEquals(book, borrowedBookRepositoryImpl.findById(1));
    }

    @Test
    void findByIdWithNumberGreaterThanCountReturnNull(){
        assertNull(borrowedBookRepositoryImpl.findById(1));
    }

    @Test
    void existsByIdTest(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        assertTrue(borrowedBookRepositoryImpl.existsById(1));
    }

    @Test
    void testdeleteByIdDeletesBookAndReducesCount(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        borrowedBookRepositoryImpl.deleteById(1);
        assertEquals(0L, borrowedBookRepositoryImpl.count());
    }

    @Test
    void CountIs0AfterDeleteAll(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        borrowedBookRepositoryImpl.deleteAll();
        assertEquals(0L, borrowedBookRepositoryImpl.count());
    }

    @Test
    void saveBorrowedBookWithSameId(){
        BorrowedBook book = new BorrowedBook();
        borrowedBookRepositoryImpl.save(book);
        BorrowedBook book2 = new BorrowedBook();
        book2.setBookId(1);
        borrowedBookRepositoryImpl.save(book2);
        assertEquals(1L, borrowedBookRepositoryImpl.count());
    }


}