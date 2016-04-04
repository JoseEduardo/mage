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
package org.mage.test.cards.copy;

import mage.abilities.keyword.FlyingAbility;
import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

/**
 *
 * @author LevelX2
 */
public class CopySpellTest extends CardTestPlayerBase {

    @Test
    public void copyChainOfVapor() {
        // Return target nonland permanent to its owner's hand. Then that permanent's controller may sacrifice a land. If the player does, he or she may copy this spell and may choose a new target for that copy.
        addCard(Zone.HAND, playerA, "Chain of Vapor", 1);
        addCard(Zone.BATTLEFIELD, playerA, "Island", 1);

        addCard(Zone.BATTLEFIELD, playerA, "Silvercoat Lion", 1);

        addCard(Zone.BATTLEFIELD, playerB, "Pillarfield Ox", 1);
        addCard(Zone.BATTLEFIELD, playerB, "Island", 1);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Chain of Vapor", "Pillarfield Ox");
        setChoice(playerB, "Yes");
        addTarget(playerB, "Silvercoat Lion");

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();

        assertGraveyardCount(playerB, "Island", 1);
        assertHandCount(playerB, "Pillarfield Ox", 1);
        assertHandCount(playerA, "Silvercoat Lion", 1);
    }

    @Test
    public void ZadaHedronGrinderBoost() {
        // Target creature gets +3/+3 and gains flying until end of turn.
        addCard(Zone.HAND, playerA, "Angelic Blessing", 1); // {2}{W}
        addCard(Zone.BATTLEFIELD, playerA, "Plains", 3);

        // Whenever you cast an instant or sorcery spell that targets only Zada, Hedron Grinder, copy that spell for each other creature you control that the spell could target. Each copy targets a different one of those creatures.
        addCard(Zone.BATTLEFIELD, playerA, "Zada, Hedron Grinder", 1);
        addCard(Zone.BATTLEFIELD, playerA, "Pillarfield Ox", 1);

        addCard(Zone.BATTLEFIELD, playerB, "Silvercoat Lion", 1);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Angelic Blessing", "Zada, Hedron Grinder");

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();

        assertGraveyardCount(playerA, "Angelic Blessing", 1);
        assertPowerToughness(playerA, "Pillarfield Ox", 5, 7);
        assertAbility(playerA, "Pillarfield Ox", FlyingAbility.getInstance(), true);
        assertPowerToughness(playerA, "Zada, Hedron Grinder", 6, 6);
        assertAbility(playerA, "Zada, Hedron Grinder", FlyingAbility.getInstance(), true);

        assertPowerToughness(playerB, "Silvercoat Lion", 2, 2);
        assertAbility(playerB, "Silvercoat Lion", FlyingAbility.getInstance(), false);
    }

    @Test
    public void ZadaHedronGrinderBoostWithCharm() {
        // Choose two -
        // • Counter target spell.
        // • Return target permanent to its owner's hand.
        // • Tap all creatures your opponents control.
        // • Draw a card.
        addCard(Zone.HAND, playerA, "Cryptic Command", 1); // {2}{U}{U}{U}
        addCard(Zone.BATTLEFIELD, playerA, "Island", 4);

        // Whenever you cast an instant or sorcery spell that targets only Zada, Hedron Grinder, copy that spell for each other creature you control that the spell could target. Each copy targets a different one of those creatures.
        addCard(Zone.BATTLEFIELD, playerA, "Zada, Hedron Grinder", 1);
        addCard(Zone.BATTLEFIELD, playerA, "Pillarfield Ox", 1);

        addCard(Zone.BATTLEFIELD, playerB, "Silvercoat Lion", 1);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Cryptic Command", "mode=2Zada, Hedron Grinder");
        setModeChoice(playerA, "2"); // Return target permanent to its owner's hand
        setModeChoice(playerA, "4"); // Draw a card

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();

        assertPowerToughness(playerB, "Silvercoat Lion", 2, 2);

        assertGraveyardCount(playerA, "Cryptic Command", 1);
        assertPermanentCount(playerA, "Zada, Hedron Grinder", 0);
        assertPermanentCount(playerA, "Pillarfield Ox", 0);
        assertHandCount(playerA, 4); // 2 draw + 2 creatures returned to hand
    }

