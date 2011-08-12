/*
 *  Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
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
package mage.sets.mirrodinbesieged;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Outcome;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.cards.CardImpl;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.GameEvent.EventType;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class MelirasKeepers extends CardImpl<MelirasKeepers> {

	public MelirasKeepers(UUID ownerId) {
		super(ownerId, 83, "Melira's Keepers", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{4}{G}");
		this.expansionSetCode = "MBS";
		this.subtype.add("Human");
		this.subtype.add("Warrior");
		this.color.setGreen(true);
		this.power = new MageInt(4);
		this.toughness = new MageInt(4);

        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new MelirasKeepersEffect()));
	}

	public MelirasKeepers(final MelirasKeepers card) {
		super(card);
	}

	@Override
	public MelirasKeepers copy() {
		return new MelirasKeepers(this);
	}

}

class MelirasKeepersEffect extends ReplacementEffectImpl<MelirasKeepersEffect> {

    public MelirasKeepersEffect() {
        super(Duration.WhileOnBattlefield, Outcome.PreventDamage);
        staticText = "{this} can't have counters placed on it";
    }
    
    public MelirasKeepersEffect(final MelirasKeepersEffect effect) {
        super(effect);
    }
    
    @Override
    public boolean apply(Game game, Ability source) {
        return true;
    }

    @Override
    public MelirasKeepersEffect copy() {
        return new MelirasKeepersEffect(this);
    }

    @Override
    public boolean replaceEvent(GameEvent event, Ability source, Game game) {
        return true;
    }

    @Override
    public boolean applies(GameEvent event, Ability source, Game game) {
        if (event.getType() == EventType.ADD_COUNTER && event.getTargetId().equals(source.getSourceId())) {
            return true;
        }
        return false;
    }
    
}
