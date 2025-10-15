let number = "12345"

let count = 0;
let sum = 0;
while(count < number.length) {
	sum += Number(number[count]);
	count += 1;
}
console.log(sum);