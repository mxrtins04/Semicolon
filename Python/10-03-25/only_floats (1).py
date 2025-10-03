def only_floats(a, b):
	decimal_a = a + 0.00
	decimal_b = b +  0.00
	if a == decimal_a and b == decimal_b:
		return 2
	elif  a == decimal_a or b == decimal_b:
		return 1
	else:
		return 0

	 

numberOne = int(input("Enter a number: "))
numberTwo = int(input("Enter a number: "))	
print(only_floats(numberOne, numberTwo))