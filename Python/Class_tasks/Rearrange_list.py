input = [3, 14,7, 21, 8]

output = []
present_number = 0
highest_number = 0
output_length = 0



for index in range(len(input)):
	
	if index == len(input) - 1:
		next_number = highest_number
	else:
		next_number = input[index + 1]
	for index in range(0, 5):
		if(input[index] >= present_number and input[index] < next_number):
			print(output)
			present_number = input[index]
			highest_number = input[index]
			output.append(present_number)
			
			
print(output)
