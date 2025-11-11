public class Assesment{
	public void printHelloWorld(){
		System.out.println("Hello, World");
	}

	public static void checkMultiple(int number){
		int startingNumber = 1;

		while (startingNumber <= number){

		if( startingNumber % 4 == 0 && startingNumber % 6 == 0 )
			System.out.println("Hello World");
	
		else if( startingNumber % 4 == 0 )
			System.out.println("Hello");
		else if( startingNumber % 6 == 0 )
			System.out.println("World");
		
		else 
			System.out.println(startingNumber);
					
		startingNumber++;
		
		}
	}

	public static int findLargestNumber(int[] numbers){
		int largestNumber = 0;
		for( int number : numbers ){
			for( int number1 : numbers ){
				if( number > number1)
					largestNumber = number;
			}
		}
		
		return largestNumber;
	}

	public static int[] sortArray(int[] numbers){
		for( int number = 0; number < numbers.length; number++ ){
			for( int index = 0; index < numbers.length - number - 1; index++ ){
				if(numbers[index] > numbers[index + 1]){
					int temporaryValue = numbers[index];
					numbers[index] = numbers[index + 1];
					numbers[index + 1] = temporaryValue;
					}
			}
		}
		return numbers;
	}
}