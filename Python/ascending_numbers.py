
"""
- Collect 3 decimals from the user(decimal1, decimal2, decimal3)
- Compare the users input, find the smallest number and assign it to the variable smallest
- Compare the users input, find the largest number and assign it to the variable largest
- check if decimal1 id larger than smallest and smaller than largest. If so, assign it to the variable mid
- check if decimal2 id larger than smallest and smaller than largest. If so, assign it to the variable mid
- check if decimal3 id larger than smallest and smaller than largest. If so, assign it to the variable mid
- Print out the variables in this order: smallest, mid, largest
"""

decimal1 = float(input("Input a decimal: "))
decimal2 = float(input("Input a decimal: "))
decimal3 = float(input("Input a decimal: "))

smallest = min(decimal1, decimal2, decimal3)
largest = max(decimal1, decimal2, decimal3)

if smallest < decimal1 and largest > decimal1:
	mid = decimal1
if smallest < decimal3 and largest > decimal3:
	mid = decimal3
if smallest < decimal2 and largest > decimal2:
	mid = decimal2


print("Here are the decimals you put in, in ascending order:", smallest,",", mid,",", largest)