public class Addends{
	public int[] findAddends(int[] numbers, int target){
		int[] answer = new int[2];
		for( int number : numbers ){
			for( int index = 0; index < numbers.length; index++){
				int testNumber = numbers[index];
				int result = number + testNumber;
				if( result == target){
					answer = new int[]{number, testNumber};
					break;}
							}
		}
		return answer;
	}
}