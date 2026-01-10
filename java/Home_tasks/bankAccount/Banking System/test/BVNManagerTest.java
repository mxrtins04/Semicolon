import BVNManager.BVNManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BVNManagerTest {

    @Test
    public void BVNManagerTest() {
        BVNManager bvn = new BVNManager();
        assertEquals(14,bvn.generateBvn(14));

    }
}
