
for number in range(1, 101):
	divisors_count = 0

	for increment in range(2, (number + 1)):
		#print(increment)
		if( number % increment == 0):
			divisors_count += 1
	if( divisors_count == 0):
		print(number)