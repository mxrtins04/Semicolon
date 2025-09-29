product = 1
num = int(input("Enter a non-negative number: "))

if num < 0:
	print("Invalid") 

else:
	for number in range(1, num + 1):
		product *= number

	print(product)

