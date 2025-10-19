for (let year = 1900; year <= 2025; year++) {
	if (year % 100 == 0) {
		if (year % 400 == 0)
			console.log(year);
	}
	if year % 4 == 0 && year % 100 != 0)
		console.log(year);
}