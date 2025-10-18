public class PerfectNumber{
public static void main(String [] args){
	int number = 7;
	int sum = 0;


	for( int divisor = 1; divisor < number; divisor++ ){
		if( number % divisor == 0 )
			sum += divisor;
		}

	if( sum == number )
		System.out.printf("%d is a positive number", number);
	else
		System.out.printf("%d is not positive number", number);

}}