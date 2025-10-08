from Kata import get_number_of_boxes, get_money_spent_on_pizza, get_left_over_pizza

num_of_people = int(input("How many people are you squandering your money on? "));


print("""

	----------------------------------------------------------
	| Pizza Type	 |Number of Slices|Price per box  |    	 |
	|________________|________________|_______________|______|
	| Sapa size	 |4		  |2500		  |    	 |
	|________________|________________|_______________|______|
	| Small money	 |6		  |2900		  |    	 |
	|________________|________________|_______________|______|
	| Big boys	 |8		  |4000		  |    	 |
	|________________|________________|_______________|______|
	| Odogwu	 |12		  |5200		  |    	 |
	|________________|________________ |_______________|______|	
	""")

pizza_type = input("What pizza type would you like to order? ").lower()

match (pizza_type):

	case "sapa size" :
			number_of_slices = 4;
			price_per_box = 2500;
	
			number_of_boxes = get_number_of_boxes(num_of_people, number_of_slices)
			leftover = get_left_over_pizza(num_of_people, number_of_slices, number_of_boxes)
			bill = get_money_spent_on_pizza(number_of_boxes, price_per_box)


			print(f"Number of boxes of pizza to buy = {number_of_boxes} boxes");


			if( leftover > 0):
				print(f"Number left over after serving = {leftover}")

			print(f"Price = {bill}")

	case "small money" :
			number_of_slices = 6
			price_per_box = 2900
	
			number_of_boxes = get_number_of_boxes(num_of_people, number_of_slices)
			leftover = get_left_over_pizza(num_of_people, number_of_slices, number_of_boxes)
			bill = get_money_spent_on_pizza(number_of_boxes, price_per_box)


			print(f"Number of boxes of pizza to buy = {number_of_boxes} boxes");


			if( leftover > 0):
				print(f"Number left over after serving = {leftover}")

			print(f"Price = {bill}")
			

	case "big boys" :
			number_of_slices = 8;
			price_per_box = 4000;
	
			number_of_boxes = get_number_of_boxes(num_of_people, number_of_slices)
			leftover = get_left_over_pizza(num_of_people, number_of_slices, number_of_boxes)
			bill = get_money_spent_on_pizza(number_of_boxes, price_per_box)

			print(f"Number of boxes of pizza to buy = {number_of_boxes} boxes");


			if( leftover > 0):
				print(f"Number left over after serving = {leftover}")

			print(f"Price = {bill}")

	case "odogwu" :
			number_of_slices = 12;
			price_per_box = 5200;
	
			number_of_boxes = get_number_of_boxes(num_of_people, number_of_slices)
			leftover = get_left_over_pizza(num_of_people, number_of_slices, number_of_boxes)
			bill = get_money_spent_on_pizza(number_of_boxes, price_per_box)


			print(f"Number of boxes of pizza to buy = {number_of_boxes} boxes");


			if( leftover > 0):
				print(f"Number left over after serving = {leftover}")

			print(f"Price = {bill}")
