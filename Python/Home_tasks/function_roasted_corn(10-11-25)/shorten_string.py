

def create_new_string(word):
	new_string = " "
	
	if( len(word) >= 2 ):
		new_string = word[0] + word[1] + word[-2] + word[-1]
	return (new_string)

print(create_new_string("semicolon"))