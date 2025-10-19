number = 153
num_string = str(number)
length = length(numString)

sum = 0

for index in range(length):
	char_digit = num_string[index]
	digit  = int(char_digit)
	sum += (digit ** length)

if sum == number
	print(f"{number} is an Armstrong number")
else:
	print(f"{number} is not an Armstrong number")