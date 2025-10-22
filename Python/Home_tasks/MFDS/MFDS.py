from MFDS_functions import *

while (True):
	print("""
		Welcome to Martbosun Stations!
			1. Buy Petroluem
			2. Show Transaction History""")

	operation = int(input("Enter operation: "))

	print(choose_operation(operation, transactions = []))
	
	if choose_operation(operation) == 1:
		print("""
		AVAILABLE PETROLEUM
			1.	Petrol => 180/Liter
			2.	Diesel => 250/Liter
			3.	Kerosene => 80/Liter
			4.	Gas => 400/Liter """)

		choose_petroleum = int(input("Enter operation: "))
		user_input = input("Liter or amount: ")
		guage = user_input.lower()

	if choose_operation(input) == 2:
			print(transactions)


	match(operation):
			case 1:
				match(guage):
					case "liter":
						liters = int(input("How many liters of petrol are you buying (180/L)"))
						limit_petroleum_purhcase( liters )
					case "amount":
						price = 180 
						amount = int(input("How much petrol are you buying (180/L)"))
						control_amount( amount )
			case 2:
				match(guage):
					case "liter":
						litres = int(input("How many liters of diesel are you buying (250/L)"))
						limit_petroleum_purhcase( liters )
					case "amount": 
						price = 250
						amount = int(input("How much diesel are you buying (250/L)"))
						control_amount( amount )	
		
			case 3:
				match(guage):
					case "liter":
						liters = int(input("How many liters of kerosene are you buying (80/L)"))
						limit_petroleum_purhcase( liters )
					case "amount": 
						price = 80
						amount = int(input("How much kerosene are you buying (80/L)"))
						control_amount( amount )
			case 4:
				match(guage):
					case "liter":
						liters = int(input("How many liters of gas are you buying (400/L)"))
						limit_petroleum_purhcase( liters )
					case "amount": 
						price = 400 
						amount = int(input("How much gas are you buying (400/L)"))
						control_amount( amount )



