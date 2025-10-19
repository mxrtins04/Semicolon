number = 7
sum = 0

for divisor in range(1, number):
	if number % divisor == 0:
		sum += divisor

if sum == number:
	print("It is a perfect number")
else:
	print("It is not a perfect number")
