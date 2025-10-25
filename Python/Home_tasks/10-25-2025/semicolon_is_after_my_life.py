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