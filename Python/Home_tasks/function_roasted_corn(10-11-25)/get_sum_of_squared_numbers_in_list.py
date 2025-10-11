def get_sum_of_squared_numbers_in_list(numbers):
	
	output = 0
	for number in numbers:
		output += ( number * number )

	return(output)

numbers = [34, 54, 76, 73, 23, 234, 24, 20, 18]

print(get_sum_of_squared_numbers_in_list(numbers))