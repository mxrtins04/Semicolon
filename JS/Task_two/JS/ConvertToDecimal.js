let input = "101100"
let answer = 0

let power = (input.length) - 1

for(let count = 0; count < input.length; count +=1) {
	let number = input.charAt(count) * (2 ** power)
	power -= 1
	answer += number
}	
console.log(answer)