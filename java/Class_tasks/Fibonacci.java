public class Fibonacci{
	public static void main(String [] args){
		
		int previousNumber = 1;
		int numberBefore = 0;
		System.out.print(numberBefore);
		System.out.print(previousNumber);
		for(int count = 0; count < 20; count++){
			int newNumberBefore = previousNumber;
				int currentNumber = numberBefore + previousNumber;
			if (count > 1)
				currentNumber = newNumberBefore + previousNumber;
	
			
			
			System.out.print(numberBefore);
			System.out.print(previousNumber);
			System.out.print(currentNumber);
			System.out.println();		
			previousNumber = currentNumber;
			 }

}}

