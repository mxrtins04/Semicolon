backwards = 0

number = int(input("Enter a five digit number: "))

thousand = 10000

for number in range(5):
	digit = number // thousand
	number = number % thousand
	
	
while number > 0:
	digit = number % 10
	backwards = backwards * 10 + digit
	number = number // 10
	
if number == backwards:
	print("It is a palindrum")
	
