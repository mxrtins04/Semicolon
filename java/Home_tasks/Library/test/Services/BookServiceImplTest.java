package Services;

import data.models.Genre;
import data.repositories.BookRepository;
import data.repositories.BookRepositoryImpl;
import dtos.requests.AddBookRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.UserServices.UserServices;
import services.UserServices.UserServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {

    UserServices bookServicesImpl;
    BookRepository bookRepositoryImpl;
    @BeforeEach
    void setUp() {
        bookServicesImpl = new UserServicesImpl();
        bookRepositoryImpl = new BookRepositoryImpl();
        bookRepositoryImpl.deleteAll();
    }

    @Test
    void addBookCountIncreases() {
        AddBookRequest request = new AddBookRequest();
        request.setTitle("Gatsby Something SOmething");
        request.setAuthor("Scott Fitzgerald");
        request.setEdition(1);
        request.setPages(180);
        request.setQuantity(5);
        request.setGenre(Genre.HISTORY);
        request.setIsbn("743273565");
        request.setDescription("Weird stuff basically");
        bookServicesImpl.addBook(request);
        assertEquals(1,bookRepositoryImpl.count());
    }

}