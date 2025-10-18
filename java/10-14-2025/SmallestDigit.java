public class SmallestDigit {
public static void main(String[] args) {

	int number = 123458;
	int[] numbers = {1,2,3,4,5,8};

	int smallestDigit = numbers[0];

	int count = 0; 
	while(count < numbers.length) {
		if(numbers[count] < smallestDigit)
			smallestDigit = numbers[count];
		count++;
}

	System.out.print(smallestDigit);
}
}