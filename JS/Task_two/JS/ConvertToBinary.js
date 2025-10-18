let input = 32

let answer = ""

let count = 0
while(input != 0) {
	let remainder = input % 2
	input = Math.floor(input / 2)	
	answer = String(remainder) + answer
	count += 1
}
console.log(answer)