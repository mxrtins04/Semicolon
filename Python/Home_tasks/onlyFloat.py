def onlyFloat(a, b)
	a = 10.11
	b = 4
	whole_number_a = a / 1
	whole_number_b = b / 1

	if( (a != whole_number_a) and (b != whole_number_b)):
		print("2")

	else if( (a != whole_number_a) or (b != whole_number_b)):
		print("1")
	
	else if( (a == whole_number_a) and (b == whole_number_b)):
		print("0")
