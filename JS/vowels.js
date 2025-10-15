let word = "eniifeoluwa"
let a = 0;
let e = 0;
let i = 0;
let o = 0;
let u = 0;

let count = 0;
while(count < word.length) {
	if (word[count] == "a") a += 1;
	if (word[count] == "e") e += 1;
	if (word[count] == "i") i += 1;
	if (word[count] == "o") o += 1;
	if (word[count] == "u") u += 1;
	count += 1

}
	let total = a + e + i + o + u
	console.log(total)