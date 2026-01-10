import CreditCardNumber.CreditCardNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditCardNumberTest {
    @Test
    public void CreditCardNumberTest() {
        CreditCardNumber card = new CreditCardNumber();
        assertEquals(14,card.getNumber(14));

    }
}
