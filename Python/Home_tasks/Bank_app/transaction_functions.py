def menu(account_balance, transactions, amount):
		
	options = int(input(f"""
			
Account balance: {account_balance}
Hi user, what would you like to do today?

1. Deposit money
2. Withdraw
3. Show transaction history
4. Exit

input a number:
	"""))

	match (options):
		case 1:
			amount = int(input("How much would you like to deposit? "))
			deposit(account_balance, transactions, amount)
		case 2:
			amount = int(input("How much would you like to withdraw? "))
			withdraw(account_balance, transactions, amount)
	
		case 3:
			if len(transactions) == 0:
				print("No transactions yet")
			else:
				for transaction in range (0, len(transactions)): 
					print(transactions[transaction])
				menu(account_balance, transactions, amount)

		case 4: print("Byeeee")


def deposit(account_balance, transactions, amount):
	if( amount < 0 ):
		input("This would result in you owing us money, do you still want to proceed?")
		
		if( input.lower() == "yes"):
			print("Thank you, we really appreciate it")
			account_balance += amount
		elif( input.lower() == "no" ):
			print("Ok, please next time don't waste our time")
	elif( amount > 0):
		account_balance += amount
		
	transactions.append(f"Deposited: ${amount} | New balance: ${account_balance}")
	menu(account_balance, transactions, amount)

	return(account_balance, transactions)


def withdraw(account_balance, transactions, amount):
	if (account_balance >= amount):
		account_balance -= amount
	else:
		print("Insufficient funds")

	transactions.append(f"Withdrawn: ${amount} | New balance: ${account_balance}")	

	menu(account_balance, transactions, amount)
	return(account_balance)
	


def show_transactions(transactions):
	
	menu(account_balance, transactions, amount)
	return(transactions)


			
			