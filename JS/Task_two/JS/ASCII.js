let word = "john"

let count = 0
for(letters in word) {
	let value = word.charCodeAt(count)
	console.log(value)
	count += 1
}