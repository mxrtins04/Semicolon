def isPalindrome(number)	
			
	first_2_Numbers = number / 1000
	int last_2_Numbers = number % 100
	int first_digit = first_2_Numbers / 10
	int second_digit = first_2_Numbers % 10
	int fourth_digit = last_2_Numbers / 10
	int fifth_digit = last_2_Numbers % 10
	

	int count = 2
	int sum = 0
	while( count < number):
		if (number % count == 0)
			sum++
		count++
	
		
	if(first_Digit == fifth_digit && second_digit == fourth_digit && sum == 0 ):
		return true
	else
		return false

