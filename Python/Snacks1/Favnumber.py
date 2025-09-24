"""
- Create a variable favnum and give it the value 7
- Prompt the user to guess a number
- Collect the user's input and assign it to the variable num
- Check if num is equal to 7. If so print "That's my favourite number". If not
- Print "Nice try, guess again!"
"""

favnum = 7

num = int(input("input a number"))

if favnum == num:
	print("That's my favourite number")
if favnum != num:
	print("Nice try, guess again!")