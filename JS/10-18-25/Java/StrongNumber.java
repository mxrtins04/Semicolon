public class StrongNumber{
public static void main(String [] args){

	int number =  125;
	String numString = String.valueOf(number);
	int length = numString.length();
	int sum = 0;
	
	for( int index = 0; index < length; index++){
		int factorial = 1;	
		char charDigit = numString.charAt(index);

		int digit = Character.getNumericValue(charDigit);
		
		while( digit >= 1 ){
			factorial *= digit;
			digit--;}
		
		sum += factorial;
	}

	if( sum == number ) 
		System.out.printf("%d is a strong number", number);
	else
		System.out.printf("%d is not a strong number", number);
}}
					
