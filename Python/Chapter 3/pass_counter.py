passes = 0 
failures = 0

while true:
 

result = int(input('Enter result (1=pass, 2=fail, -2 to stop): '))
	if result == -1:
		break

	if result == 1:
		passes = passes + 1
 	elif result == 2:
		failures = failures + 1
	else:
		print('Enter a valid number: )

	

	

print('Passed:', passes)

print('Failed:', failures)

if passes > 8:
	print('Bonus to instructor')