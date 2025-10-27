from functools import reduce
def add_number_to_tuple_without_directly_modifying_it(new_number, numbers):
	if type(new_number) == int:
		return numbers + (new_number, )
	else:
		return("Please input a number")

def change_second_element_of_a_list_at_the_third_position_of_a_tuple(tuple_with_list_at_second_index, value):
		if type(tuple_with_list_at_second_index[2]) == list:
			if len(tuple_with_list_at_second_index[2]) > 1:
				tuple_with_list_at_second_index[2][1] = value
				return(tuple_with_list_at_second_index)
			else:
				return( "The list at the second index of the tuple has only one element" )
		else:
			return( "There is no list at the second index of the given tuple")

def add_mango_to_a_tuple_and_return_the_output_as_a_tuple(fruit = "apple", fruits_tuple = ("apple", "banana", "cherry")):
	fruits_list = list(fruits_tuple)
	fruits_list.append('mango')
	fruits_tuple = tuple(fruits_list)
	return(fruits_tuple)

"""def find_sum_of_each_element_in_list_of_list(input):
	sum = list(map(lambda inner_list: reduce(lambda x, y: x + y, inner_list), input))
	return( sum )

def find_sum_of_elements_in_corresponding_index_in_the_list_of_list(input):
	sum = list(filter(lambda x: filter(lambda x: [] == 0, input), input))
	return( sum )"""

def get_all_even_numbers_in_list_range():
	number_list = list(filter(lambda x: x % 2 == 0, range(1, 21)))
	return(number_list)
def extract_words_longer_than_5_characters(words):
	new_list = list(filter(lambda a: len(a) > 5, words))
	return(new_list)

def extract_tuples_where_first_value_is_greater_than_2(input):
	filtered = list(filter(lambda t: t[0] > 2, input))
	return(filtered)

def extract_all_numbers_divisible_by_both_3_and_5_in_given_range():
	divisible = list(filter(lambda x: x % 3 == 0 and x % 5 == 0, range(1, 51)))
	return(divisible)

def convert_all_strings_in_list_to_uppercase(strings):
	uppercase = list(map(str.upper, strings))
	return(uppercase)

def square_all_numbers_from_1_to_10():
	square = list(map(lambda x: x**2, range(1, 11)))
	return(square)

def capitalize_first_letter_of_names(names):
	
def add_10%_tax_to_each_price_in_given_list(prices):
	prices_with_tax = list(map(lambda x: x * 1.1, prices))
	return(prices_with_tax)

def sum_of_numbers_from_1_to_50():
	total = reduce(lambda a, b: a + b, range(1, 51))
	return(total)

def find_maximum_number_in_given_list(numbers):
	highest_number = reduce(lambda a, b: a if a > b else b, numbers)
	return(highest_number)

def combine_several_strings_to_one(words):
	words = ['I', 'love', 'Python']
	sentence = reduce(lambda a, b: a + ' ' + b, words)
	return(sentence)

def find_the_product_of_the_squares_of_numbers_in_a_list(numbers):
	product = reduce(lambda a, b: a * b, map(lambda x: x**2, numbers))
	return(product)
