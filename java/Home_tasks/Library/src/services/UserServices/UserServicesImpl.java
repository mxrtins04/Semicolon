package services.UserServices;

import data.models.Book;
import data.repositories.BookRepository;
import data.repositories.BookRepositoryImpl;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

import static utils.Mapper.map;

public class UserServicesImpl implements UserServices {
    private BookRepository bookRepositoryImpl = new BookRepositoryImpl();


    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        Book book = map(request);
        bookRepositoryImpl.save(book);
        return map(book);
    }
}