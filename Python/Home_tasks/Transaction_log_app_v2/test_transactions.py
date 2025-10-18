import unittest
from transaction_functions import *


class TestTransaction (unittest.TestCase):
	def test_if_deposit_exists(self):
		deposit(account_balance=0, amount=0, transactions=[])

		

	def test_if_deposit_increases_amount(self):
		expected = 100
		actual = deposit(account_balance=0, amount=100, transactions=[])
		self.assertEqual(actual,expected)

	def test_if_deposit_gives_takes_in_negative_values(self):
		expected = -100
		actual = deposit(account_balance=0, amount=-100, transactions=[])
		self.assertEqual(actual,expected)

	def test_if_deposit_takes_float(self):
		actual = deposit(account_balance=0, amount=100.89, transactions=[])
		expected = 100.89
		self.assertEqual(actual, expected)
		