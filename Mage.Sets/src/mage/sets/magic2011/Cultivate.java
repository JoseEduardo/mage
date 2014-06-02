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

import java.util.List;
import java.util.UUID;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.filter.FilterCard;
import mage.filter.common.FilterBasicLandCard;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetCard;
import mage.target.common.TargetCardInLibrary;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class Cultivate extends CardImpl<Cultivate> {

    public Cultivate(UUID ownerId) {
        super(ownerId, 168, "Cultivate", Rarity.COMMON, new CardType[]{CardType.SORCERY}, "{2}{G}");
        this.expansionSetCode = "M11";
        this.color.setGreen(true);
        this.getSpellAbility().addEffect(new CultivateEffect());

    }

    public Cultivate(final Cultivate card) {
        super(card);
    }

    @Override
    public Cultivate copy() {
        return new Cultivate(this);
    }

}

class CultivateEffect extends OneShotEffect {

    protected static final FilterCard filter = new FilterCard("card to put on the battlefield tapped");

    public CultivateEffect() {
        super(Outcome.PutLandInPlay);
        staticText = "Search your library for up to two basic land cards, reveal those cards, and put one onto the battlefield tapped and the other into your hand. Then shuffle your library";
    }

    public CultivateEffect(final CultivateEffect effect) {
        super(effect);
    }

    @Override
    public CultivateEffect copy() {
        return new CultivateEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        TargetCardInLibrary target = new TargetCardInLibrary(0, 2, new FilterBasicLandCard());
        Player player = game.getPlayer(source.getControllerId());
        if (player.searchLibrary(target, game)) {
            if (target.getTargets().size() > 0) {
                Cards revealed = new CardsImpl();
                for (UUID cardId: (List<UUID>)target.getTargets()) {
                    Card card = player.getLibrary().getCard(cardId, game);
                    revealed.add(card);
                }
                player.revealCards("Cultivate", revealed, game);
                if (target.getTargets().size() == 2) {
                    TargetCard target2 = new TargetCard(Zone.PICK, filter);
                    target2.setRequired(true);
                    player.choose(Outcome.Benefit, revealed, target2, game);
                    Card card = revealed.get(target2.getFirstTarget(), game);
                    card.putOntoBattlefield(game, Zone.LIBRARY, source.getId(), source.getControllerId());
                    revealed.remove(card);
                    Permanent permanent = game.getPermanent(card.getId());
                    if (permanent != null)
                        permanent.setTapped(true);
                    card = revealed.getCards(game).iterator().next();
                    card.moveToZone(Zone.HAND, source.getId(), game, false);
                }
                else if (target.getTargets().size() == 1) {
                    Card card = revealed.getCards(game).iterator().next();
                    card.putOntoBattlefield(game, Zone.LIBRARY, source.getId(), source.getControllerId());
                    Permanent permanent = game.getPermanent(card.getId());
                    if (permanent != null)
                        permanent.setTapped(true);
                }

            }
            player.shuffleLibrary(game);
            return true;
        }
        player.shuffleLibrary(game);
        return false;

    }

}
