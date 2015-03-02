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
package mage.sets.khansoftarkir;

import java.util.UUID;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.UntapAllControllerEffect;
import mage.abilities.effects.common.continuous.GainAbilityControlledEffect;
import mage.abilities.keyword.DoubleStrikeAbility;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Rarity;
import mage.filter.common.FilterCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public class FlyingCraneTechnique extends CardImpl {

    public FlyingCraneTechnique(UUID ownerId) {
        super(ownerId, 176, "Flying Crane Technique", Rarity.RARE, new CardType[]{CardType.INSTANT}, "{3}{U}{R}{W}");
        this.expansionSetCode = "KTK";

        this.color.setRed(true);
        this.color.setBlue(true);
        this.color.setWhite(true);

        // Untap all creatures you control.  They gain flying and double strike until end of turn.
        FilterCreaturePermanent filter = new FilterCreaturePermanent("creatures");
        this.getSpellAbility().addEffect(new UntapAllControllerEffect(filter));
        Effect effect = new GainAbilityControlledEffect(FlyingAbility.getInstance(), Duration.EndOfTurn, filter);
        effect.setText("They gain flying");
        this.getSpellAbility().addEffect(effect);
        effect = new GainAbilityControlledEffect(DoubleStrikeAbility.getInstance(), Duration.EndOfTurn, filter);
        effect.setText("and double strike until end of turn");
        this.getSpellAbility().addEffect(effect);
    }

    public FlyingCraneTechnique(final FlyingCraneTechnique card) {
        super(card);
    }

    @Override
    public FlyingCraneTechnique copy() {
        return new FlyingCraneTechnique(this);
    }
}
