let word = "mayhyam"

let reverse = ""
for(let letter = word.length -1; letter >= 0; letter -= 1) {
	 reverse += word.charAt(letter) 
}
console.log(reverse)
if(reverse == word) console.log(word + " is a palindrome")

if(reverse != word) console.log(word + " is not a palindrome")