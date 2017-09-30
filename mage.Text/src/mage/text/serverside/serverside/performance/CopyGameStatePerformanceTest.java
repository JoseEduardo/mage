package mage.text.serverside.serverside.performance;

import mage.game.GameException;
import mage.text.AI.basic.CostModificationTest;
import org.junit.Ignore;

/**
 * Test for copying game state.
 *
 * @ayratn
 */
@Ignore
public class CopyGameStatePerformanceTest {
    public static void main(String[] args) throws GameException {
        CostModificationTest.init();

        CostModificationTest instance = new CostModificationTest();
        instance.testFluctuator();



    }
}
