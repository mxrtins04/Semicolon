import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class CCValidatorTest {
    CCValidatorFunctions function;

    @BeforeEach
    void setup() {
        function = new CCValidatorFunctions();
    }

    @Test
    void testIsValidLength() {
        assertTrue(function.isValidLength("4532015112830366"));
        assertFalse(function.isValidLength("123456789")); 
    }

    @Test
    void testThatDetermineCardTypeReturnsCorrectType() {
        assertEquals("Visa", function.determineCardType("4532015112830366"));
        assertEquals("MasterCard", function.determineCardType("5500005555554444"));
        assertEquals("American Express", function.determineCardType("340000000000009"));
        assertEquals("Invalid card type", function.determineCardType("1234567890123456"));
        assertEquals("Discover Cards", function.determineCardType("6011000990139424"));
    }

    @Test
    void testThatPickSecondDigitFromRightToLeftWorks() {
        ArrayList<Integer> expectedNumbers = new ArrayList<>(List.of(4, 4, 5));
        ArrayList<Integer> actualNumbers = function.pickEachSecondDigitFromRightToLeft("4504345");
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    void testThatDoubleAllSecondDigitsWorks(){
        ArrayList<Integer> secondDigits = new ArrayList<>(List.of(5, 4, 5));
        ArrayList<Integer> expectedNumbers = new ArrayList<>(List.of(1, 8, 1));
        ArrayList<Integer> actualNumbers = function.doubleAllSecondDigits(secondDigits);
        
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    void testThatTotalSumReturnsCorrectSum(){
        int expectedSum = 21;
        int actualSum = function.getTotalSum("4535");
        
        assertEquals(expectedSum, actualSum);
    }
}
