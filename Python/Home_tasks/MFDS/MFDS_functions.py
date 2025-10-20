def choose_operation(input, transactions = []):	
	
	if isinstance(input, int):
		if int(input) > 2 or int(input) < 1:
			return("Please be sensible and put in an option that we've made available")

		match(input):
			case 1:
				return(1)
			case 2:
				return(2)

	else:
		return("Input a number please")


def buy_petroleum(operation, guage = ""):
	
	if isinstance(operation, int):
		if int(operation) > 4 or int(operation) < 1:
			return("Please be sensible and put in an option that we've made available")

	else:
		return("Input a number please: ")

	if isinstance(guage, guage):
		match(guage):
			case "liter":
				return(1)
			case "amount":
				return(2)
				 
		return("A number isn't required here, please read the instructions carefully.")
	
		

	
		


				
			