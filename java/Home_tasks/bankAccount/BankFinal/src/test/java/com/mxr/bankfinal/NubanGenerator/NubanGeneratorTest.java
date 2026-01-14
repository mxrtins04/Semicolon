package com.mxr.bankfinal.NubanGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import com.mxr.bankfinal.util.NubanGenerator;

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
    @DisplayName("Should throw exception for invalid bank code")
    void shouldThrowExceptionForInvalidBankCode() {
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNuban(null));
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNuban(""));
    }

    @Test
    @DisplayName("Should throw exception for invalid serial number")
    void shouldThrowExceptionForInvalidSerialNumber() {
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNubanWithSerial("044", null));
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.generateNubanWithSerial("044", ""));
    }

    @Test
    @DisplayName("Should throw exception for invalid check digit input")
    void shouldThrowExceptionForInvalidCheckDigitInput() {
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> NubanGenerator.calculateCheckDigit(""));
    }


}
