
import unittest
from logistics_services_functions import *


class test_back_to_Sender(unittest.TestCase):
	def test_that_logistics_function_returns_correct_values_for_less_than_50_packages_sold(self):

		expected = 9800 
		actual = get_drivers_payment(30)

		self.assertEqual(actual,expected)

	def test_that_logistics_function_returns_correct_values_for_more_than_50_but_less_than_60_packages_sold(self):
		expected = 16000 
		actual = get_drivers_payment(55)
		self.assertEqual(actual,expected)

	def test_that_logistics_function_returns_correct_values_for_more_than_60_but_less_than_70_packages_sold(self):
		expected = 22000 
		actual = get_drivers_payment(68)
		self.assertEqual(actual,expected)

	def test_that_logistics_function_returns_correct_values_for_more_than_69_packages_sold(self):
		expected = 43500 
		actual = get_drivers_payment(77)
		self.assertEqual(actual,expected)


