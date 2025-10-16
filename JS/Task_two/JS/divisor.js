let number = 18

let count = 0
for(let divisor = 1; divisor <= number; divisor += 1) {
	if(number % divisor == 0) {
	count += 1
	console.log(divisor);
}
}
console.log(count)