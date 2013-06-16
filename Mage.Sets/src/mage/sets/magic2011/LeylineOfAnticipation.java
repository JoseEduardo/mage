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

package mage.sets.magic2011;

import java.util.UUID;
import mage.constants.AsThoughEffectType;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.AsThoughEffectImpl;
import mage.abilities.keyword.LeylineAbility;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.game.Game;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class LeylineOfAnticipation extends CardImpl<LeylineOfAnticipation> {

    public LeylineOfAnticipation(UUID ownerId) {
        super(ownerId, 61, "Leyline of Anticipation", Rarity.RARE, new CardType[]{CardType.ENCHANTMENT}, "{2}{U}{U}");
        this.expansionSetCode = "M11";
        this.color.setBlue(true);
        this.addAbility(LeylineAbility.getInstance());
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new LeylineOfAnticipationEffect()));
    }

    public LeylineOfAnticipation(final LeylineOfAnticipation card) {
        super(card);
    }

    @Override
    public LeylineOfAnticipation copy() {
        return new LeylineOfAnticipation(this);
    }

}

class LeylineOfAnticipationEffect extends AsThoughEffectImpl<LeylineOfAnticipationEffect> {

    public LeylineOfAnticipationEffect() {
        super(AsThoughEffectType.CAST, Duration.WhileOnBattlefield, Outcome.Benefit);
        staticText = "You may cast nonland cards as though they had flash";
    }

    public LeylineOfAnticipationEffect(final LeylineOfAnticipationEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        return true;
    }

    @Override
    public LeylineOfAnticipationEffect copy() {
        return new LeylineOfAnticipationEffect(this);
    }

    @Override
    public boolean applies(UUID sourceId, Ability source, Game game) {
        Card card = game.getCard(sourceId);
        if (card != null) {
            if (!card.getCardType().contains(CardType.LAND) && card.getOwnerId().equals(source.getControllerId())) {
                return true;
            }
        }
        return false;
    }

}