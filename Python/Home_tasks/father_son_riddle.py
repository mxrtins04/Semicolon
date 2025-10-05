"""
- Prompt the user to put in son's age and assign user's input to variable son_age
- Prompt the user to put in the father's age and assign user's input to variable dad_age
- Initialize a new variable, years, to dad_age plus 0
- Write a condition that let's the program keep iterating through the following processes while year is not equal to son_age multiplied by 2:
	- Check if years is greater than son_age multiplied by 2. If so:
		- reduce years by 1
	- Check if years is less than son_age multiplied by 2. If so;
		- Increase years by 1
		
- Check if years is greater than dad_age. If so, re-initialize years to years minus dad_age and display "The age of the father would be double that of the son in (variable years) years". Then reinitialize years to years plus dad_age. If not,
- Re-initialize years to dad_age minus years and display "The age of the father was double that of the son (variable years) years ago".
"""

son_age = int(input("Input the son's age: "))
dad_age = int(input("Input the father's age: "))

years = dad_age + 0

while years != (2 * son_age):
	if years > (2 * son_age):
		years = years -1
	if years < (2 * son_age):
		years = years + 1

if years > dad_age:
	years = years - dad_age
	print("The age of the father would be double that of the son in", years, " years")

	years = years + dad_age


if years < dad_age:
	years = dad_age - years
	print("The age of the father was double that of the son", years, " years ago")


