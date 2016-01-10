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
package mage.sets.planarchaos;

import java.util.UUID;
import mage.MageInt;
import mage.MageObject;
import mage.abilities.Ability;
import mage.abilities.Mode;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.DiscardTargetCost;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.CastSourceTriggeredAbility;
import mage.abilities.effects.common.ReturnSourceFromGraveyardToHandEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.game.Game;
import mage.game.stack.Spell;
import mage.players.Player;
import mage.target.common.TargetCardInHand;

/**
 *
 * @author Plopman
 */
public class Phantasmagorian extends CardImpl {

    public Phantasmagorian(UUID ownerId) {
        super(ownerId, 77, "Phantasmagorian", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{5}{B}{B}");
        this.expansionSetCode = "PLC";
        this.subtype.add("Horror");

        this.power = new MageInt(6);
        this.toughness = new MageInt(6);

        // When you cast Phantasmagorian, any player may discard three cards. If a player does, counter Phantasmagorian.
        this.addAbility(new CastSourceTriggeredAbility(new CounterSourceEffect()));
        // Discard three cards: Return Phantasmagorian from your graveyard to your hand.
        this.addAbility(new SimpleActivatedAbility(Zone.GRAVEYARD, new ReturnSourceFromGraveyardToHandEffect(), new DiscardTargetCost(new TargetCardInHand(3, 3, new FilterCard("three cards")))));
    }

    public Phantasmagorian(final Phantasmagorian card) {
        super(card);
    }

    @Override
    public Phantasmagorian copy() {
        return new Phantasmagorian(this);
    }
}

class CounterSourceEffect extends OneShotEffect {

    public CounterSourceEffect() {
        super(Outcome.AIDontUseIt);
    }

    public CounterSourceEffect(final CounterSourceEffect effect) {
        super(effect);
    }

    @Override
    public CounterSourceEffect copy() {
        return new CounterSourceEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        MageObject sourceObject = source.getSourceObject(game);
        if (sourceObject != null) {
            DiscardTargetCost cost = new DiscardTargetCost(new TargetCardInHand(3, 3, new FilterCard()));
            for (UUID playerId : game.getState().getPlayerList(source.getControllerId())) {
                Player player = game.getPlayer(playerId);
                cost.clearPaid();
                if (cost.canPay(source, source.getSourceId(), player.getId(), game)
                        && player.chooseUse(outcome, "Discard three cards to counter " + sourceObject.getIdName() + "?", source, game)) {
                    if (cost.pay(source, game, source.getSourceId(), playerId, false, null)) {
                        game.informPlayers(player.getLogName() + " discards 3 cards to counter " + sourceObject.getIdName() + ".");
                        Spell spell = game.getStack().getSpell(source.getSourceId());
                        if (spell != null) {
                            game.getStack().counter(spell.getId(), source.getSourceId(), game);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getText(Mode mode) {
        if (staticText != null && !staticText.isEmpty()) {
            return staticText;
        }
        return "any player may discard three cards. If a player does, counter {source}";
    }
}
