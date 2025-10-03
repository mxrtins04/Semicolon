def divide_or_square(number):
	
	if(number % 5 == 0):
		return number**0.5
	else:
		return number % 5


number = int(input("Enter a non negative number: "))
print(f"{divide_or_square(number): .3}")