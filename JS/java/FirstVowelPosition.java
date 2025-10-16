public class FirstVowelPosition{
	public static void main(String [] args){
		String test = "maRtINs";
		String word = test.toLowerCase();
		char [] vowels = {'a', 'e', 'i', 'o', 'u'};
	
	for(int count = 0; count < word.length(); count++){
		for( int vowel_check = 0; vowel_check < vowels.length; vowel_check++){
			if( word.charAt(count) == vowels[vowel_check]){
				System.out.printf("The first vowel is at index %d", count);
				break;}

	}

		}

	
	}
}