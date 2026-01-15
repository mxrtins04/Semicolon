package com.mxr.bankfinal.util;
import java.util.Random;

public class NubanGenerator {
    private static final int[] MULTIPLIERS = {3, 7, 3, 3, 7, 3, 3, 7, 3, 3, 7, 3, 3};
    private static final Random random = new Random();
    

    public static String generateNuban(String bankCode) {
        if (bankCode == null || bankCode.length() != 3) {
            throw new IllegalArgumentException("Bank code must be 3 digits");
        }
        
        String serial = generateSerialNumber();
        String nubanWithoutCheck = bankCode + serial;
        
        int checkDigit = calculateCheckDigit(nubanWithoutCheck);
        
        return nubanWithoutCheck + checkDigit;
    }
    
    private static String generateSerialNumber() {
        int serial = random.nextInt(999999999) + 1;
        return String.format("%09d", serial);
    }
    
    public static int calculateCheckDigit(String nubanWithoutCheck) {
        if (nubanWithoutCheck == null || nubanWithoutCheck.length() != 12) {
            throw new IllegalArgumentException("Input must be 12 digits");
        }
        
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(nubanWithoutCheck.charAt(i));
            sum += digit * MULTIPLIERS[i];
        }
        
        int remainder = sum % 10;
        int checkDigit = 10 - remainder;

        if (checkDigit == 10) checkDigit = 0;
        
        return checkDigit;
    }
    

    public static boolean validateNuban(String nuban) {
        if (nuban == null || nuban.length() != 13) {
            return false;
        }
        
        String nubanWithoutCheck = nuban.substring(0, 12);
        String checkDigitStr = nuban.substring(12);
        
        int calculatedCheckDigit = calculateCheckDigit(nubanWithoutCheck);
        int actualCheckDigit = Integer.parseInt(checkDigitStr);
        
        return calculatedCheckDigit == actualCheckDigit;
    }
    
    public static String extractBankCode(String nuban) {
        if (!validateNuban(nuban)) {
            throw new IllegalArgumentException("Invalid NUBAN number");
        }
        return nuban.substring(0, 3);
    }
    
    public static String extractSerialNumber(String nuban) {
        if (!validateNuban(nuban)) {
            throw new IllegalArgumentException("Invalid NUBAN number");
        }
        return nuban.substring(3, 12);
    }
    
    public static String generateNubanWithSerial(String bankCode, String serialNumber) {
        if (bankCode == null || bankCode.length() != 3) {
            throw new IllegalArgumentException("Bank code must be 3 digits");
        }
        
        String nubanWithoutCheck = bankCode + serialNumber;
        int checkDigit = calculateCheckDigit(nubanWithoutCheck);
        
        return nubanWithoutCheck + checkDigit;
    }
}
