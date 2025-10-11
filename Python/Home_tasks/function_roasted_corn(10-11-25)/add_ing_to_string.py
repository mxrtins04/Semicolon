def add_ing_to_a_string(word):
	last_letters = word[-3] + word[-2] + word[-1]
	
	if( len(word) >= 3 ):
		if( last_letters == "ing" ):
			word += "ly"
		else:
			word += "ing"
	return(word)	

print(add_ing_to_a_string("blink"))