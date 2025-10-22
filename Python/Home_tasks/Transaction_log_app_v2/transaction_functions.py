def deposit(account_balance=0, amount = 0, transactions=[]):
	account_balance += amount
	transactions.append(f"Deposited: ${amount} | New balance: ${account_balance}")
	return(transactions)

def withdraw(account_balance = 0, amount = 0, transaction = []):
	if (account_balance < amount):
		account_balance = account_balance
		return("Insufficient funds... brokie")

	else:
		account_balance -= amount
		return(account_balance)