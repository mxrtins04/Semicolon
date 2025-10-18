def get_string_length(name):
	count = 0
	for char in name:
		count += 1
	return (count)


#print(get_string_length('hay'))


def convert_to_minutes_and_hour(minutes):
	seconds = minutes * 60
	hour = minutes / 60

	#print(f"{minutes}min in seconds is {seconds} and is {hour}hours")

convert_to_minutes_and_hour(1400)

def count_vowels(word):
	count = 0
	a = 0
	e = 0
	i = 0
	o = 0
	u = 0
	for char in word:
		
		match char:
			case 'a':
				count += 1
				if( a < 1):
					a += 1
				else:
					break
			case 'e': 
				count += 1
				if( e < 1):
					e += 1
				else:
					break
			case 'i':
				count += 1
				if( i < 1):
					i += 1
				else:
					break
			case 'o':
				count += 1
				if( o < 1):
					o += 1
				else:
					break
			case 'u':
				count += 1
				if( u < 1):
					u += 1
				else:
					break



	return(count)
word = 'pineapple'
#print(count_vowels(word))


def swap_letters(word):
	length = len(word)
	reverse = " "

	for char in word:
		reverse = char + reverse
	return (reverse)			
			
	
print(swap_letters('tolu'))

