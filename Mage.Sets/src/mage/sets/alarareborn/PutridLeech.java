/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.sets.alarareborn;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Duration;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.MageInt;
import mage.abilities.common.ActivateOncePerTurnActivatedAbility;
import mage.abilities.costs.common.PayLifeCost;
import mage.abilities.effects.common.BoostSourceEffect;
import mage.cards.CardImpl;


/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class PutridLeech extends CardImpl<PutridLeech> {

	public PutridLeech(UUID ownerId) {
		super(ownerId, 95, "Putrid Leech", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{B}{G}");
		this.expansionSetCode = "ARB";
		this.color.setBlack(true);
		this.color.setGreen(true);
		this.subtype.add("Zombie");
		this.subtype.add("Leech");
		this.power = new MageInt(2);
		this.toughness = new MageInt(2);
		this.addAbility(new ActivateOncePerTurnActivatedAbility(Zone.BATTLEFIELD, new BoostSourceEffect(2, 2, Duration.EndOfTurn), new PayLifeCost(2)));
	}

	public PutridLeech(final PutridLeech card) {
		super(card);
	}

	@Override
	public PutridLeech copy() {
		return new PutridLeech(this);
	}

	@Override
	public String getArt() {
		return "120997_typ_reg_sty_010.jpg";
	}
}
