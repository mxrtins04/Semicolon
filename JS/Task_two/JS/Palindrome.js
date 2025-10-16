let number = "12321"

let reverse = " "
for(let digit = 0; digit < number.length; digit += 1) {
	 reverse = number[digit] + reverse
}
if(reverse == Number(number)) console.log("True")
if(reverse != Number(number)) console.log("False")