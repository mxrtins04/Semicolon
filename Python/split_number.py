"""
- Collect a number from user and assign it to the variable number
- Find the remainder of number when its divided by 10, then assign it to the variable num5

- divide number by 10, then find the remainder when its divided by 10, and assign that value to num4.

- divide number by 10, then find the remainder when its divided by 10, and assign that value to num3.

- divide number by 1000, then find the remainder when its divided by 10, and assign that value to num2.

- divide number by 10000, then find the remainder when its divided by 10, and assign that value to num1.

- Display num1, num2, num3, num4 and num5
"""

number = int(input("Input a five digit integer: "))

num5 = number % 10

num4 = int((number / 10) % 10)

num3 = int((number / 100) % 10)

num2 = int((number / 1000) % 10)

num1 = int((number / 10000) % 10)

print(num1, num2, num3, num4, num5)