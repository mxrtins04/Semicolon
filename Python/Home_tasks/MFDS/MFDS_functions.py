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


def validate_petroleum_type(operation):
	
	if isinstance(operation, int):

		if int(operation) > 4 or int(operation) < 1:
			return("Please be sensible and put in an option that we've made available")

		return( operation )

	else:
		return("A number is required in this field, please try again.")
			

def validate_guage_type( guage = "" ):
	if isinstance(guage, str):
		if guage != "liter" or guage != "amount":
			return("Please input your preferred gauging method... liter or amount")
	else:
		return("A number isn't required here, please read the instructions carefully.")

def limit_petroleum_purhcase( liters ):
	if liters > 50:
		return("You don dey overdo... You are not allowed to buy more than 50 liters")
	
	if liters < 1:
		return("You have to buy above 1 litre...")

	else:
		return( liters )

def control_amount( amount ):
	if ( amount * price ) > ( 50 * price ):
		return("You don dey overdo... You are not allowed to buy more than 50 liters")
	if (amount * price ) <= ( price ):
		return("You have to buy above 1 litre...")

	else:
		return( amount )

	
	
		


				
			