
original_amount = 1000
ror = 7 / 100





for count in range(1, 31):
	returns = original_amount * (1 + ror)** count


	print(f"Your investment after {count} years is: ", returns)