number = int(input("Enter a number: "))

factorial = 1
i = 1

while 1 <= number:
	factorial *= i
	i += 1

print(f"The factorial of {number} is {factorial}")