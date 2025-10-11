def square_numbers_in_list(numbers):
	
	output =[]
	for number in numbers:
		output.append(number * number)

	return(output)

numbers = [34, 54, 76, 73, 23, 234, 24, 20, 18]

print(square_numbers_in_list(numbers))