number = "57942";

let count = 0;
let largest_digit = number[0];

while(count < number.length) {
	if(number[count] > largest_digit) largest_digit = number[count];
	count += 1
}
console.log(largest_digit)