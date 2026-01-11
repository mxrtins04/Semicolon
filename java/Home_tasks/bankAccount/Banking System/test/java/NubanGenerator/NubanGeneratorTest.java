package java.NubanGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class NubanGeneratorTest {

    @Test
    @DisplayName("Should generate valid NUBAN for Access Bank")
    void shouldGenerateValidNubanForAccessBank() {
        String nuban = NubanGenerator.generateNuban("044");
        
        assertNotNull(nuban);
        assertEquals(13, nuban.length());
        assertTrue(nuban.matches("\\d{13}"));
        assertTrue(nuban.startsWith("044"));
        assertTrue(NubanGenerator.validateNuban(nuban));
    }

    @Test
    @DisplayName("Should generate valid NUBAN for GTB")
    void shouldGenerateValidNubanForGtb() {
        String nuban = NubanGenerator.generateNuban("058");
        
        assertNotNull(nuban);
        assertEquals(13, nuban.length());
        assertTrue(nuban.startsWith("058"));
        assertTrue(NubanGenerator.validateNuban(nuban));
    }

    @Test
    @DisplayName("Should calculate check digit correctly")
    void shouldCalculateCheckDigitCorrectly() {
        String nubanWithoutCheck = "044123456789";
        int checkDigit = NubanGenerator.calculateCheckDigit(nubanWithoutCheck);
        assertEquals(5, checkDigit);
    }

    @Test
    void shouldValidateNubanCorrectly() {
        String validNuban = NubanGenerator.generateNuban("044");
        assertTrue(NubanGenerator.validateNuban(validNuban));
        
        String invalidNuban = validNuban.substring(0, 12) + "9";
        assertFalse(NubanGenerator.validateNuban(invalidNuban));
        
        assertFalse(NubanGenerator.validateNuban(null));
        assertFalse(NubanGenerator.validateNuban(""));
        assertFalse(NubanGenerator.validateNuban("123"));
        assertFalse(NubanGenerator.validateNuban("1234567890123"));
        assertFalse(NubanGenerator.validateNuban("abcdefghijklm"));
    }

    @Test
    @DisplayName("Should extract bank code correctly")
    void shouldExtractBankCodeCorrectly() {
        String nuban = NubanGenerator.generateNuban("044");
        String extractedBankCode = NubanGenerator.extractBankCode(nuban);
        
        assertEquals("044", extractedBankCode);
    }

    @Test
    @DisplayName("Should extract serial number correctly")
    void shouldExtractSerialNumberCorrectly() {
        String nuban = NubanGenerator.generateNuban("044");
        String extractedSerial = NubanGenerator.extractSerialNumber(nuban);
        
        assertEquals(9, extractedSerial.length());
        assertTrue(extractedSerial.matches("\\d{9}"));
    }

    @Test
    @DisplayName("Should generate NUBAN with specific serial number")
    void shouldGenerateNubanWithSpecificSerialNumber() {
        String nuban = NubanGenerator.generateNubanWithSerial("044", "123456789");
        
        assertNotNull(nuban);
        assertEquals(13, nuban.length());
        assertTrue(nuban.startsWith("044123456789"));
        assertTrue(NubanGenerator.validateNuban(nuban));
    }

    @Test
    void shouldThrowExceptionForInvalidBankCode() {
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNuban(null));
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNuban(""));
    }

    @Test
    void shouldThrowExceptionForInvalidSerialNumber() {
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNubanWithSerial("044", null));
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNubanWithSerial("044", ""));
    }

    @Test
    void shouldThrowExceptionForInvalidCheckDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.calculateCheckDigit(""));
    }

    @Test
    void shouldGenerateUniqueNubans() {
        String nuban1 = NubanGenerator.generateNuban("044");
        String nuban2 = NubanGenerator.generateNuban("044");
        String nuban3 = NubanGenerator.generateNuban("044");
        
        assertNotEquals(nuban1, nuban2);
        assertNotEquals(nuban2, nuban3);
        assertNotEquals(nuban1, nuban3);
    }
}
