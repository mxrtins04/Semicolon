let sentence = "it's a bi-weekly event."

let counter = 1
for(let count = 0; count < sentence.length; count += 1){
	if(sentence.charAt(count) == " ") counter += 1
}

console.log(counter)