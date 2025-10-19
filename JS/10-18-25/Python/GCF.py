number_1 = 12
number_2 = 18
GCF = 0

for divisor in range(1, number1):
	if number_1 % divisor == 0 and number_2 % divisor == 0:
		GCF = divisor

print(GCF)