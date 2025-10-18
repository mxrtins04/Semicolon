public class PerfectNumber2{
public static void main(String [] args){	


	
	for (int number = 1; number <= 1000; number++){

		int sum = 0;

		for( int divisor = 1; divisor < number; divisor++ ){
			if( number % divisor == 0 )
				sum += divisor;
			}

		if( sum == number )
			System.out.println(number);
		}
}}