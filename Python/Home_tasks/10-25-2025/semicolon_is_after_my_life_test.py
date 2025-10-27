import unittest
from semicolon_is_after_my_life import  *

class Test_semicolon_wants_to_end_me(unittest.TestCase):

	def test_if_first_function_adds_number_to_the_tuple(self):
		new_number = 3
		numbers = (2, 1, 2)
		actual = add_number_to_tuple_without_directly_modifying_it(new_number, numbers)
		expected = (2, 1, 2, 3)
		self.assertEqual(actual,expected)

	def test_that_the_first_function_does_not_collect_data_types_other_than_int(self):
		new_number = "b"
		numbers = (2, 1, 2)
		actual = add_number_to_tuple_without_directly_modifying_it(new_number, numbers)

		expected = "Please input a number"
		self.assertEqual(actual,expected)

	def test_that_second_function_changes_the_value_at_index_1_of_index_2_of_a_tuple(self):
	
		tuple_with_list_at_second_index = (1, 4, [3, 3], 2)
		value = 7
		actual = change_second_element_of_a_list_at_the_third_position_of_a_tuple(tuple_with_list_at_second_index, value)
		expected = (1, 4, [3, 7], 2)
		self.assertEqual(actual,expected)

	def test_that_second_function_collects_tuples_with_a_list_at_index_2(self):
	
		tuple_with_list_at_second_index = (1, 4, 3, 3, 2)
		value = 7
		actual = change_second_element_of_a_list_at_the_third_position_of_a_tuple(tuple_with_list_at_second_index, value)
		expected = "There is no list at the second index of the given tuple"
		self.assertEqual(actual,expected)

	def test_that_second_function_does_not_work_with_tuples_that_have_less_than_two_indexes(self):
	
		tuple_with_list_at_second_index = (1, 4, [3], 2)
		value = 7
		actual = change_second_element_of_a_list_at_the_third_position_of_a_tuple(tuple_with_list_at_second_index, value)
		expected = "The list at the second index of the tuple has only one element"
		self.assertEqual(actual,expected)

	def test_if_find_sum_of_each_element_in_list_of_list_returns_the_correct_sum(self):
		input =  [ [2, 3, 4],  [1, 5, 7],  [4, 6, 8] ]
		actual = find_sum_of_each_element_in_list_of_list(input)
		expected =  [9, 13, 18]
		self.assertEqual(actual,expected)

	def test_if_find_sum_of_elements_in_corresponding_index_in_the_list_of_list_returns_correct_output(self):
		input =  [ [2, 3, 4],  [1, 5, 7],  [4, 6, 8] ]
		actual = find_sum_of_elements_in_corresponding_index_in_the_list_of_list(input)
		expected =   [7, 14, 19] 
		self.assertEqual(actual,expected)