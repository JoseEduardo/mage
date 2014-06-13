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
package mage.abilities.effects.common.discard;

import java.util.List;
import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.abilities.dynamicvalue.common.StaticValue;
import mage.abilities.effects.OneShotEffect;
import mage.cards.Card;
import mage.cards.Cards;
import mage.cards.CardsImpl;
import mage.constants.Outcome;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.game.Game;
import mage.players.Player;
import mage.target.TargetCard;
import mage.target.common.TargetCardInHand;
import mage.util.CardUtil;

/**
 *
 * @author noxx
 */
public class DiscardCardYouChooseTargetEffect extends OneShotEffect {

    private FilterCard filter;
    private TargetController targetController;
    private DynamicValue numberCardsToReveal;
    private final DynamicValue numberCardsToDiscard;
    private boolean revealAllCards;

    public DiscardCardYouChooseTargetEffect() {
        this(new FilterCard("a card"));
    }

    public DiscardCardYouChooseTargetEffect(TargetController targetController) {
        this(new FilterCard("a card"), targetController);
    }

    public DiscardCardYouChooseTargetEffect(DynamicValue numberCardsToDiscard, TargetController targetController) {
        this(numberCardsToDiscard, new FilterCard("cards"), targetController);
    }

    public DiscardCardYouChooseTargetEffect(FilterCard filter) {
        this(filter, TargetController.OPPONENT);
    }
   
    public DiscardCardYouChooseTargetEffect(TargetController targetController, int numberCardsToReveal) {
        this(new FilterCard("one card"), targetController, 
                new StaticValue(numberCardsToReveal, new StringBuilder(CardUtil.numberToText(numberCardsToReveal)).append(" cards").toString()));
    }

    public DiscardCardYouChooseTargetEffect(TargetController targetController, DynamicValue numberCardsToReveal) {
        this(new FilterCard("one card"), targetController, numberCardsToReveal);
    }

    public DiscardCardYouChooseTargetEffect(FilterCard filter, TargetController targetController, DynamicValue numberCardsToReveal) {
        super(Outcome.Discard);
        this.targetController = targetController;
        this.filter = filter;
        
        this.revealAllCards = false;
        this.numberCardsToReveal = numberCardsToReveal;
        this.numberCardsToDiscard = new StaticValue(1);
        
        staticText = this.setText();        
    }
    
    public DiscardCardYouChooseTargetEffect(FilterCard filter, TargetController targetController) {
        this(new StaticValue(1), filter, targetController);
    }
    
    public DiscardCardYouChooseTargetEffect(DynamicValue numberCardsToDiscard, FilterCard filter, TargetController targetController) {
        super(Outcome.Discard);
        this.targetController = targetController;
        this.filter = filter;
        
        this.numberCardsToDiscard = numberCardsToDiscard;
        this.numberCardsToReveal = null;
        this.revealAllCards = true;
        
        staticText = this.setText();        
    }

    public DiscardCardYouChooseTargetEffect(final DiscardCardYouChooseTargetEffect effect) {
        super(effect);
        this.filter = effect.filter;
        this.targetController = effect.targetController;
        this.numberCardsToDiscard = effect.numberCardsToDiscard;
        this.numberCardsToReveal = effect.numberCardsToReveal;
        this.revealAllCards = effect.revealAllCards;                
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getFirstTarget());
        Player controller = game.getPlayer(source.getControllerId());
        Card sourceCard = game.getCard(source.getSourceId());
        if (player != null && controller != null) {
            if (revealAllCards) {
                this.numberCardsToReveal = new StaticValue(player.getHand().size());
            }
            int numberToReveal = this.numberCardsToReveal.calculate(game, source);
            if (numberToReveal > 0) {
                Cards revealedCards = new CardsImpl(Zone.HAND);                
                numberToReveal = Math.min(player.getHand().size(), numberToReveal);
                if (player.getHand().size() > numberToReveal) {
                    TargetCardInHand chosenCards = new TargetCardInHand(numberToReveal, numberToReveal, new FilterCard("card in target player's hand"));
                    chosenCards.setNotTarget(true);
                    if (chosenCards.canChoose(player.getId(), game) && player.choose(Outcome.Discard, player.getHand(), chosenCards, game)) {
                        if (!chosenCards.getTargets().isEmpty()) {
                            List<UUID> targets = chosenCards.getTargets();
                            for (UUID targetid : targets) {
                                Card card = game.getCard(targetid);
                                if (card != null) {
                                    revealedCards.add(card);
                                }
                            }
                        }
                    }
                } else {
                    revealedCards.addAll(player.getHand());
                }                

                player.revealCards(sourceCard != null ? sourceCard.getName() :"Discard", revealedCards, game);
                
                boolean result = true;
                int filteredCardsCount = revealedCards.count(filter, source.getSourceId(), source.getControllerId(), game);
                int numberToDiscard = Math.min(this.numberCardsToDiscard.calculate(game, source), filteredCardsCount);
                if (numberToDiscard > 0) {
                    TargetCard target = new TargetCard(numberToDiscard, Zone.HAND, filter);
                    if (controller.choose(Outcome.Benefit, revealedCards, target, game)) {
                        for (Object targetId : target.getTargets()) {
                            Card card = revealedCards.get((UUID) targetId, game);
                            if (card != null) {
                                if (!player.discard(card, source, game)) {
                                    result = false;
                                }
                            }
                        }
                    }
                }
                return result;
            }
            return true;
        }
        return false;
    }

    @Override
    public DiscardCardYouChooseTargetEffect copy() {
        return new DiscardCardYouChooseTargetEffect(this);
    }

    private String setText() {
        StringBuilder sb = new StringBuilder("Target ");
        switch(targetController) {
            case OPPONENT:
                sb.append("opponent");
                break;
            case ANY:
                sb.append("player");
                break;
            default:
                throw new UnsupportedOperationException("target controller not supported");
        }
        if (revealAllCards) {
            sb.append(" reveals his or her hand");
        } else {
            if (numberCardsToReveal instanceof StaticValue) {
                sb.append(" reveales ");
                sb.append(numberCardsToReveal.getMessage());
                sb.append(" from his or her hand");
            } else {
                sb.append(" reveals a number of cards from his or her hand equal to ");
                sb.append(numberCardsToReveal.getMessage());
            }
        }
        sb.append(". You choose ");
        boolean discardMultipleCards = !numberCardsToDiscard.toString().equals("1");
        if (discardMultipleCards) {
            sb.append(numberCardsToDiscard).append(" ");
        } else {
            if (!filter.getMessage().startsWith("a ") && !filter.getMessage().startsWith("an ")) {
                sb.append("a ");
            }
        }
        sb.append(filter.getMessage());
        if (revealAllCards) {
            sb.append(" from it.");
        } else {
            sb.append(" of them.");
        }
        
        sb.append(" That player discards ").append(discardMultipleCards ? "those cards" : "that card").toString();
        return sb.toString();
    }
}
