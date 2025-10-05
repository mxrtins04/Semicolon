"""
- Prompt the user to put in a pet
- Assign the user's input to variable pet
- Check if pet is the same as Dog. If so, print "Woof! Dogs are awesome". If not,
- Print "Cool choice, but i love dogs"
"""

pet = input("Input a pet")

if pet == "Dog":
	print("Woof! Dogs are awesome!)
if pet != "Dog":
	print("Cool choice, but i love dogs!")