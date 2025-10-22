
import unittest
from book_suggestion_functions import *

class TestBookSuggestionSystemFunctions (unittest.TestCase):
	def test_if_get_suggestion_exists(self):
		get_suggestion(abracadabra)