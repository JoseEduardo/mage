package mage.abilities.condition.common;

import mage.abilities.Ability;
import mage.abilities.condition.Condition;
import mage.abilities.costs.OptionalAdditionalCost;
import mage.abilities.costs.mana.KickerManaCost;
import mage.abilities.keyword.KickerAbility;
import mage.cards.Card;
import mage.game.Game;

/**
 * Describes condition when specific KickerCosts were paid.
 *
 * @author LevelX2
 */
public class KickedCostCondition implements Condition {

    protected KickerManaCost kickerManaCost;

    public  KickedCostCondition(KickerManaCost kickerManaCost) {
        this.kickerManaCost = kickerManaCost;
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Card card = game.getCard(source.getSourceId());
        if (card != null) {
            KickerAbility kickerAbility = null;
            for (Ability ability: card.getAbilities()) {
                if (ability instanceof KickerAbility) {
                    kickerAbility = (KickerAbility) ability;
                }
            }
            if (kickerAbility != null) {
                for (OptionalAdditionalCost cost: kickerAbility.getKickerCosts()) {
                    if (cost.equals(kickerManaCost)) {
                        return cost.isActivated();
                    }
                }
            }
        }
        return false;
    }
}
