num1 = int(input("Input a number: "))
num2 = int(input("Input a number: "))
num3 = int(input("Input a number: "))

highest_number = 0
print(num1, num2, num3)

if num1 > num2 and num1 > num3:
	highest_number = num1
if num2 > num1 and num2 > num3:
	highest_number = num2
if num3 > num2 and num3 > num1:
	highest_number = num3

if num1 < highest_number and num1 > num3:
	print("The second largest number is: ", num1)
if num2 < highest_number and num2 > num3:
	print("The second largest number is: ", num2)
if num3 < highest_number and num3 > num2:
	print("The second largest number is: ", num3)
