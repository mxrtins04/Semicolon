import random


list_of_books = ["We are one", "Jeje", "The oblivious tortoise and the alien", "The beautiful love story of the oyinadedotun couple", "The girl with the big head and little brain", "Rockets and sphagetti's"]


while True:
	print("""
			Welcome To The Book Suggestion System!
		1. Get Suggestions
 		2. Add Book
 		3. Remove Book
 		4. Update book 
		5. Show books
""")
	operation = int(input("Enter operation: "))

	match operation:
		case 1:
			choice = ""
			while choice != "no":
				book, page = give_book_suggestions(books)
				print(book)
				print(page)
				choice = input("Would you like to get another suggestion?(Y/N): ")
		case 2:
			book = input("Enter the book title: ")
			add_book(book, book_list)

		case 3: 
			print(books)
			book_to_discard = input("Enter the book title: ")
			remove_book(book_to_discard, book_list)

		case 4:
			old_title = input("Enter the old title: ")
			new_title = input("Enter the new title: ")
			update_book(old_title, new_title, books)

		case 5:
			print(show_books(books))

		case _: print("I'm stressed out as it is... Please just pick a number that's available")
