total_miles = 0.0
total_gallons = 0.0

while True:
	miles = input("Enter miles driven (or stop): ")
	if miles == "stop":
		break
	miles = float(miles)

	gallons = input("Enter gallons used: ")
	gallons = float(gallons)

	miles_per_gallon = miles / gallons
	print("The miles per gallon for this tankful: ",miles_per_gallon)

	total_miles += miles
	total_gallons += gallons

combined_miles_per_gallon = total_miles / total_gallons
print("The overall average is: ", combined_miles_per_gallon )