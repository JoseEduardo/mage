package mage.abilities.common;

import mage.MageObject;
import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.ZoneChangeEvent;
import mage.game.permanent.Permanent;
import mage.target.targetpointer.FixedTarget;

public class DiesAndDealtDamageThisTurnTriggeredAbility extends TriggeredAbilityImpl {

    public DiesAndDealtDamageThisTurnTriggeredAbility(Effect effect) {
        this(effect, false);
    }

    public DiesAndDealtDamageThisTurnTriggeredAbility(Effect effect, boolean optional) {
        super(Zone.ALL, effect, optional);
    }

    public DiesAndDealtDamageThisTurnTriggeredAbility(final DiesAndDealtDamageThisTurnTriggeredAbility ability) {
        super(ability);
    }

    @Override
    public DiesAndDealtDamageThisTurnTriggeredAbility copy() {
        return new DiesAndDealtDamageThisTurnTriggeredAbility(this);
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        if (event.getType() == GameEvent.EventType.ZONE_CHANGE && ((ZoneChangeEvent)event).isDiesEvent()) {
            ZoneChangeEvent zEvent = (ZoneChangeEvent) event;
            if (zEvent.getTarget().getCardType().contains(CardType.CREATURE) &&
                    zEvent.getTarget().getDealtDamageByThisTurn().contains(this.sourceId)) {
                for (Effect effect : getEffects()) {
                    effect.setTargetPointer(new FixedTarget(event.getTargetId()));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getRule() {
        return "Whenever a creature dealt damage by {this} this turn dies, " + super.getRule();
    }
}