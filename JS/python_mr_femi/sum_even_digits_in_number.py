number = "393042"
sum = 0

for digit in number:
	if( int(digit) % 2 == 0):
		sum += int(digit)
print(sum)

