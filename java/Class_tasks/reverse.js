let sentence = "This is an example";

let words = sentence.split(" ");
let reverse = "";	
for( word of words ){
	for( let index = word.length - 1; index >= 0; index-- ){	
		reverse += word.charAt(index);
	}
	reverse += " ";
}

console.log(reverse);