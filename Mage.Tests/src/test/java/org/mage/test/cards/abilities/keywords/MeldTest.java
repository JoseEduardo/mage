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
package org.mage.test.cards.abilities.keywords;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 *
 * @author LevelX2
 */
public class MeldTest extends CardTestPlayerBase {

    @Test
    public void testMeldAndRestrict() {
        addCard(Zone.BATTLEFIELD, playerA, "Plains", 7);
        // When you cast Bruna, the Fading Light, you may return target Angel or Human creature card from your graveyard to the battlefield.
        // Flying, Vigilance
        // <i>(Melds with Gisela, the Broken Blade.)</i>
        addCard(Zone.HAND, playerA, "Bruna, the Fading Light"); // {5}{W}{W}
        // Flying, First strike, Lifelink
        // At the beginning of your end step, if you both own and control Gisela, the Broken Blade and a
        // creature named Bruna, the Fading Light, exile them, then meld them into Brisela, Voice of Nightmares.
        addCard(Zone.HAND, playerA, "Gisela, the Broken Blade"); // {2}{W}{W}
        // Brisela, Voice of Nightmares
        // Flying, First strike, Vigilance, Lifelink
        // Your opponents can't cast spells with converted mana cost 3 or less.

        addCard(Zone.BATTLEFIELD, playerB, "Plains", 2);
        addCard(Zone.HAND, playerB, "Silvercoat Lion", 2);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Bruna, the Fading Light");
        castSpell(2, PhaseStep.PRECOMBAT_MAIN, playerB, "Silvercoat Lion");
        castSpell(3, PhaseStep.PRECOMBAT_MAIN, playerA, "Gisela, the Broken Blade");
        castSpell(4, PhaseStep.PRECOMBAT_MAIN, playerB, "Silvercoat Lion");

        setStopAt(4, PhaseStep.BEGIN_COMBAT);
        execute();

        assertPermanentCount(playerA, "Brisela, Voice of Nightmares", 1);
        assertPermanentCount(playerA, "Bruna, the Fading Light", 0);
        assertPermanentCount(playerA, "Gisela, the Broken Blade", 0);

        assertPermanentCount(playerB, "Silvercoat Lion", 1);
        assertHandCount(playerB, "Silvercoat Lion", 1);

    }

    /**
     * brisela is bugged she is still "active" when dead
     */
    @Test
    public void testMeldAndStopRestrictIfMeldCreatureLeftBattlefield() {
        addCard(Zone.BATTLEFIELD, playerA, "Plains", 7);
        // When you cast Bruna, the Fading Light, you may return target Angel or Human creature card from your graveyard to the battlefield.
        // Flying, Vigilance
        // <i>(Melds with Gisela, the Broken Blade.)</i>
        addCard(Zone.HAND, playerA, "Bruna, the Fading Light"); // {5}{W}{W}
        // Flying, First strike, Lifelink
        // At the beginning of your end step, if you both own and control Gisela, the Broken Blade and a
        // creature named Bruna, the Fading Light, exile them, then meld them into Brisela, Voice of Nightmares.
        addCard(Zone.HAND, playerA, "Gisela, the Broken Blade"); // {2}{W}{W}
        // Brisela, Voice of Nightmares  9/10
        // Flying, First strike, Vigilance, Lifelink
        // Your opponents can't cast spells with converted mana cost 3 or less.

        addCard(Zone.BATTLEFIELD, playerB, "Plains", 4);
        addCard(Zone.BATTLEFIELD, playerB, "Island", 2);
        addCard(Zone.HAND, playerB, "Silvercoat Lion", 2);
        // Exile target creature. You draw cards equal to that creature's power.
        // At the beginning of your next upkeep, return that card to the battlefield under its owner's control.
        // If you do, discard cards equal to that creature's toughness.
        addCard(Zone.HAND, playerB, "Vanish into Memory", 1); // Instant {2}{W}{U}

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Bruna, the Fading Light");
        castSpell(2, PhaseStep.PRECOMBAT_MAIN, playerB, "Silvercoat Lion");
        castSpell(3, PhaseStep.PRECOMBAT_MAIN, playerA, "Gisela, the Broken Blade");
        castSpell(4, PhaseStep.PRECOMBAT_MAIN, playerB, "Vanish into Memory", "Brisela, Voice of Nightmares");
        castSpell(4, PhaseStep.PRECOMBAT_MAIN, playerB, "Silvercoat Lion");

        setStopAt(4, PhaseStep.BEGIN_COMBAT);
        execute();

        assertExileCount("Bruna, the Fading Light", 1);
        assertExileCount("Gisela, the Broken Blade", 1);
        assertPermanentCount(playerA, "Brisela, Voice of Nightmares", 0);

        assertGraveyardCount(playerB, "Vanish into Memory", 1);
        assertPermanentCount(playerB, "Silvercoat Lion", 2);
        assertHandCount(playerB, 2 + 9);

    }
}
