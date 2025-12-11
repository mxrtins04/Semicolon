package services.UserServices;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public interface UserServices {

    AddBookResponse addBook(AddBookRequest request);

    public interface BookServices {
        AddBookResponse addBook(AddBookRequest request);

    }
}
