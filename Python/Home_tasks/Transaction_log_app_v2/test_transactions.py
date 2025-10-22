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
	
	def test_if_deposit_updates_account_balance(self):
		actual = deposit(account_balance = 3500, amount = 2000)
		expected = 5500
		self.assertEqual(actual, expected)

	def test_if_deposit_adds_transaction_to_array(self):
		actual = deposit(amount = 100)
		expected = ["Deposited: $100 | New balance: $100"]
		self.assertEqual(actual, expected)

	def test_if_withdraw_function_exists(self):
		withdraw(5000)


	def test_if_withdraw_function_notifies_user_of_insufficient_funds(self):
		actual = withdraw(account_balance = 1000, amount = 2000)
		expected = "Insufficient funds... brokie"
		self.assertEqual(actual, expected)

		