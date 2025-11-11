import java.util.Arrays;
public class AssesmentMain{
public static void main(String [] args){
	Assesment function = new Assesment();
	int[] numbers = {3,2,6,5};
	

	function.printHelloWorld();
	function.checkMultiple(12);	

	int largest = function.findLargestNumber(numbers);
	System.out.println(largest);
	int[] sorted = function.sortArray(numbers);
	System.out.println(Arrays.toString(sorted));

	

	
	
}
}
