def get_longest_word_in_list(words):
	most_letters = 0
	longest_word = []
	length_of_longest_word = []
	
	for word in words:
		if( len(word) >= most_letters):
			length_of_longest_word.append( len(word) )
			longest_word.append( word )
			return(longest_word, length_of_longest_word)

words = ['semicolon', 'paralysis', 'github', 'get', 'games', 'money']

print(get_longest_word_in_list(words))