num1 = int(input("Input a number: "))
num2 = int(input("Input a number: "))
num3 = int(input("Input a number: "))
maximum_number = 0

if num1 > num2 and num1 > num3:
	maximum = num1
if num2 > num3 and num2 > num1:
	maximum = num2
if num3 > num1 and num3 > num2:
	maximum = num3

print("The largest value is: ", maximum)