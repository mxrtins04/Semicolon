for (let number = 1; number <= 1000; number++){
	let sum = 0;

	for (let divisor = 1;divisor < number; divisor++){
		if (number % divisor == 0)
			sum += divisor;
	}
	if (sum == number)
		console.log(number);
	