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
package mage.sets.guildpact;

import java.util.UUID;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DamageMultiEffect;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.target.common.TargetCreatureOrPlayerAmount;

/**
 *
 * @author jonubuu
 */
public class Electrolyze extends CardImpl {

    public Electrolyze(UUID ownerId) {
        super(ownerId, 111, "Electrolyze", Rarity.UNCOMMON, new CardType[]{CardType.INSTANT}, "{1}{U}{R}");
        this.expansionSetCode = "GPT";


        // Electrolyze deals 2 damage divided as you choose among one or two target creatures and/or players.
        Effect effect = new DamageMultiEffect(2);
        effect.setText("{source} deals 2 damage divided as you choose among one or two target creatures and/or players");
        this.getSpellAbility().addEffect(effect);
        this.getSpellAbility().addTarget(new TargetCreatureOrPlayerAmount(2));
        // Draw a card.
        this.getSpellAbility().addEffect(new DrawCardSourceControllerEffect(1));
    }

    public Electrolyze(final Electrolyze card) {
        super(card);
    }

    @Override
    public Electrolyze copy() {
        return new Electrolyze(this);
    }
}
