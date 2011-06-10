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

package mage.abilities.effects.common.continious;

import mage.Constants.Duration;
import mage.Constants.Layer;
import mage.Constants.Outcome;
import mage.Constants.SubLayer;
import mage.abilities.Ability;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.effects.ContinuousEffectImpl;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author BetaSteward_at_googlemail.com, North
 */
public class SetPowerToughnessSourceEffect extends ContinuousEffectImpl<SetPowerToughnessSourceEffect> {

	private DynamicValue amount;

    public SetPowerToughnessSourceEffect(DynamicValue amount, Duration duration) {
        super(duration, Layer.PTChangingEffects_7, SubLayer.SetPT_7b, Outcome.BoostCreature);
        this.amount = amount;
    }

	public SetPowerToughnessSourceEffect(final SetPowerToughnessSourceEffect effect) {
		super(effect);
		this.amount = effect.amount;
	}

	@Override
	public SetPowerToughnessSourceEffect copy() {
		return new SetPowerToughnessSourceEffect(this);
	}

	@Override
	public boolean apply(Game game, Ability source) {
		Permanent target = game.getPermanent(source.getSourceId());
		if (target != null) {
            int value = amount.calculate(game, source);
			target.getPower().setValue(value);
			target.getToughness().setValue(value);
			return true;
		}
		return false;
	}

	@Override
	public String getDynamicText(Ability source) {
		StringBuilder sb = new StringBuilder();
		sb.append("{this}'s power and toughness are each equal to the number of ");
        sb.append(amount.getMessage());
		return sb.toString();
	}
}
