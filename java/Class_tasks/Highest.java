public class Highest{

	public static void main(String [] args){
		
	int[] firstArray = {10, 9, 13, 2, 14};
	int[] secondArray = {36, 14, 57, 23, 43, 0, -1};
	//int highestIndex1 = Math.max(firstArray[]);
	System.out.println(firstArray[]);

	int firstLargestNumber = 0;

	int secondLargestNumber = 0;
	for( int count = 0; count <= 5; count++){
		if( firstArray[count] > firstLargestNumber)
			firstLargestNumber = firstArray[count];
		count++;
		}

	for( int count = 0; count <= 6; count++){
		if( secondArray[count] > secondLargestNumber)
			secondLargestNumber = secondArray[count];
				}

	System.out.println(firstLargestNumber);
	System.out.print(secondLargestNumber);

}}