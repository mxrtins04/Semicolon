for year in range(1900, 2026):
	if year % 100 == 0:
		if year % 400 == 0:
			print(year)
	if year % 4 == 0 and year % 100 != 0:
		print(year)