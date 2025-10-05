"""
- Prompt the user to put in a nmber
- Assign the user's input to the variable num
- Check if there is no remainder when num is divided by 2. If so, print "EVEN". If not
- Check if there is a remainder when num is divided by 2. If so, print "ODD"
"""

num = input("Input a number: ")

if num % 2 == 0:
	print("EVEN")
if num % 2 != 0:
	print("ODD")