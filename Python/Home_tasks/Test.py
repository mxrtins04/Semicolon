the_list = [3,4,7,2,54]

def even_index_value_sum(the_list):
		sum = 0
		for item in(the_list):
			if( item % 2 == 0):
				sum += 1
		return(sum)
print(even_index_value_sum(the_list))
