public class LCM{
public static void main(String [] args){
	
	int number1 = 6;
	int number2 = 15;
	int LCM = 1;
	int multiple = 2;	

	while( number1 != 1 || number2 != 1 ){
		if( number1 % multiple == 0 || number2 % multiple == 0){
			if( number1 % multiple == 0 )
				number1 /= multiple;
			if( number2 % multiple == 0 )
				number2 /= multiple;
			LCM *= multiple;}
	
		else
			multiple++;

		}
	System.out.printf("The LCM of both numbers is %d", LCM);


}}
