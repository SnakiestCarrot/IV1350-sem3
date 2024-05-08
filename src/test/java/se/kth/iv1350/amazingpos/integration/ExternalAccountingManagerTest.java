package se.kth.iv1350.amazingpos.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExternalAccountingManagerTest {
    private ExternalAccountingManager testAccountingManager;

    @BeforeEach
    public void setUp() {
        testAccountingManager = new ExternalAccountingManager();
    }

    @AfterEach
    public void tearDown() {
        testAccountingManager = null;
    }

    @Test
    public void testFundAddition() {
        double fundsBefore = testAccountingManager.getFunds();
        testAccountingManager.updateAccountingSystem(100.0);
        double fundsAfter = testAccountingManager.getFunds();

        assertTrue(fundsBefore == fundsAfter - 100.0, "The funds were not correctly updated");
    }
    // this test isnt relevant yet because we dont have input validation right now
    // but we might want it later so im keeping it for now
    // @Test
    // public void testFundSubtraction() {
    //     assertThrows(IllegalArgumentException.class, () -> {
    //         testAccountingManager.updateAccountingSystem(-100.0);
    //     }, "An IllegalArgumentException was not thrown on a negative input, though it should have.");
    //     }
}
