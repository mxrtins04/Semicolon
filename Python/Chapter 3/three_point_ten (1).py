principal = 5000.0

interest = 0.07

amount = principal

for year in range(1, 31):
	amount = amount * 1 + interest
	print("In year " ,year, "the amount is: " ,amount)