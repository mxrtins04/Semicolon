number_string = '11010'
length = len(number_string)
base_number = 2
number= int(number_string)
decimal = 0
for index in range((-length), 0, 1):
	decimal += int(number_string[index]) * base_number ** ((index + 1) * -1)
	print(decimal)