e = 1

for count in range (1, 11):
	while count > 1:
		count = count * (count - 1)
		break
	e = e + ( e / count)
	

print(e)
