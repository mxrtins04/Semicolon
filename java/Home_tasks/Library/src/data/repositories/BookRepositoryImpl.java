package data.repositories;

import data.models.Book;
import exceptions.InvalidIdException;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private int count;
    private List<Book> books = new ArrayList<>();

    @Override
    public long count() {
        return books.size();
    }

    @Override
    public Book save(Book book) {
        count++;
        book.setId(count);
        books.add(book);
        return book;
    }

    @Override
    public Book findById(int id) {
        validateId(id);
        return books.get(id - 1);
    }

    @Override
    public boolean existsById(int id) {
        return id > 0 && id <= count;
    }

    @Override
    public void deleteById(int id) {
        validateId(id);
        books.remove(id-1);
    }

    private void validateId(int id){
        if(id <= 0 || id > count) throw new InvalidIdException("Invalid id!");
    }

    @Override
    public void deleteAll() {
        books.clear();
    }


}