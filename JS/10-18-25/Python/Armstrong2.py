for number in range(1, 1001):
	num_string= str(number
	length = len(num_string)
	sum = 0

	for index in range(length):
		char_digit = num_string[index]
		digit = int(char_digit)
		sum += (digit ** length)

		if sum == number:
			print(number)