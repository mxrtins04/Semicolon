from transaction_functions import *



account_balance = 0
transactions = []
options = int(input(f"""
Account balance: {account_balance}

Hi user, what would you like to do today?

1. Deposit money
2. Withdraw
3. Show transaction history
4. Exit

Input a number: 
"""))

match (options):
	case 1:
		account_balance = 0
		transactions = []

		amount = float(input("How much would you like to deposit? "))
		deposit(account_balance, transactions, amount)
	case 2:
		amount = float(input("How much would you like to withdraw? "))
		account_balance = 0
		transactions = []
		withdraw(amount, account_balance, transactions)
	
	case 3:
		if len(transactions) == 0:
			print("No transactions yet")
		else:
			for transaction in range (0, len(transactions)): 
				print(f"{transaction + 1}. {transactions[transaction]}")
	case 4: print("Byeeeee")

	case _:
		amount = 0
		print("invalid input")
		menu(account_balance, transactions, amount)
