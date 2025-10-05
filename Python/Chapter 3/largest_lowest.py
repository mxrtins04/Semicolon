largest_num = 0
lowest_num = 1
for count in range(10):
	number = int(input("Input a number: "))
	if number > largest_num:
		largest_num = number
	elif number < lot_num:
		lowest_num = number

print(f"Largest number is {largest_num}")
print(f"Lowest number is {lowest_num}")