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
package mage.cards.m;

import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.*;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.mageobject.NamePredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.TargetCard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author North
 */
public class MitoticManipulation extends CardImpl {

    public MitoticManipulation(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.SORCERY},"{1}{U}{U}");


        this.getSpellAbility().addEffect(new MitoticManipulationEffect());
    }

    public MitoticManipulation(final MitoticManipulation card) {
        super(card);
    }

    @Override
    public MitoticManipulation copy() {
        return new MitoticManipulation(this);
    }
}

class MitoticManipulationEffect extends OneShotEffect {

    public MitoticManipulationEffect() {
        super(Outcome.PutCardInPlay);
        this.staticText = "Look at the top seven cards of your library. You may put one of those cards onto the battlefield if it has the same name as a permanent. Put the rest on the bottom of your library in any order";
    }

    public MitoticManipulationEffect(final MitoticManipulationEffect effect) {
        super(effect);
    }

    @Override
    public MitoticManipulationEffect copy() {
        return new MitoticManipulationEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        List<Permanent> permanents = game.getBattlefield().getActivePermanents(source.getControllerId(), game);
        Set<String> permanentNames = new HashSet<>();
        FilterCard filter = new FilterCard("card to put onto the battlefield");
        for (Permanent permanent : permanents) {
            permanentNames.add(permanent.getName());
            filter.add(new NamePredicate(permanent.getName()));
        }

        Player player = game.getPlayer(source.getControllerId());
        if (player == null) {
            return false;
        }

        Cards cards = new CardsImpl();
        Cards cardsFound = new CardsImpl();
        int count = Math.min(player.getLibrary().size(), 7);
        for (int i = 0; i < count; i++) {
            Card card = player.getLibrary().removeFromTop(game);
            if (card != null) {
                cards.add(card);
                if (permanentNames.contains(card.getName())) {
                    cardsFound.add(card);
                }
            }
        }
        player.lookAtCards("Mitotic Manipulation", cards, game);

        if (!cardsFound.isEmpty() && player.chooseUse(Outcome.PutCardInPlay, "Do you wish to put a card on the battlefield?", source, game)) {
            TargetCard target = new TargetCard(Zone.LIBRARY, filter);

            if (player.choose(Outcome.PutCardInPlay, cardsFound, target, game)) {
                Card card = cards.get(target.getFirstTarget(), game);
                if (card != null) {
                    cards.remove(card);
                    card.putOntoBattlefield(game, Zone.LIBRARY, source.getSourceId(), source.getControllerId());
                }
            }
        }
        player.putCardsOnBottomOfLibrary(cards, game, source, true);
        return true;
    }
}
