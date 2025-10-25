from functools import reduce
words = ["I", "love", "pyhton", "snacks"]
numbers = [1,2,3,4,5,6]
words2 = ["apple", "bannana", "cherry", "kiwi", "grapes"]

def get_length(words):
	return len(words)
print(list(map(get_length, words2)))


def get_even_number(numbers):
	return numbers % 2 == 0
output = list(filter(get_even_number, numbers)) 
print(output)


def remove_greater_than_five(words):
	return (len(words) <= 5)
output = list(filter(remove_greater_than_five, words2))
print(output)


def add_words(words, word):
	return words + "-" + word
output = reduce(add_words, words)
print(output)
		
