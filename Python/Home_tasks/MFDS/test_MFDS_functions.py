import unittest
from MFDS_functions import *

class Test_MFDS_functions(unittest.TestCase):
	def test_if_choose_operation_exists(self):
		choose_operation(input)
	
	def test_if_choose_operation_doesnt_accept_strings(self):
		actual = choose_operation("c")
		expected = "Input a number please"
		self.assertEqual(actual, expected)
	
	''' def test_if_choose_operation_accepts_input(self):
		actual = choose_operation(7)
		expected = 7
		self.assertEqual(actual, expected) '''

	def test_if_choose_operation_works_only_for_available_cases(self):
		actual = choose_operation(7)
		expected = "Please be sensible and put in an option that we've made available"
		self.assertEqual(actual, expected)	
	

	def test_if_buy_petroleum_exists(self):
		buy_petroleum(1)

	def test_if_buy_petroleum_doesnt_accept_strings_as_operation(self):
		actual = buy_petroleum("c", "")
		expected = "Input a number please"
		self.assertEqual(actual, expected)

	def test_if_buy_petroleum_doesnt_accept_int_as_guage(self):
		actual = buy_petroleum(1, 3)
		expected = "A number isn't required here, please read the instructions carefully."
		self.assertEqual(actual, expected)

	def test_if_buy_petroleum_works_only_for_available_cases(self):
		actual = buy_petroleum(2, "john")
		expected = "Please be sensible and put in an option that we've made available"
		self.assertEqual(actual, expected)
	