/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package org.mage.test.cards.replacement;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 *
 * @author LevelX2
 */
public class DamageEffectsTest extends CardTestPlayerBase {

    /**
     * Just encountered another bug. With Wurmcoil Engine out and with a
     * Gratuitous Violence on the field, I only gained 6 life on blocking rather
     * than 12 life.
     */
    @Test
    public void testDamageIsDoubledWithLifelink() {
        // Landfall - Whenever a land enters the battlefield under your control, you may have target player lose 3 life.
        // If you do, put three +1/+1 counters on Ob Nixilis, the Fallen.
        addCard(Zone.BATTLEFIELD, playerB, "Ob Nixilis, the Fallen");
        addCard(Zone.HAND, playerB, "Mountain");

        // Deathtouch, lifelink
        // When Wurmcoil Engine dies, create a 3/3 colorless Wurm artifact creature token with deathtouch and a 3/3 colorless Wurm artifact creature token with lifelink.
        addCard(Zone.BATTLEFIELD, playerA, "Wurmcoil Engine");
        // If a creature you control would deal damage to a creature or player, it deals double that damage to that creature or player instead.
        addCard(Zone.BATTLEFIELD, playerA, "Gratuitous Violence");

        playLand(2, PhaseStep.PRECOMBAT_MAIN, playerB, "Mountain");
        setChoice(playerB, "Yes");
        addTarget(playerB, playerA);

        attack(2, playerB, "Ob Nixilis, the Fallen");
        block(2, playerA, "Wurmcoil Engine", "Ob Nixilis, the Fallen");

        setStopAt(2, PhaseStep.POSTCOMBAT_MAIN);
        execute();

        assertGraveyardCount(playerB, "Ob Nixilis, the Fallen", 1);

        assertGraveyardCount(playerA, "Wurmcoil Engine", 1);
        assertPermanentCount(playerA, "Wurm", 2);

        assertLife(playerB, 20);
        assertLife(playerA, 29); // -2 from Ob Nixilis + 12 from double damage with lifelink from Wurmcoil Engine

    }

    @Test
    public void testDamageToPlayer() {
        // Deathtouch, lifelink
        // When Wurmcoil Engine dies, create a 3/3 colorless Wurm artifact creature token with deathtouch and a 3/3 colorless Wurm artifact creature token with lifelink.
        addCard(Zone.BATTLEFIELD, playerA, "Wurmcoil Engine");
        // If a creature you control would deal damage to a creature or player, it deals double that damage to that creature or player instead.
        addCard(Zone.BATTLEFIELD, playerA, "Gratuitous Violence");

        attack(1, playerA, "Wurmcoil Engine");

        setStopAt(1, PhaseStep.POSTCOMBAT_MAIN);
        execute();

        assertPermanentCount(playerA, "Wurmcoil Engine", 1);

        assertLife(playerB, 8);
        assertLife(playerA, 32);

    }
}
