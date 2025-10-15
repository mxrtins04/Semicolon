let word = "eniifeoluwa"
let count = 0;
let e_sum = 0;

while(count < word.length) {
	if (word[count] == "e") {
	e_sum += 1;
	}
	count += 1;
}
console.log(e_sum);