/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mage.abilities.common;

import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.constants.SetTargetPointer;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.target.targetpointer.FixedTarget;

/**
 *
 * @author jeffwadsworth
 */
public class DiscardsACardOpponentTriggeredAbility extends TriggeredAbilityImpl {

    private SetTargetPointer setTargetPointer;

    public DiscardsACardOpponentTriggeredAbility(Effect effect, Boolean isOptional) {
        this(effect, isOptional, SetTargetPointer.NONE);
    }

    public DiscardsACardOpponentTriggeredAbility(Effect effect, Boolean isOptional, SetTargetPointer setTargetPointer) {
        super(Zone.BATTLEFIELD, effect, isOptional);
        this.setTargetPointer = setTargetPointer;
    }

    public DiscardsACardOpponentTriggeredAbility(final DiscardsACardOpponentTriggeredAbility ability) {
        super(ability);
        this.setTargetPointer = ability.setTargetPointer;
    }

    @Override
    public DiscardsACardOpponentTriggeredAbility copy() {
        return new DiscardsACardOpponentTriggeredAbility(this);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.DISCARDED_CARD;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (game.getOpponents(controllerId).contains(event.getPlayerId())) {
            switch (setTargetPointer) {
                case PLAYER:
                    for (Effect effect : getEffects()) {
                        effect.setTargetPointer(new FixedTarget(event.getPlayerId()));
                    }
                    break;
                default:
                    throw new UnsupportedOperationException(setTargetPointer.toString() + " not supported for this ability.");
            }
            return true;
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever an opponent discards a card, " + super.getRule();
    }
}
