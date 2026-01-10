package util.validation;

import dto.request.TransferRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {
    private static final BigDecimal MIN_TRANSFER = new BigDecimal("100");
    private static final BigDecimal MAX_TRANSFER = new BigDecimal("10000000");

    public static List<String> validate(TransferRequest request) {
        List<String> errors = new ArrayList<>();

        if (!Validator.isValidNUBAN(request.getSourceAccountNumber())) {
            errors.add("Invalid source account number");
        }

        if (!Validator.isValidNUBAN(request.getDestinationAccountNumber())) {
            errors.add("Invalid destination account number");
        }

        if (!Validator.isValidBankCode(request.getDestinationBankCode())) {
            errors.add("Invalid destination bank code");
        }

        if (!Validator.isPositiveAmount(request.getAmount())) {
            errors.add("Amount must be greater than zero");
        } else {
            if (request.getAmount().compareTo(MIN_TRANSFER) < 0) {
                errors.add("Minimum transfer is ₦" + MIN_TRANSFER);
            }
            if (request.getAmount().compareTo(MAX_TRANSFER) > 0) {
                errors.add("Maximum transfer is ₦" + MAX_TRANSFER);
            }
        }

        if (!Validator.isNotEmpty(request.getNarration())) {
            errors.add("Narration is required");
        }

        return errors;
    }

    public static boolean isValid(TransferRequest request) {
        return validate(request).isEmpty();
    }
}
