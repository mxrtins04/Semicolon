let count = 0

for (let year = 1900; year <= 2025; year++){
	if (year % 100 == 0){
		if (year % 400 == 0)
			count ++;
}
	if (year % 4 == 0 and year % 100 != 0)
		count += 1;

console.log(count);