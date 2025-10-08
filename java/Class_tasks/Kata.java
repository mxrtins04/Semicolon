public class Kata{


public static int factorOf(int number){
	int sum = 0;
	int count = 1;
	while(count <= number){
		if( number % count == 0)
			sum++;
		count++;}

	return sum;
				
}


public static boolean isPrime(int number){
	int count = 2;
	int sum = 0;
	while( count < number){
		if (number % count == 0)
			sum++;
		count++;}
			
	if (sum > 0)
		return false;
	else
		return true;
			
			
}

public static boolean isOdd(int number){

	if( number % 2 != 0)
		return true;
	else
		return false;

}


/* public static boolean isLeapYear(int year){
	int check = 0;
	if((year % 4 == 0) && year % 100 != 0)
		check = 1;
	if( (year % 4 == 0) && year % 100 == 0)
		check = 2;
	if (truef == 2 && year % 400 == 0)
		return true;

	else
		return false;

}
*/
public static double toConvert(double fahrenheit){

	double celcius = (5 * (fahrenheit - 32)) / 9;
	return celcius;


}

/* public static void printStars(int numberOfRows){
	
	int check = numberOfRows - (numberOfRows - 1);
	while(numberOfRows >= 0)
		int count = 1;
		while( count <= check){
			System.out.print("*");
			count++;}
		System.out.println();
		check++;
	
		numberOfRows--;

}

*/
public static boolean isEven(int number){

	if( number % 2 == 0)
		return true;
	else
		return false;

}	 

public static int subtract(int number1, int number2){
	int max = 0;
	int minimum = 0;

	if( number1 > number2){
		max = number1;
		minimum = number2;}
	else{
		max = number2;
		minimum = number1;}
	

	int difference = max - minimum;
	return(difference);
				

}

	

public static boolean isSquare(int number){
	int square = 0;
	int notSquare = 0;
	for(int count = 0; count < number; count++)
		
		if( (count * count) == number){
			square = 1;
			break;	}
		
	if(square == 1)
		return true;
	else
		return false;
	

}


public static boolean isPalindrome(int number){	
			
	int first2Numbers = number / 1000;
	int last2Numbers = number % 100;
	int firstDigit = first2Numbers / 10;
	int secondDigit = first2Numbers % 10;
	int fourthDigit = last2Numbers / 10;
	int fifthDigit = last2Numbers % 10;


	if(firstDigit == fifthDigit && secondDigit == fourthDigit)
		return true;
	else
		return false;

}


public static long factorialOf(int number){
	int factorial = number;
	while (number < 1){
		factorial = factorial * (number - 1);
		number--;}
	return factorial;
}
	


/* public static float divide(number1, number2)
	float qoutient = number1 / number2;
	if( number2 == 0)
		qoutient = 0;
	return quotient;
*/





public static long squareOf(int number){
	int square = number * number;
	return(square);
}

public static int getNumberOfBoxes(int numOfPeople, int numberOfSlices){
	int numberOfBoxes = numOfPeople / numberOfSlices;
	if (numOfPeople % numberOfSlices != 0) 
		numberOfBoxes++;
	return (numberOfBoxes);
}

public static int getNumberOfSlicesServed(int numberOfSlices, int numOfPeople){
	int slicesServed = numberOfSlices * numOfPeople;
	return slicesServed;

}


public static int getMoneySpentOnPizza(int numberOfBoxes, int pricePerBox){
	int bill = numberOfBoxes * pricePerBox;
	return bill;


}

public static int getLeftOverPizza(int numOfPeople, int numberOfSlices, int numberOfBoxes){
	int leftover = (numberOfSlices * numberOfBoxes) - numOfPeople;
	return (leftover);
}

public static int findSmallest(int array[]){
	int lastIndex = array.length - 1;
	int smallestInt = array[0];

	while( lastIndex >= 0){
		if( array[lastIndex] < smallestInt)
			smallestInt = array[lastIndex];
		lastIndex--;}
	return (smallestInt);	
}

public static double averageArray(int array[]){
	int lastIndex = array.length - 1;
	int sum = 0;
	while( lastIndex >= 0 ){
		sum += array[lastIndex];
		lastIndex++;}
	double average = sum / (array.length);
	
}

public static int countOccurence(int array[], int targetNumber){
	int occurence = 0;
	for(int index = 0; index < array.length; index++){
		if( targetNumber == array[index] )
			occurence++;
		} 

	return (occurence);


}


public static boolean containsElement(int array[], int targetNumber){
	for(int index = 0; index < array.length; index++){
		if( targetNumber == array[index] )
			return (true);
		else
			return (false); }


}


public static int getFirstElement(int array[]){
	int firstElement = array[0];
	if( array == array[0])
		return (0);
	else
		return (firstElement);


}


public static int getLastElement(int array[]){
	lastElement = array[(array.length - 1)];
	if( array == array[0])
		return (0);
	else
		return (lastElement);


}


public static int arrayLength(int array[]){
	int arrayLength = 0;

	for(int index = 0; index < array.length; index++){
		arrayLength++;
			}
	return(arrayLength);
		

}

public static int getMiddleElement(int array[]){
	int arrayLength = array.length;
	int middleIndex = arrayLength / 2;

	if( arrayLength % 2 == 0)
		return(new int []{array[middleIndex], array[middleIndex + 1]});
	else
		return(array[middleIndex]);
	
	
	}

public static int swapFirstAndLast(int array[]){
	int firstNumber = array[0];
	int lastNumber = array[array.length - 1];

	array[array.length - 1] = firstNumber;
	array[0] = lastNumber;

	return(array);


}

/* public static int findNumberOfIndex(int[]){
	int count = 0;
	while( int
	*/





}

