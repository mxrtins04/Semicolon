
number = int(input("Input a five digit integer: "))

num5 = number % 10

num4 = int((number / 10) % 10)

num3 = int((number / 100) % 10)

num2 = int((number / 1000) % 10)

num1 = int((number / 10000) % 10)

print(num1, num2, num3, num4, num5)