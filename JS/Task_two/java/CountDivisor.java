public class CountDivisor{
	public static void main(String [] args){
		int number = 18;
		int count = 0;
		
	
	for(int divisor = 1; divisor <= number; divisor++){
		
		if( number % divisor == 0 ){
			System.out.print(divisor);
			System.out.println();	
			count++;}

		}
	System.out.printf("The number of divisors is %d", count);
	
	}
}

