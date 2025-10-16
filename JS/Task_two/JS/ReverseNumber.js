let number = "12338545"

let reverse = " "
for(let digit = 0; digit < number.length; digit += 1) {
	 reverse = number[digit] + reverse
}
console.log(reverse)