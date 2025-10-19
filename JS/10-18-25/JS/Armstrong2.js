for (let number = 1; number <= 1000; number++){
	let num_string = String(number);
	let length = num_string.length;

	let sum = 0;

	for (let index = 0; index < length; index++){
		let char_digit = num_string.charAt(index);
		let digit  = Number(char_digit);
		sum += (digit ** length);

	if sum == number
		console.log(number);