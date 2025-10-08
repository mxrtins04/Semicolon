


def factorOf(number):
	sum = 0
	count = 1
	while(count <= number):
		if( number % count == 0):
			sum =+ 1
		count =+ 1


	return sum

		
				



def isPrime(number):
	count = 2
	sum = 0
	while( count < number):
		if (number % count == 0):
			sum =+ 1
		count =+ 1
			
	if (sum > 0):
		return false
	else:
		return true
			
			
			




def isOdd(number):

	if( number % 2 != 0):
		return true
	else:
		return false




def isLeapYear(year):
	check = 0
	if((year % 4 == 0) and (year % 100 != 0)):
		check = 1
	if( (year % 4 == 0) and (year % 100 == 0)):
		check = 2
	if (truef == 2 and year % 400 == 0):
		return true

	else:
		return false



def toConvert(fahrenheit):

	celcius = (5 * (fahrenheit - 32)) / 9
	return celcius




def printStars(number_of_rows):
	
	check = number_of_rows - (number_of_rows - 1)
	while(number_of_rows >= 0):
		count = 1
		while( count <= check):
			print("*")
			count =+ 1
		print("/n")
		check =+ 1
	
		number_of_rows -= 1


def isEven(number):

	if( number % 2 == 0):
		return true
	else:
		return false

		 

def subtract(number_1, number_2):
	max = 0
	minimum = 0
	equal = false
	if( number_1 > number_2):
		max = number_1
		minimum = number_2
	else:
		max = number2
		minimum = number1
	

	difference = max - minimum
	return(difference)
				


	
	

#def isSquare(number):
#	square = 0
#	notSquare = 0
#	for(count = 0; count < number; count++)
		
#		if( (count * count) == number):
#			square = 1
#			break	
		
#	if(square == 1):
#		return true
#	else
#		return false
	




def isPalindrome(number):	
			
	first_2_Numbers = number / 1000
	last_2_Numbers = number % 100
	first_Digit = first_2_Numbers / 10
	second_Digit = first_2_Numbers % 10
	fourth_Digit = last_2_Numbers / 10
	fifth_Digit = last_2_Numbers % 10


	if(first_Digit == fifth_Digit and second_Digit == fourth_Digit):
		return true
	else:
		return false




def factorialOf(number):
	factorial = number
	while (number < 1):
		factorial = factorial * (number - 1)
		number -= 1
	return factorial
	


def divide(number_1, number_2):

	qoutient = number_1 / number_2

	qoutient = number_1 / number_2

	if( number_2 == 0):
		qoutient = 0
	return qoutient






def squareOf(number):
	square = number * number
	return(square)



def get_number_of_boxes(num_of_people, number_of_slices):
	number_of_boxes = num_of_people / number_of_slices
	if (num_of_people % number_of_slices != 0) :
		number_of_boxes += 1
	return (number_of_boxes)


#def (num_of_people, number_of_slices):
#	slicesServed = number_of_slices * num_of_people
#	return (slicesServed)




def get_money_spent_on_pizza(number_of_boxes, price_per_box):
	bill = number_of_boxes * price_per_box
	return (bill)



def get_left_over_pizza(num_of_people, number_of_slices, number_of_boxes):
	leftover = (number_of_slices * number_of_boxes) - num_of_people
	return (leftover)



