package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public class Mapper {

    public static Book map(AddBookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setEdition(request.getEdition());
        book.setIsbn(request.getIsbn());
        book.setGenre(request.getGenre());
        book.setQuantity(request.getQuantity());
        return book;
    }

    public static AddBookResponse map(Book book) {
        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setBookId(book.getId());
        addBookResponse.setAuthor(book.getAuthor());
        addBookResponse.setTitle(book.getTitle());
        addBookResponse.setQuantity(book.getQuantity());
        return addBookResponse;
    }
}