let numbers = " "
for(let number = 1; number <= 100; number += 1) {
	let count = 0
	for(let divisor = 1; divisor <= number; divisor += 1) {
		if(number % divisor == 0) count += 1
}
if(count == 2) numbers += number
}	
		
console.log(numbers)