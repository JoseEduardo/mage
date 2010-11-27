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

package mage.sets.magic2010;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.common.DrawCardTargetEffect;
import mage.cards.CardImpl;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.GameEvent.EventType;
import mage.target.TargetPlayer;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class HowlingMine extends CardImpl<HowlingMine> {

	public HowlingMine(UUID ownerId) {
		super(ownerId, 212, "Howling Mine", Rarity.RARE, new CardType[]{CardType.ARTIFACT}, "{2}");
		this.expansionSetCode = "M10";
		this.addAbility(new HowlingMineAbility());
	}

	public HowlingMine(final HowlingMine card) {
		super(card);
	}

	@Override
	public HowlingMine copy() {
		return new HowlingMine(this);
	}

	@Override
	public String getArt() {
		return "102959_typ_reg_sty_010.jpg";
	}

}

class HowlingMineAbility extends TriggeredAbilityImpl<HowlingMineAbility> {

	public HowlingMineAbility() {
		super(Zone.BATTLEFIELD, new DrawCardTargetEffect(1));
	}

	public HowlingMineAbility(final HowlingMineAbility ability) {
		super(ability);
	}

	@Override
	public HowlingMineAbility copy() {
		return new HowlingMineAbility(this);
	}

	@Override
	public boolean checkTrigger(GameEvent event, Game game) {
		if (event.getType() == EventType.DRAW_STEP_PRE) {
			this.addTarget(new TargetPlayer());
			this.targets.get(0).add(event.getPlayerId(), game);
			trigger(game, this.controllerId);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkInterveningIfClause(Game game) {
		return !game.getPermanent(this.sourceId).isTapped();
	}

	@Override
	public String getRule() {
		return "At the beginning of each player's draw step, if {this} is untapped, that player draws an additional card.";
	}

}
