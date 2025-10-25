from Grocery_app_functions import *

groceries = []
while(True):
	print(show_menu())
	choice = input("Choose Your Choice From The Menu: ")
	match choice:
		case "1": 
			grocery = input("What do you want to add to your grocery list: ").lower()
			result = add_items(grocery,groceries)
			print(result)

		case "2": 
			grocery = input("What do you want to remove from your grocery list: ").lower()
			result = remove_items(grocery,groceries)
			print(result)

		case "3": 
			result = show_all_available_items(groceries)
			print(result)
		case "4": 
			print("Byeee")
			break;
		case _: 
			print("Invalid Input, Choose from the menu below")
			print(show_menu())