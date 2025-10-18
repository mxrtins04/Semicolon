let word = "ConaTE"
let compare = word.toLowerCase()

let counter = 0;

for(let count = 0; count < word.length; count++){
if( word.charAt(count) == compare.charAt(count) ) counter += 1;
}

console.log(counter);
