public class ArmStrongNumber2{
public static void main(String [] args){


	for (int number = 1; number <= 1000; number++){
		String numString = String.valueOf(number);
		int length = numString.length();
		int sum = 0;
		for( int index = 0; index < length; index++){
			
			char charDigit = numString.charAt(index);

			int digit = Character.getNumericValue(charDigit);
			sum += Math.pow(digit, length);
			


			if( sum == number )
			System.out.println(number);
		}

	}
	

}}