package util.generator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ReferenceGenerator {
    private static final Random random = new Random();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static String generateTransactionReference() {
        String timestamp = LocalDateTime.now().format(formatter);
        String randomPart = String.format("%06d", random.nextInt(1000000));
        return "NIP" + timestamp + randomPart;
    }
}