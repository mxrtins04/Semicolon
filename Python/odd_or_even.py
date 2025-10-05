"""
- Collect an integer from the user and assign users input to variable number
- Check if when number is divided by 2 it has no remainder. If it does, display "This is an even number"
- Check if when number is divided by 2 it has a remainder. If it does, display "This is an odd number"
"""


number = int(input("Input an integer: "))

if number % 2 == 0:
	print(number, "is an even number")
if number % 2 != 0:
	print(number, "is an odd number")