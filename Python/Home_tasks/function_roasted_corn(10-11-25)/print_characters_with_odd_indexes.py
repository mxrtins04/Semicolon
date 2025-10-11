def print_characters_with_odd_indexes(word):
	letters_with_odd_index = " "
	count = 0
	for letter in word:
		if( count % 2 != 0):
			letters_with_odd_index += letter
		count += 1
	return(letters_with_odd_index)

print(print_characters_with_odd_indexes('james'))			