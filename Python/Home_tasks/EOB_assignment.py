def get_smallest(number):
	smallest = 0
 	sum = 0
	for count in range(len(num)):
		sum += 1
	average = sum / count
	return average

def occurrence(num1, num2):
	target = num2
	sum = 0
	for count in range(len(num)):
		sum += 1
	average = sum / count

def first_number(number):
	first_number = number[0]
	return first_number


def get_last_number(num):
	last_number = 0
	for digits in range(len(num)):
		last = num[count - 1]
	return last

def get_length(num):
	length = 0
	for count in range(len(num)):
		middle = num[(len(num) - 1) // 2]
	return middle

def get_truth(num1, num2):
	target = num2
	contain = True
	for count in range(len(num)):
		if num2 == num[count]:
			contain = True
		else: 
			contain = False
	return contain

def getLastAndFirst(num):
	first = num[0]
	last = 0
	temp = 0
	for count in range(len(num)):
		last = num[count -1]
		temp = num[0]
		first = last
		last = temp

	return last
