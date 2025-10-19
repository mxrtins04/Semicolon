count = 0

for year in range(1000, 2026):
	if year % 100 == 0:
		if year % 400 == 0:
			count += 1
	if year % 4 == 0 and year % 100 != 0:
		count += 1

print(count)