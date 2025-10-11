def get_least_number(numbers):
	smallest_number = numbers[0]
	for number in numbers:
		if( number < smallest_number ):
			smallest_number = number

	return(smallest_number)

numbers = [34, 54, 76, 73, 23, 234, 24, 20, 18]

print(get_least_number(numbers))