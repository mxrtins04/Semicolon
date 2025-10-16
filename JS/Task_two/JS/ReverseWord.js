let word = "johnsnow"

let reverse = " "
for(let letter = 0; letter < word.length; letter += 1) {
	 reverse = word[letter] + reverse
}
console.log(reverse)