number = int(input("Input a five digit integer: "))

digit = 0


digit = (number // 10000)
print(digit, sep = ' ')

for counter in range (4):
		
	number = number - 10000		
	digit = (number // 10000)
	print(digit, sep = ' ')