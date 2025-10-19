let number1 = 6;
let number2 = 15;
let LCM = 1;
let multiple = 2;

while (number1 != 1 || number2 != 1){
	if( number1 % multiple == 0 || number2 % multiple == 0){
		if(number1 % multiple == 0)
			number1 /= multiple;
		if (number2 % multiple == 0)
			number_2 /= multiple;
		LCM *= multiple;}
	else
		multiple++;
	}
