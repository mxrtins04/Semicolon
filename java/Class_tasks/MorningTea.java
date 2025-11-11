public class MorningTea{
	public char findNonRepetitiveCharacter(String word){
		char firstChar = ' ';
		char check = ' ';
		char nonRepeatingChar = ' ';
		
		for( int index = 0; index < word.length(); index++){
			firstChar = word.charAt(index);
			int count = 0;
		for( int index2 = 0; index2 < word.length(); index2++ ){
			check = word.charAt(index2);
			if (firstChar == check)
				count++;
				//System.out.print(count);
			
		}
			
			if( count == 1)
			

			return firstChar;
		}
		
		
		return 'p';
	}
}