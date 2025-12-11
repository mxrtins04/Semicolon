package data.repositories;
import data.models.BorrowedBook;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBookRepositoryImpl implements BorrowedBookRepository {
    private int count;
    private List<BorrowedBook> books = new ArrayList<>();

    @Override
    public long count() {
        return books.size();
    }

    @Override
    public BorrowedBook save(BorrowedBook book) {
        if(isNew(book)) saveNew(book);
        else update(book);
        return book;
    }

    private void update(BorrowedBook book) {
        books.remove(findById(book.getBookId()));
        books.add(book);
    }

    private void saveNew(BorrowedBook book) {
        count++;
        book.setBookId(count);
        books.add(book);
    }

    private boolean isNew(BorrowedBook book) {
        for(BorrowedBook checkBook : books) {
            if(checkBook.getBookId() == book.getBookId()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public BorrowedBook findById(int id) {
        if(id <= 0 || id > count) return null;
        return books.get(id - 1);
    }

    @Override
    public boolean existsById(int id) {
        return id > 0 && id <= count;
    }

    @Override
    public void deleteById(int id) {
        books.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        books.clear();
    }


}