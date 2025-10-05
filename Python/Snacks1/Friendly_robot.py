"""
- Prompt the user to put in their name.
- Save the user's input to variable name
- Check if their name is alex. If so print "Hello friend". If not,
- Display "Hi, stranger"
"""

name = input("What's your name: ")

if name == "Alex":
	print("Hello friend")
if name != "Alex":
	print("Hi, stranger")
