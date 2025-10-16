number = 11
divisor = 2
binary_number = []


while number >= 0:
	binary_number.append(int(number % 2 ))
	number /= 2
	print(binary_number)

	if number < 0:
		stop
	
	
