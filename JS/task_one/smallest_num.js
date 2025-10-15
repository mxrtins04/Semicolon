number = "57942";

let count = 0;
let smallest_digit = number[0];

while(count < number.length) {
	if(number[count] < smallest_digit) smallest_digit = number[count];
	count += 1
}
console.log(smallest_digit)