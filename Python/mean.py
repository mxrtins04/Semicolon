num1 = int(input("Input a number: "))
num2 = int(input("Input a number: "))
num3 = int(input("Input a number: "))
num4 = int(input("Input a number: "))
third_num = 0
second_num = 0
maximum = 0
minimum = 0

if num1 > num2 and num1 > num3 and num1 > num4:
	maximum = num1
elif num1 < num2 and num1 < num3 and num1 < num4:
	minimum = num1

if num2 > num1 and num2 > num3 and num2 > num4:
	maximum = num2
elif num2 < num1 and num2 < num3 and num2 < num4:
	minimum = num2

if num3 > num2 and num3 > num1 and num3 > num4:
	maximum = num3
elif num3 < num2 and num3 < num1 and num3 < num4:
	minimum = num3

if num4 > num2 and num4 > num3 and num4 > num1:
	maximum = num4
elif num4 < num2 and num4 < num3 and num4 < num1:
	minimum = num4


print(maximum, minimum)


if minimum == num1:
	if num2 > minimum and num2 > num3 and num2 > num4 and num2 < maximum:
		third_num = num2
	if num3 > minimum and num3 > num2 and num3 > num4 and num3 < maximum:
		third_num = num3
	if num4 > minimum and num4 > num2 and num4 > num3 and num4 < maximum:
		third_num = num4



if minimum == num2:
	if num1 > minimum and num1 > num3 and num1 > num4 and num1 < maximum:
		third_num = num1
	if num3 > minimum and num3 > num1 and num3 > num4 and num3 < maximum:
		third_num = num3
	if num4 > minimum and num4 > num3 and num4 > num1 and num4 < maximum:
		third_num = num4



if minimum == num3:
	if num1 > minimum and num1 > num2 and num1 > num4 and num1 < maximum:
		third_num = num1
	if num2 > minimum and num2 > num1 and num2 > num4 and num2 < maximum:
		third_num = num2
	if num4 > minimum and num4 > num2 and num4 > num1 and num4 < maximum:
		third_num = num4



if minimum == num4:
	if num1 > minimum and num1 > num2 and num1 > num3 and num1 < maximum:
		third_num = num1
	if num2 > minimum and num2 > num1 and num2 > num3 and num2 < maximum:
		third_num = num2
	if num3 > minimum and num3 > num2 and num3 > num1 and num3 < maximum:
		third_num = num3
		

print(minimum, second_num, third_num, maximum)


sum = num1 + num2 + num3 + num4

second_num = sum - (third_num + maximum + minimum)



mean = sum / 4
median = (num2 + num3) / 2
print("The sum is: ", sum, "\nThe mean is: ", mean, "\nThe median is: ", median)
