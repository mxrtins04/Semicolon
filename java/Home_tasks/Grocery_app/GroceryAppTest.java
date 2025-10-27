import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


	public class GroceryAppTest{

		GroceryApp groceryApp;

		@BeforeEach
		void setup (){

			groceryApp = new GroceryApp();
		}

		@Test
		public  void testThatGroceryListIsEmpty(){
			int actual = groceryApp.totalAmountOfItems();
			assertEquals(actual, 0);
	
			}
		@Test
		public void testThatAnItemCanBeAddedToTheGroceryList(){

	
			String response = groceryApp.addItems("Tomatoes");

			assertEquals(response, "Tomatoes have been successfully added");


			}


		@Test
		public void testThatAnItemCanBeStoredInTheGroceryList(){
	
			groceryApp.addItems("Tomatoes");
			int response = groceryApp.totalAmountOfItems();
			assertEquals(response, 1);


			}
		
		@Test
		public void testThatMoreThanOneItemCanBeStoredInGroceryList(){
	
			groceryApp.addItems("K9");
			groceryApp.addItems("B1 Grenade");
			int response = groceryApp.totalAmountOfItems();
			assertEquals(response, 2);


			}
	

	/*	@Test
		public void testThatOneItemCannotBeAddedToTheGroceryListTwice(){
	
			groceryApp.addItems("tomatoes");
			String response = groceryApp.addItems("tomatoes");
			assertEquals(response, "An Item cannot be entered twice");


			}

		
		@Test
		public void testThatOneItemWasAddedTwiceAndTheTotalNumberOfItemsIsOne(){
	
			groceryApp.addItems("tomatoes");
			groceryApp.addItems("tomatoes");
			int response = groceryApp.totalGrocerecies();
			assertEquals(response, 1);


			}
		
*/
		@Test
		public void testThatItemCanBeRemoveFromTheGroceryList(){
		
			groceryApp.addItems("H1 Bomb");
			String response = groceryApp.removeItems("H1 Bomb");
			assertEquals(response, "H1 Bomb have been successfully removed from the grocery list");
			}

	


		@Test
		public void testThatOnlyItemInTheGroceryListCanBeCanBeRemove(){
	
			groceryApp.addItems("Tomatoes");
			String response = groceryApp.removeItems("Fish");
			assertEquals(response, "An Item that is not on the grocery list cannot be removed");


			}





		@Test
		public void testThatYouCanViewItemsInTheGroceryList(){
	
			groceryApp.addItems("Tomatoes");
		
			ArrayList <String> result = groceryApp.showItems();
			String actual = result.get(0);
			String expected = "Tomatoes";
			assertEquals(actual, expected);


			}

	
	



}
