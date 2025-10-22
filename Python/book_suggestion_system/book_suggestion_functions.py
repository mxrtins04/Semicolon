import random


def get_random_book(books):
	return random.choice(books)

def get_random_page():
	return random.randrange(1,101)

def give_book_suggestion(list):
	return(random.randrange(len(list)))

def add_book(book,converted):
	if book.lower() not in converted:
		books.append(book)
		print("Book succesfully added!")
	if book.lower() in converted:
		print("Book already exists!")
	return books

def remove_book(book,converted):
	if book.lower() in converted:
		books.remove(book)
		print("Book successfully removed!")
	else:
		print("Book not found!")

	return books 