import java.util.ArrayList;
public class CCValidatorFunctions {

    public static boolean isValidLength(String cardNumber) {
        int length = cardNumber.length();
        if( length < 13 || length > 19) 
            return false;
        
        return true;
    }

    public static String determineCardType(String cardNumber) {
        if (cardNumber.startsWith("4"))
            return "Visa";

        if (cardNumber.startsWith("5"))
            return "MasterCard";

        if (cardNumber.startsWith("34"))
            return "American Express";
        if (cardNumber.startsWith("6"))
            return "Discover Cards";
        return "Invalid card type";
    }

    private static char[] convertCardNumberToArray(String cardNumber) {
        char[] digits = cardNumber.toCharArray();
        return digits;
    }

    private static int[] convertAllCharactersInArrayToIntegers(char[] digits) {
        int[] intDigits = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            intDigits[i] = Character.getNumericValue(digits[i]);
        }
        return intDigits;
    }

    public static ArrayList<Integer> pickEachSecondDigitFromRightToLeft(String cardNumber) {
        ArrayList<Integer> secondDigits = new ArrayList<>();
        char[] digits = convertCardNumberToArray(cardNumber);
        int[] intDigits = convertAllCharactersInArrayToIntegers(digits);
        int lastIndex = intDigits.length - 1;
        for (int index = lastIndex - 1; index >= 0; index -= 2) {
            int digit = intDigits[index];
            secondDigits.add(digit);
        }

        return secondDigits;
    }

    private static int sumOfArrayListElements(ArrayList<Integer> numbers){
        int sum = 0;
        for (int index = 0; index < numbers.size(); index++){
            sum += numbers.get(index);
        }
        return sum;
    }
    public static ArrayList<Integer> doubleAllSecondDigits(ArrayList<Integer> secondDigits){
        ArrayList<Integer> doubledDigits = new ArrayList<>();
        for (int index = 0; index < secondDigits.size(); index++){
            int doubleDigit = secondDigits.get(index) * 2;
        
            if (doubleDigit > 9){
                int firstDigit = doubleDigit / 10;
                int secondDigit = doubleDigit % 10;
                doubledDigits.add((firstDigit + secondDigit));
            }
            else
                doubledDigits.add(doubleDigit);
         }
        return doubledDigits;
        }

    public static int getTotalSum(String cardNumber){
        ArrayList<Integer> secondDigits = pickEachSecondDigitFromRightToLeft(cardNumber);
        ArrayList<Integer> doubledDigits = doubleAllSecondDigits(secondDigits);
        int sumOfDoubledDigits = sumOfArrayListElements(doubledDigits);
        int sumOfSecondDigits = sumOfArrayListElements(secondDigits);
        int totalSum = sumOfDoubledDigits + sumOfSecondDigits;
        return totalSum;
    }
}   