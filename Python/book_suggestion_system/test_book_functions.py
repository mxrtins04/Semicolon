import unittest
from book_suggestion_functions import *


list_of_books = ["We are one", "Jeje", "The oblivious tortoise and the perversed alien", "The beautiful love story of the oyinadedotun couple", "The girl with a big head and a little brain", "Rockets and sphagettis"]

class TestBookSuggestionSystemFunctions (unittest.TestCase):
	def test_if_give_book_suggestion_exists(self):
		give_book_suggestion(list_of_books)

	def test_if_give_book_suggestion_displays_any_books(self):
		give_book_suggestion(list_of_books)

	

	