let sum = 0;
let counter = 0
for(let count = 1; count < 101; count += 1) {
	sum += count;
	counter += 1;
}
let average = sum / counter;
console.log(average);