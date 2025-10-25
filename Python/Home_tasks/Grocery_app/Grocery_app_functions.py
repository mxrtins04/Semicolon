def show_menu():
	menu = """

*	WELCOME TO RAINBOWS AND BUTTERFLIES GROCERY MANAGER	*
*****************************************************************
			Choose Menu
-----------------------------------------------------------------

|	              1->  Add Item				|
|		      2->  Remove Item				|
|		      3->  Show all available Items		|	
|		      4->  Exist				|
	
"""
	return menu

def add_items(item,items):
	if type(item) == int:
		raise TypeError ("Invalid Input")
	items.append(item)
	return f"{item} successfully added to your grocery list"

def remove_items(item,items):
	if item in items:
		items.remove(item)
		return f"{item} successfully removed"

	else:
		return f"{item} not in the grocery list"

def show_all_available_items(items):
	if items == []:
		return "Your grocery list is empty"
	else: 
		for item in items:
			print(item)
	return "Subscribe to get more features from Omotemmy"

def size_of_items(items):
	return len(items)