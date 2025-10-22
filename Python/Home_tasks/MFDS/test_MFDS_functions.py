import unittest
from MFDS_functions import *

class Test_MFDS_functions(unittest.TestCase):
	def test_if_choose_operation_exists(self):
		choose_operation(input)

	def test_if_choose_operation_accepts_int(self):
		actual = choose_operation(1)
		expected = 1
		self.assertEqual(actual, expected)
	
	def test_if_choose_operation_doesnt_accept_strings(self):
		actual = choose_operation("c")
		expected = "Input a number please"
		self.assertEqual(actual, expected)
	
	def test_if_choose_operation_accepts_input(self):
		actual = choose_operation(1)
		expected = 1
		self.assertEqual(actual, expected)

	def test_if_choose_operation_works_only_for_available_cases(self):
		actual = choose_operation(7)
		expected = "Please be sensible and put in an option that we've made available"
		self.assertEqual(actual, expected)	

	def test_if_validate_petroleum_type_works(self):
		actual = validate_petroleum_type(1)
		expected = 1
		self.assertEqual(actual, expected)

	def test_if_validate_petroleum_type_works_only_for_available_cases(self):
		actual = validate_petroleum_type(7)
		expected = "Please be sensible and put in an option that we've made available"
		self.assertEqual(actual, expected)

	def test_if_validate_guage_type_doesnt_collect_int(self):
		actual = validate_guage_type(1)
		expected = "A number isn't required here, please read the instructions carefully."
		self.assertEqual(actual, expected)

	def test_if_validate_guage_type_works_only_for_available_cases(self):
		actual = validate_guage_type("john")
		expected = "Please input your preferred gauging method... liter or amount"
		self.assertEqual(actual, expected)
	

	def test_if_limit_petroleum_purchase_exists(self):
		limit_petroleum_purchase(9)