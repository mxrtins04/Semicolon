import java.util.ArrayList;



public class GroceryApp{


	ArrayList <String> items = new ArrayList <String>();
	
	public  int totalAmountOfItems(){
		return items.size();


	}
	public  String addItems(String weapon, int quantity){
		for (String item : items){
			if (item.equalsIgnoreCase (weapon))
				quantity++;
		}
		items.add(weapon);
		String result = quantity + weapon + "has been added to the list" ;
		return result;


	}

	public  String removeItems(String grocery){
		for (String item : items){
			if (!item.equalsIgnoreCase (grocery))
				return "An Item that is not on the grocery list cannot be removed";
		}
		items.remove(grocery);
		String result = grocery + " have been successfully removed from the grocery list";
		return result;


	}

/*	public  void showItems(){
			if (items.size() == 0){
				System.out.println("There is no item in the GroceryList");}
			else{
		
				for (int number_of_items = 0; number_of_items < items.size(); number_of_items++ ){
					System.out.println(items.get(number_of_items));
				}
		}

	}*/




}