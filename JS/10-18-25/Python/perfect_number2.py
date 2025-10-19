for number in range(1, 1001):

	sum = 0

	for divisor in range(1, number):
		if number % divisor == 0:
			sum += divisor
	
	if sum == number:
		print(number)

