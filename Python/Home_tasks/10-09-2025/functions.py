class home_snack:
	def get_length_of_list(the_list):
		length = 0
		for item in the_list:
			length += 1
		return(length)

	def even_index_value_sum(the_list):
		sum = 0
		for item in(the_list):
			if( item % 2 == 0):
				sum += 1
		return(sum)

	def odd_index_value_sum(the_list):
		sum = 0
		for item in(the_list):
			if( item % 2 != 0):
				sum += 1
		return(sum)

	def get_third_position_product(the_list):
		product = 1
		count = 0
		length = len(the_list)
		for item in the_list:
			count += 1
			if( count % 3 == 0 ):
				product *= item
		return(product)

	def get_average_of_list(the_list):
		sum = 0
		count = 0
		for item in the_list:
			count += 1
			sum += the_list[item]

		average = sum / count
			
	def get_largest_in_list(the_list):
		highest = 0
		for item in the_list:
			if the_list[item] > highest:
				highest = the_list[item]
		return(highest)

	def construct_list(the_list):
		for number in range(1, 16, 2):
			the_list.append(number)
		return(the_list)
	def get_third_element(the_list):
		third_element = the_list[2]
		return third_element

	def get_sum_of_first_middle_and_last_elements(the_list):
		middle_index = (len(the_list)) / 2
		middle_element = the_list[middle_index]
		second_middle_element = the_list[middle_element - 1]

		if( len(the_list) % 2 == 0:
			middle_element += second_middle_element
			middle_element /= 2

		sum = the_list[0] + middle_element + the_list[-1]

		
		
		

	
	

			
		