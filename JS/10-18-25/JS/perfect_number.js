let number = 7;
let sum = 0

for (let divisor = 1;divisor < number; divisor++){
	if (number % divisor == 0)
		sum += divisor;

if (sum == number)
	console.log("It is a perfect number");
else
	console.log("It is not a perfect number");
