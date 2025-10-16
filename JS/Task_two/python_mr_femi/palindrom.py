number = '12321'
number_reverse = ''
last_index = (len(number) * -1) - 1

for digit in range(-1, last_index, -1):

	number_reverse += number[digit]

if( number == number_reverse ):
	print("True")
else:
	print("False")


