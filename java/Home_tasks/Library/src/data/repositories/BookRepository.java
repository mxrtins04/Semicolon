package data.repositories;

import data.models.Book;

public interface BookRepository {

    long count();
    Book save(Book book);
    Book findById(int id);
    boolean existsById(int id);
    void deleteById(int id);
    void deleteAll();
}