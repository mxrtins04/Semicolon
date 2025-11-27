public class LCM{
	public int getLCM(int[]numbers){
		int divider = 2;
		int LCM = 1;
		int sumOfNumbers = 0;
		int lengthOfArray = numbers.length;
		int notDivisible = 0;
		

		while (sumOfNumbers != lengthOfArray){
		
		for (int index = 0; index < numbers.length; index++) {
			if (numbers[index] % divider == 0)
				numbers[index] /= divider;
			else
				notDivisible += 1;
			if( numbers[index] == 1 )
			sumOfNumbers += numbers[index];
			System.out.print(notDivisible);s
			
		}
			notDivisible = 0;
				
			if( notDivisible == lengthOfArray )
				divider++;
			else
				LCM *= divider;
			
		}
	return LCM;
	}

}