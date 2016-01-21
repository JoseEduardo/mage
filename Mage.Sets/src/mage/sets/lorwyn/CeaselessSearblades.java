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
package mage.sets.lorwyn;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.MageInt;
import mage.cards.CardImpl;

import java.util.UUID;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.cards.Card;
import mage.constants.Duration;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.game.Game;
import mage.game.events.GameEvent;

/**
 *
 * @author North
 */
public class CeaselessSearblades extends CardImpl {
   
    public CeaselessSearblades(UUID ownerId) {
        super(ownerId, 158, "Ceaseless Searblades", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{3}{R}");
        this.expansionSetCode = "LRW";
        this.subtype.add("Elemental");
        this.subtype.add("Warrior");

        this.power = new MageInt(2);
        this.toughness = new MageInt(4);

        // Whenever you activate an ability of an Elemental, Ceaseless Searblades gets +1/+0 until end of turn.
        this.addAbility(new CeaselessSearbladesTriggeredAbility());
        
    }
    
    public CeaselessSearblades(final CeaselessSearblades card) {
        super(card);
    }

    @Override
    public CeaselessSearblades copy() {
        return new CeaselessSearblades(this);
    }
}

class CeaselessSearbladesTriggeredAbility extends TriggeredAbilityImpl {

    private static final FilterCard filter = new FilterCard("an Elemental");

    static {
        filter.add(new SubtypePredicate("Elemental"));
    }

    CeaselessSearbladesTriggeredAbility() {
        super(Zone.BATTLEFIELD, new BoostSourceEffect(1, 0, Duration.EndOfTurn), false);
    }

    CeaselessSearbladesTriggeredAbility(final CeaselessSearbladesTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public CeaselessSearbladesTriggeredAbility copy() {
        return new CeaselessSearbladesTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.ACTIVATED_ABILITY;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        Card source = game.getPermanentOrLKIBattlefield(event.getSourceId());
        if (event.getPlayerId().equals(getControllerId())
            && source != null
            && filter.match(source, game)) {
            return true;
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever you activate an ability of an Elemental, Ceaseless Searblades gets +1/+0 until end of turn.";
    }
}
