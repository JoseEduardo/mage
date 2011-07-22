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

package mage.sets.alarareborn;

import java.util.UUID;

import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.game.Game;
import mage.players.Player;
import mage.target.TargetPlayer;

/**
 *
 * @author Loki
 */
public class IdentityCrisis extends CardImpl<IdentityCrisis> {

    public IdentityCrisis (UUID ownerId) {
        super(ownerId, 81, "Identity Crisis", Rarity.RARE, new CardType[]{CardType.SORCERY}, "{2}{W}{W}{B}{B}");
        this.expansionSetCode = "ARB";
		this.color.setWhite(true);
		this.color.setBlack(true);
        this.getSpellAbility().addEffect(new IdentityCrisisEffect());
        this.getSpellAbility().addTarget(new TargetPlayer());
    }

    public IdentityCrisis (final IdentityCrisis card) {
        super(card);
    }

    @Override
    public IdentityCrisis copy() {
        return new IdentityCrisis(this);
    }

}

class IdentityCrisisEffect extends OneShotEffect<IdentityCrisisEffect> {
    IdentityCrisisEffect() {
        super(Constants.Outcome.Exile);
        staticText = "Exile all cards from target player's hand and graveyard";
    }

    IdentityCrisisEffect(final IdentityCrisisEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getFirstTarget());
        if (player != null) {
            for (UUID cid : player.getHand().copy()) {
                Card c = game.getCard(cid);
                if (c != null) {
                    c.moveToExile(null, null, source.getId(), game);
                }
            }
            for (UUID cid : player.getGraveyard().copy()) {
                Card c = game.getCard(cid);
                if (c != null) {
                    c.moveToExile(null, null, source.getId(), game);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public IdentityCrisisEffect copy() {
        return new IdentityCrisisEffect(this);
    }

 }