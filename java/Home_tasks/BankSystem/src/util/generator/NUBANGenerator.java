package util.generator;

public class NUBANGenerator {

    private static final int[] MULTIPLIERS = {3, 7, 3, 3, 7, 3, 3, 7, 3, 3, 7, 3};

    public static String generateNUBAN(String bankCode, long serialNumber) {
        if (bankCode == null || bankCode.length() != 3) {
            throw new IllegalArgumentException("Bank code must be exactly 3 digits");
        }

        String serial = String.format("%09d", serialNumber);

        if (serial.length() > 9) {
            throw new IllegalArgumentException("Serial number exceeds 9 digits");
        }

        String accountBase = bankCode + serial;

        int checkDigit = calculateCheckDigit(accountBase);

        return serial + checkDigit;
    }

    private static int calculateCheckDigit(String accountBase) {
        if (accountBase.length() != 12) {
            throw new IllegalArgumentException("Account base must be 12 digits");
        }

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(accountBase.charAt(i));
            sum += digit * MULTIPLIERS[i];
        }

        int mod = sum % 10;

        int checkDigit = 10 - mod;


        if (checkDigit == 10) {
            checkDigit = 0;
        }

        return checkDigit;
    }


    public static boolean validateNUBAN(String bankCode, String accountNumber) {
        if (accountNumber == null || accountNumber.length() != 10) {
            return false;
        }

        if (bankCode == null || bankCode.length() != 3) {
            return false;
        }


        String serial = accountNumber.substring(0, 9);
        int providedCheckDigit = Character.getNumericValue(accountNumber.charAt(9));

        String accountBase = bankCode + serial;
        int calculatedCheckDigit = calculateCheckDigit(accountBase);


        return providedCheckDigit == calculatedCheckDigit;
    }
}