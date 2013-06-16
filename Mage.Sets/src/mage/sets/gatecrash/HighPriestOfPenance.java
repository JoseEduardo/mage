/*
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
package mage.sets.gatecrash;

import java.util.UUID;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.MageInt;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.DestroyTargetEffect;
import mage.cards.CardImpl;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.target.common.TargetNonlandPermanent;

/**
 *
 * @author Plopman
 */
public class HighPriestOfPenance extends CardImpl<HighPriestOfPenance> {

    public HighPriestOfPenance(UUID ownerId) {
        super(ownerId, 171, "High Priest of Penance", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{W}{B}");
        this.expansionSetCode = "GTC";
        this.subtype.add("Human");
        this.subtype.add("Cleric");

        this.color.setWhite(true);
        this.color.setBlack(true);
        
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        //Whenever High Priest of Penance is dealt damage, you may destroy target nonland permanent.
        this.addAbility(new HighPriestOfPenanceTriggeredAbility());
    }

    public HighPriestOfPenance(final HighPriestOfPenance card) {
        super(card);
    }

    @Override
    public HighPriestOfPenance copy() {
        return new HighPriestOfPenance(this);
    }
}

class HighPriestOfPenanceTriggeredAbility extends TriggeredAbilityImpl<HighPriestOfPenanceTriggeredAbility> {


    public HighPriestOfPenanceTriggeredAbility() {
        super(Zone.BATTLEFIELD, new DestroyTargetEffect(), true);
        this.addTarget(new TargetNonlandPermanent());
    }

    public HighPriestOfPenanceTriggeredAbility(final HighPriestOfPenanceTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public HighPriestOfPenanceTriggeredAbility copy() {
        return new HighPriestOfPenanceTriggeredAbility(this);
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (event.getType() == GameEvent.EventType.DAMAGED_CREATURE) {
            if (event.getTargetId().equals(this.sourceId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever {this} is dealt damage, " + super.getRule();
    }

}
