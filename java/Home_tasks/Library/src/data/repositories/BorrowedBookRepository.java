package data.repositories;


import data.models.BorrowedBook;

public interface BorrowedBookRepository {
    long count();
    BorrowedBook save(BorrowedBook book);
    BorrowedBook findById(int id);
    boolean existsById(int id);
    void deleteById(int id);
    void deleteAll();
}