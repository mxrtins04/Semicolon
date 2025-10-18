public class GCF{
public static void main(String [] args){

int number1 = 12;
int number2 = 18;
int GCF = 0;

for( int divisor = 1; divisor < number1; divisor++){
	if (number1 % divisor == 0 && number2 % divisor == 0)
		GCF = divisor;
	
	}

System.out.printf("The GCF for %d and %d is %d", number1, number2, GCF);
}}