    /**
     * Not to be a bother, but I posted earlier about how Zada, Hedron Grinder
     * 's interaction with splice is broken. I didn't get a response on whether
     * or not the problem was being looked at. Zada SHOULD copy spliced effects
     * (and currently doesn't) because spliced effects are put onto the spell
     * before it is cast and therefore before Zada's ability triggers, e.g.
     * Desperate Ritual spliced onto Into the Fray should generate 3 red mana
     * for every creature i control.
     *
     * 702.46a Splice is a static ability that functions while a card is in your
     * hand. “Splice onto [subtype] [cost]” means “You may reveal this card from
     * your hand as you cast a [subtype] spell. If you do, copy this card’s text
     * box onto that spell and pay [cost] as an additional cost to cast that
     * spell.” Paying a card’s splice cost follows the rules for paying
     * additional costs in rules 601.2b and 601.2e–g. 601.2b If the spell is
     * modal the player announces the mode choice (see rule 700.2). If the
     * player wishes to splice any cards onto the spell (see rule 702.46), he or
     * she reveals those cards in his or her hand. 706.10. To copy a spell,
     * activated ability, or triggered ability means to put a copy of it onto
     * the stack; a copy of a spell isn’t cast and a copy of an activated
     * ability isn’t activated. A copy of a spell or ability copies both the
     * characteristics of the spell or ability and all decisions made for it,
     * including modes, targets, the value of X, and additional or alternative
     * costs. (See rule 601, “Casting Spells.”)
     */
    @Test
    public void ZadaHedronGrinderAndSplicedSpell() {
        // Draw a card.
        // Splice onto Arcane {1}{U}
        addCard(Zone.HAND, playerA, "Evermind", 1); // no costs
        // Target creature attacks this turn if able.
        // Splice onto Arcane {R}
        addCard(Zone.HAND, playerA, "Into the Fray", 1); // Instant - Arcane - {U}
        addCard(Zone.BATTLEFIELD, playerA, "Mountain", 1);
        addCard(Zone.BATTLEFIELD, playerA, "Island", 2);

        // Whenever you cast an instant or sorcery spell that targets only Zada, Hedron Grinder,
        // copy that spell for each other creature you control that the spell could target.
        // Each copy targets a different one of those creatures.
        addCard(Zone.BATTLEFIELD, playerA, "Zada, Hedron Grinder", 1);
        addCard(Zone.BATTLEFIELD, playerA, "Pillarfield Ox", 1);

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Into the Fray", "Zada, Hedron Grinder");
        setChoice(playerA, "Yes");

        setStopAt(1, PhaseStep.BEGIN_COMBAT);
        execute();

        assertGraveyardCount(playerA, "Into the Fray", 1);
        assertHandCount(playerA, "Evermind", 1);
        assertHandCount(playerA, 3); // Evermind + 1 card from Evermind spliced on cast Into the fray and 1 from the copied spell with splice
    }
    
    /**
     * {4}{U} Enchantment (Enchant Player)
     * Whenever enchanted player casts an instant or sorcery spell, each other player may copy that spell 
     * and may choose new targets for the copy he or she controls.
     * 
     * Reported bug: "A player with Curse of Echoes attached to them played Bribery and the player who controlled the curse had control 
     * of all 3 copies. This seems to be the case for all spells."
     */
    @Test
    public void testCurseOfEchoes() {
        
        addCard(Zone.HAND, playerA, "Curse of Echoes");
        addCard(Zone.BATTLEFIELD, playerA, "Island", 5);
        addCard(Zone.HAND, playerB, "Lightning Bolt");
        addCard(Zone.BATTLEFIELD, playerB, "Mountain");
        
        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Curse of Echoes");
        addTarget(playerA, playerB);
        castSpell(2, PhaseStep.PRECOMBAT_MAIN, playerB, "Lightning Bolt");
        addTarget(playerB, playerA); // original target
        setChoice(playerA, "Yes");
        addTarget(playerA, playerB);
        
        setStopAt(2, PhaseStep.BEGIN_COMBAT);
        execute();
        
        assertGraveyardCount(playerB, "Lightning Bolt", 1);
        assertLife(playerA, 17); // still takes original spell's damage
        assertLife(playerB, 17); // copy redirected
    }

}
