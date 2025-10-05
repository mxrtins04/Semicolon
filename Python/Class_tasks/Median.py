num1 = int(input("Enter first number: "))
num2 = int(input("Enter second number: "))
num3 = int(input("Enter third number: "))
num4 = int(input("Enter forth number: "))

if num1 > num2 and num1 > num3 and num1 > num4:

	largest = num1

elif num2 > num1 and num2 > num3 and num2 > num4:

	largest = num2

elif num3 > num1 and num3 > num2 and num3 > num4:

	largest = num3

elif num4 > num1 and num4 > num3 and num4 > num2:

	largest = num4



if num1 < num2 and num1 < num3 and num1 < num4:

	smallest = num1

elif num2 < num1 and num2 < num3 and num2 < num4:

	smallest = num2

elif num3 < num1 and num3 < num2 and num3 < num4:

	smallest = num3

elif num4 < num1 and num4 < num3 and num4 < num2:

	smallest = num4


sum1 = num1 + num2 + num3 + num4
sum2 = largest + smallest
middle_values = sum1 - sum2
median = middle_values / 2
print(median, "is the median")
print(sum1, "is the sum")

mean = sum1 // 4
print(mean, "is the mean")