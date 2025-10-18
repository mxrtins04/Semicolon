def find_longest(sentence):
	index = 0
	highest = len(sentence[0])
	for word in sentence:
		while index < len(word):
			index += 1
			if index > highest:
				highest == word
	return(highest)

sentence = "the quick brown fox"

print(find_longest(sentence))