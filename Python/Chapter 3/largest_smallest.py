total = 0
product = 1
smallest = None
largest = None


for num in range(1, 5):
	num = int(input("Enter number: "))

	total += num
	product *= num 

	if smallest == None or num < smallest:
		smallest = num

	if largest == None or num > largest:
		largest = num


average = total / 4

print("The total is" ,total)

print("The product is" ,product)

print("The smallest is" ,smallest)

print("The largest is" ,largest)

print("The average is" ,average)

