package util.validation;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^(\\+234|0)[7-9][0-1]\\d{8}$");

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidNigerianPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidBVN(String bvn) {
        return bvn != null && bvn.matches("\\d{11}");
    }

    public static boolean isValidNUBAN(String accountNumber) {
        return accountNumber != null && accountNumber.matches("\\d{10}");
    }

    public static boolean isValidBankCode(String code) {
        return code != null && code.matches("\\d{3}");
    }

    public static boolean isAdult(LocalDate dateOfBirth) {
        if (dateOfBirth == null) return false;
        LocalDate eighteenYearsAgo = LocalDate.now().minusYears(18);
        return dateOfBirth.isBefore(eighteenYearsAgo) ||
                dateOfBirth.isEqual(eighteenYearsAgo);
    }

    public static boolean isPositiveAmount(java.math.BigDecimal amount) {
        return amount != null && amount.compareTo(java.math.BigDecimal.ZERO) > 0;
    }
}