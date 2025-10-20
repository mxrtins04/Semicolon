from MFDS_functions import *

print("""
	Goodday user! What would you like to do today?
		1. Buy Petroluem
		2. Show Transaction History""")

operation = int(input("Enter operation: "))

print(choose_operation(operation, transactions = []))

if choose_operation(operation) == 1:
	print("""
	AVAILABLE PETROLEUM
		1.	Petrol => 650/Liter
		2.	Diesel => 720/Liter
		3.	Kerosene => 550/Liter
		4.	Gas => 480/Liter """)

	choose_petroleum = int(input("Enter operation: "))
	guage_type = input("Liter or amount: ")
if choose_operation(input) == 2:
	print(transactions)


