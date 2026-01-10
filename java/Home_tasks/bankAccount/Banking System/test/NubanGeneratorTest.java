import NubanGenerator.NubanGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NubanGeneratorTest {

    @Test
    public void NubanNumberExistsTest() {
        NubanGenerator nuban = new NubanGenerator();
        //nuban.GenerateNumber();
        assertEquals(14,nuban.GenerateNumber(14));


    }
}
