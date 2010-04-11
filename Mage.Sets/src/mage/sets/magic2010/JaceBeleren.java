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
import mage.MageInt;
import mage.abilities.LoyaltyAbility;
import mage.abilities.effects.common.DrawCardAllEffect;
import mage.abilities.effects.common.DrawCardTargetEffect;
import mage.abilities.effects.common.PutLibraryIntoGraveTargetEffect;
import mage.cards.CardImpl;
import mage.sets.Magic2010;
import mage.target.TargetPlayer;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class JaceBeleren extends CardImpl {

	public JaceBeleren(UUID ownerId) {
		super(ownerId, "Jace Beleren", new CardType[]{CardType.PLANESWALKER}, "{1}{U}{U}");
		this.expansionSetId = Magic2010.getInstance().getId();
		this.subtype.add("Jace");
		this.color.setBlue(true);
		this.art = "105537_typ_reg_sty_010.jpg";
		this.loyalty = new MageInt(3);

		this.addAbility(new LoyaltyAbility(new DrawCardAllEffect(1), 2));

		LoyaltyAbility ability1 = new LoyaltyAbility(new DrawCardTargetEffect(1), -1);
		ability1.addTarget(new TargetPlayer());
		this.addAbility(ability1);

		LoyaltyAbility ability2 = new LoyaltyAbility(new PutLibraryIntoGraveTargetEffect(20), -10);
		ability2.addTarget(new TargetPlayer());
		this.addAbility(ability2);

	}

}
