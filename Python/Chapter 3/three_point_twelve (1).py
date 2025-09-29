reversed = 0

number = int(input("Enter a five digit number: "))

divide = 10000

for number in range(5):
	digit = number // divide
	#print(digit, end=" ")
	number = number % divide
	divide = divide // 1
	
while number > 0:
	digit = number % 10
	reversed = reversed * 10 + digit
	number = number // 10
	
if number == reversed:
	print("It is a palindrum")
	
#else:print("It is not a palindrum")