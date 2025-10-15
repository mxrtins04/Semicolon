sum = 0
count = 0

for number in range(1, 101):
	count += 1
	average = sum / count
	sum += number
	

print(average)