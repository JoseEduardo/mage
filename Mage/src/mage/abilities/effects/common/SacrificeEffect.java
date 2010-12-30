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
package mage.abilities.effects.common;

import mage.Constants.Outcome;
import mage.Constants.TargetController;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.filter.common.FilterControlledPermanent;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.common.TargetControlledPermanent;

/**
 *
 * @author maurer.it_at_gmail.com
 */
public class SacrificeEffect extends OneShotEffect<SacrificeEffect>{

	private FilterControlledPermanent filter;
	private String preText;

	public SacrificeEffect ( FilterControlledPermanent filter, String preText ) {
		super(Outcome.Sacrifice);
		this.filter = filter;
		this.preText = preText;
	}

	public SacrificeEffect ( SacrificeEffect effect ) {
		super(effect.outcome);
		this.filter = effect.filter;
	}
	
	@Override
	public boolean apply(Game game, Ability source) {
		boolean legalTargetsExist = false;
		Player player = game.getPlayer(source.getTargets().getFirstTarget());
		int numTargets = Math.min(1, game.getBattlefield().countAll(filter, player.getId()));
		legalTargetsExist = numTargets > 0;
		filter.setTargetController(TargetController.YOU);
		TargetControlledPermanent target = new TargetControlledPermanent(numTargets, numTargets, filter, false);

		//A spell or ability could have removed the only legal target this player
		//had, if thats the case this ability should fizzle.
		if ( legalTargetsExist ) {
			while (!target.isChosen()) {
				player.choose(Outcome.Sacrifice, target, game);
			}

			Permanent permanent = game.getPermanent(target.getFirstTarget());

			if ( permanent != null ) {
				return permanent.sacrifice(source.getId(), game);
			}
		}
		return false;
	}

	@Override
	public SacrificeEffect copy() {
		return new SacrificeEffect(this);
	}

	@Override
	public String getText(Ability source) {
		StringBuilder sb = new StringBuilder();
		sb.append(preText)
		  .append(" sacrifices ")
		  .append(filter.getMessage());
		return sb.toString();
	}
}
