import unittest
from Grocery_app_functions import  *
class TestGroceryManager(unittest.TestCase):
	def test_that_grocery_list_is_empty(self):
		items = []
		actual = show_all_available_items(items)
		expected ="Your grocery list is empty"
		self.assertEqual(actual,expected)

	def test_that_grocery_list_is_empty_two(self):
		items = []
		actual = size_of_items(items)
		self.assertEqual(actual,0)


	def test_you_can_add_an_item_to_the_grocery_list(self):
		groceries = []
		grocery = "Missile launcher"
		actual = add_items(grocery, groceries)
		expected = "Missile launcher successfully added to your grocery list"
		self.assertEqual(actual,expected)

	def test_that_grocery_you_can_add_more_than_one_item_grocery_list(self):
		groceries = []
		grocery = "Magnum_97k"
		groceries.append(grocery)
		groceries.append("Onions")
		actual = size_of_items(groceries)
		self.assertEqual(actual,2)

	def test_if_items_added_to_the_grocery_list_actually_exist_in_the_list(self):
		groceries = []
		grocery = "AK-47"
		add_items(grocery, groceries)
		actual = size_of_items(groceries)
		self.assertEqual(actual,1)



	def test_you_can_remove_an_item_from_the_grocery_list(self):
		groceries = ["MK-11","B1 Grenade"]
		actual = remove_items("MK-11", groceries)
		expected = "MK-11 successfully removed"
		self.assertEqual(actual,expected)

	def test_you_can_only_remove_an_existing_item_from_the_grocery_list(self):
		groceries = ["K-9", "AK-47"]
		grocery = "K-22"
		actual = remove_items(grocery, groceries)
		expected = "K-22 not in the grocery list"
		self.assertEqual(actual,expected)
