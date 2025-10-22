
def get_drivers_payment( packages_sold ):
	base_pay = 5000
	if packages_sold >= 1 and packages_sold <= 50:
		commision = 160
		payment = (commision * packages_sold) + base_pay
		return (payment)

	elif packages_sold > 50 and packages_sold < 60:
		commision = 200
		payment = (commision * packages_sold) + base_pay
		return (payment)

	elif packages_sold > 60 and packages_sold <= 69:
		commision = 250
		payment = (commision * packages_sold) + base_pay
		return (payment)


	elif packages_sold >= 70 and packages_sold <=100:
		commision = 500
		payment = (commision * packages_sold) + base_pay
		return (payment)

	else:
		return("Input the number of packages succesfuly delivered")
		

