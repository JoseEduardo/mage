package org.mage.test.cards.single.roe;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import mage.game.permanent.Permanent;
import org.junit.Assert;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 *
 * @author magenoxx_at_gmail.com
 */
public class WorldAtWarTest extends CardTestPlayerBase {

    /**
     * Tests creatures attack twice
     */
    @Test
    public void testCard() {
        addCard(Zone.BATTLEFIELD, playerA, "Mountain", 5);
        addCard(Zone.BATTLEFIELD, playerA, "Fervor");
        addCard(Zone.HAND, playerA, "World at War");
        addCard(Zone.BATTLEFIELD, playerA, "Elite Vanguard");
        addCard(Zone.BATTLEFIELD, playerA, "Warclamp Mastiff");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "World at War");

        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Warclamp Mastiff");
        attack(1, playerA, "Warclamp Mastiff");

        setStopAt(1, PhaseStep.END_TURN);
        execute();
        
        assertLife(playerB, 14);
        Permanent eliteVanguard = getPermanent("Elite Vanguard", playerA);
        Assert.assertTrue(eliteVanguard.isTapped());
    }

    /**
     * Tests creatures attack twice on each turn (Rebound)
     */
    @Test
    public void testCardWithRebound() {
        addCard(Zone.BATTLEFIELD, playerA, "Mountain", 5);
        addCard(Zone.BATTLEFIELD, playerA, "Fervor");
        addCard(Zone.HAND, playerA, "World at War");
        addCard(Zone.BATTLEFIELD, playerA, "Elite Vanguard");
        addCard(Zone.BATTLEFIELD, playerA, "Warclamp Mastiff");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "World at War");

        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Warclamp Mastiff");
        attack(1, playerA, "Warclamp Mastiff");

        attack(3, playerA, "Elite Vanguard");
        attack(3, playerA, "Elite Vanguard");
        attack(3, playerA, "Warclamp Mastiff");
        attack(3, playerA, "Warclamp Mastiff");

        setStopAt(3, PhaseStep.END_TURN);
        execute();

        assertLife(playerB, 8);
        Permanent eliteVanguard = getPermanent("Elite Vanguard", playerA);
        Assert.assertTrue(eliteVanguard.isTapped());
    }

    /**
     * Tests creatures attack thrice
     */
    @Test
    public void testDoubleCast() {
        addCard(Zone.BATTLEFIELD, playerA, "Mountain", 10);
        addCard(Zone.BATTLEFIELD, playerA, "Fervor");
        addCard(Zone.HAND, playerA, "World at War", 2);
        addCard(Zone.BATTLEFIELD, playerA, "Elite Vanguard");
        addCard(Zone.BATTLEFIELD, playerA, "Warclamp Mastiff");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "World at War");
        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "World at War");

        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Elite Vanguard");
        attack(1, playerA, "Warclamp Mastiff");
        attack(1, playerA, "Warclamp Mastiff");
        attack(1, playerA, "Warclamp Mastiff");

        setStopAt(1, PhaseStep.END_TURN);
        execute();

        assertLife(playerB, 11);
        Permanent eliteVanguard = getPermanent("Elite Vanguard", playerA);
        Assert.assertTrue(eliteVanguard.isTapped());
    }
}
