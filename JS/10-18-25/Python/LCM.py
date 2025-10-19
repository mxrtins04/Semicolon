number_1 = 6
number_2 = 15
LCM = 1
multiple = 2

while number_1 != 1 or number != 1:
	if number_1 % multiple == 0 or number_2 % multiple == 0:
		if number_1 % multiple == 0:
			number_1 //= multiple
		if number_2 % multiple == 0:
			number_2 //= multiplw
		LCM *= multiple

	else:
		multiple += 1
print(f"The LCM is {LCM})