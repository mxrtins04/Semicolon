let number1 = 12;
let number2 = 18;
let GCF = 0;

for (let divisor = 1; divisor < number1; divisor++){	
	if(number1 % divisor == 0 && number2 % divisor == 0)
		GCF = divisor;
}
console.log(GCF);