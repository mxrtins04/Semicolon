def get_largest_number(numbers):
	largest_number = numbers[0]
	for number in numbers:
		if( number > largest_number ):
			largest_number = number

	return(largest_number)

numbers = [34, 54, 76, 73, 23, 234, 24, 20, 18]

print(get_largest_number(numbers))