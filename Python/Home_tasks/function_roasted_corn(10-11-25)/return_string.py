def return_string(word, number):
	output = ""
	if( number % 2 == 0):
		while number > 0:
			output += word
			number -= 1
	else:
		output = word
	return(output)

print(return_string('ha', 8))