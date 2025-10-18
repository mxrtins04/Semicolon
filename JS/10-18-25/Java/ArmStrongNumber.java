public class ArmStrongNumber{
public static void main(String [] args){
	int number = 153;
	String numString = String.valueOf(number);
	int length = numString.length();

	int sum = 0;

	for( int index = 0; index < length; index++){
		char charDigit = numString.charAt(index);

		int digit = Character.getNumericValue(charDigit);
		sum += Math.pow(digit, length);
	
		}
	if( sum == number )
		System.out.printf("%d is an Armstrong number", number);
	else
		System.out.printf("%d is not an Armstrong number", number);

}}