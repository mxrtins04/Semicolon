import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryTest{

	@Test
	public void testThatLibraryHasNoBook(){
	// Arrange
		Library Library = new Library();
		
		//Act
		int result = Library.totalNumberOfBooks();

	
		//Assert
		assertEquals(result, 0);}

	@Test
	public void testThatBookCanBeAddedToLibraryAndTheTotalNumberOfBooksIsOne(){
	
	//Arrange
		Library Library = new Library();
		
	//Act
		String response = Library.addBook("Things Fall Apart");

	//Assert
		assertEquals(response, "Book added successfuly");
	}

}