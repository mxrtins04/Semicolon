let number = "153756"

let sum = 0
for(let count = 0; count < number.length; count += 1) {
	if(number.charAt(count) % 2 == 0) sum += Number(number.charAt(count))
}
console.log(sum) 