from logistics_services_functions import*


while True:
   		
	parcels_sold = int(input("Enter operation: "))
	pay = get_drivers_payment(parcels_sold)
	if  isinstance((get_drivers_payment(parcels_sold)), int):
		print(f"The pay for this rider is {pay}")
		print("Thanks for all your hardwork")
		break
	else:
		print((get_drivers_payment(parcels_sold)))
 