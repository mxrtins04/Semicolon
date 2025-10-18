words = ["lamp", "kit", "yam", "kings", "dogs", "man"]

new_list = []


"""def change_color(colors):
	
	
	colors[2] = 'yellow'
	
	return(colors)

def get_third_element(num):
	third_element = nums[2]
	return(third_element)

def append_purple_to_list(colors):
	colors.append("purple")
	return(colors)

def remove_elements(my_list):
	my_list.remove(3)
	return(my_list)



def display_length(names, new_list):
	count = 0
	for name in names:
		new_list.append(len(name))
		
	
	return(new_list)


def sort_list_in_ascending_order(my_list):
	my_list.sort()
	return(my_list)
print(sort_list_in_ascending_order(my_list))


def create_new_list(my_list, new_list):
	for number in my_list:
		if( number % 2 == 0):
			new_list.append(number)
	return(new_list)
#print(create_new_list(my_list, new_list))


def combine_two_list(a, b):
	new_list = a + b
	return(new_list)"""

def new_list_with_over_3_characters(words, new_list):
	for word in words:
		if (len(word) > 3 ):
			new_list.append(word)

	return(new_list)
print(new_list_with_over_3_characters(words, new_list))
