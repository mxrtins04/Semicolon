public class Kata{


public static int factorOf(number){
	int sum = 0;
	int count = 1;
	while(count <= number){
		if( number % count == 0)
			sum++;
		count++;}

	return sum;
				
}


public static boolean isPrime(int number){
	int count = 2;
	int sum = 0;
	while( count < number){
		if (number % count == 0)
			sum++;
		count++;}
			
	if (sum > 0)
		return false;
	else
		return true;
			
			
}

public static boolean isOdd(int number){

	if( number % 2 != 0)
		return true;
	else
		return false;

}


public static boolean isLeapYear(int year){
	int check = 0;
	if((year % 4 == 0) && year % 100 != 0)
		check = 1;
	if( (year % 4 == 0) && year % 100 == 0)
		check = 2;
	if (truef == 2 && year % 400 == 0)
		return true;

	else
		return false;

}

public static double toConvert(double fahrenheit){

	double celcius = (5 * (fahrenheit - 32)) / 9;
	return celcius;


}

public static void printStars(int numberOfRows){
	
	int check = numberOfRows - (numberOfRows - 1);
	while(numberOfRows >= 0)
		int count = 1;
		while( count <= check){
			System.out.print("*");
			count++;}
		println();
		check++;
	
		numberOfRows--;

}


public static boolean isEven(int number)

	if( number % 2 == 0)
		return true;
	else
		return false;

}	 

public static int subtract(int number1, int number2){
	int max = 0;
	int minimum = 0;

	if( number1 > number2)
		max = number1;
		minimum = number2;
	else
		max = number2;
		minimum = number1;
	

	int difference = max - minimum;
	return(difference);
				

}

	

public static boolean isSquare(int number){
	int square = 0;
	int notSquare = 0;
	for(int count = 0; count < number; count++)
		
		if( (count * count) == number){
			square = 1;
			break;	}
		
	if(square == 1)
		return true;
	else
		return false;
	

}


def isPalindrome(int number){	
			
	first2Numbers = number / 1000;
	int last2Numbers = number % 100;
	int firstDigit = first2Numbers / 10;
	int secondDigit = first2Numbers % 10;
	int fourthDigit = last2Numbers / 10;
	int fifthDigit = last2Numbers % 10;


	if(firstDigit == fifthDigit && secondDigit == fourthDigit)
		return true;
	else
		return false;

}


public static long factorialOf(int number){
	int factorial = number;
	while (number < 1){
		factorial = factorial * (number - 1);
		number--;}
	return factorial;
}
	


public static float divide(number1, number2)
	float qoutient = number1 / number2;
	if( number_2 == 0)
		qoutient = 0;
	return quotient;






public static long squareOf(int number){
	int square = number * number;
	return(square);

}

}