import java.util.Scanner;
import java.util.ArrayList;


public class GroceryAppMain{

	public class Item{
		private String name;
		private int quantity;

		public void setName(String name){
		this.name = name;
			}
		public String getName(){
			return name;}

		public void setQuantity(int quantity){
		this.quantity = quantity;
			}
		public int getQuantity(){
			return quantity;}
		

		}

	Item newItem = new Item();

	public static void main (String[] args){
	ArrayList <String> totalGrocerecies = new ArrayList <String>();


		Scanner input = new Scanner(System.in);
		GroceryApp grocery = new GroceryApp();

		
		while(true){

			System.out.println(showMenu());
			System.out.print("Choose your choice from the menu: ");
			String choice = input.nextLine();
			

			switch(choice){
				case "1" -> {
					System.out.print("Enter item you want to add to your grocery list: ");
					String item = scanner.nextLine().toLowerCase();
					newItem.setName(item);
					System.out.print("How many of these items would you be adding to the list? ");
					int quantity = input.nextInt();
					newItem.setQuantity(quantity);
					String result = grocery.addItems(grocery);
					System.out.println(result);


				}
				case "2" -> {
					System.out.print("Enter item you want to remove from your grocery list: ");
					String item = scanner.nextLine().toLowerCase();
					String result = grocery.removeItems(grocery);
					System.out.println(result);
				}
				case "3" -> { 
						grocery.showItems();


					}
				case "4" -> {System.out.println("Thanks For Choosing Omotemmy Grocery Manager");
					break;
				}
				default -> {System.out.println("Invalid Input, please  choose from the menus");}

			}

		}

	}



	public static String showMenu(){

	String menu = """
*****************************************
*	OMOTEMMY GROCERY MANAGER	*
*****************************************
*>>>>>>>>>>>>>>Choose Menu<<<<<<<<<<<<<<*
*****************************************
*	1->	Add Item		*
*	2->	Remove Item		*
*	3->  Show all available Items	*	
*	4->	Exist			*
*****************************************
	""";
	return menu;

	}



}