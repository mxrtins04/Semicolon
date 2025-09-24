"""
- Collect 3 numbers from the user and assign them to the variables number1, number2 and number3
- createa a new variable, sum, and let its value be number1 + number2 + number3
- Initialize a new variable, product, to the product of the 3 numbers
- initialize a new variable, average, to the sum of the 3 numbers divided by 3
- Initialize a new variable, smallest, to the minimum value among the 3 numbers
- Initialize a new variable, largest, to the maximum value among the 3 numbers
- Print out sum, product, average, smallest, and largest
"""

number1 = int(input("Input a number: "))
number2 = int(input("Input a number: "))
number3 = int(input("Input a number: "))

sum = number1 + number2 + number3
product = number1 * number2 * number3
average = (number1 + number2 + number3) / 3
smallest = min(number1, number2, number3)
largest = max(number1, number2, number3)

print("The sum of the 3 numbers are: ", sum, "\nThe product of the 3 numbers are: ", product, "\n The average of the 3 numbers are: ", average, "\n The smallest of the numbers are: ", smallest, "\n The largest of the numbers are: ", largest)