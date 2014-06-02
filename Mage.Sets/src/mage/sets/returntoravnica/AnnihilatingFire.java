/*
 *
 * Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
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
 *
 */
package mage.sets.returntoravnica;

import java.util.UUID;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.abilities.Ability;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.cards.CardImpl;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.GameEvent.EventType;
import mage.game.events.ZoneChangeEvent;
import mage.game.permanent.Permanent;
import mage.target.common.TargetCreatureOrPlayer;
import mage.watchers.common.DamagedByWatcher;

/**
 *
 * @author LevelX2
 */
public class AnnihilatingFire extends CardImpl<AnnihilatingFire> {

    public AnnihilatingFire(UUID ownerId) {
            super(ownerId, 85, "Annihilating Fire", Rarity.COMMON, new CardType[]{CardType.INSTANT}, "{1}{R}{R}");
            this.expansionSetCode = "RTR";
            this.color.setRed(true);

            // Annihilating Fire deals 3 damage to target creature or player.
            this.getSpellAbility().addEffect(new DamageTargetEffect(3));
            this.getSpellAbility().addTarget(new TargetCreatureOrPlayer());

            // If a creature dealt damage this way would die this turn, exile it instead.
            this.getSpellAbility().addEffect(new AnnihilatingFireEffect());
            this.addWatcher(new DamagedByWatcher());
        }

        public AnnihilatingFire(final AnnihilatingFire card) {
                super(card);
    }

    @Override
    public AnnihilatingFire copy() {
        return new AnnihilatingFire(this);
    }
}

class AnnihilatingFireEffect extends ReplacementEffectImpl {

        public AnnihilatingFireEffect() {
                super(Duration.EndOfTurn, Outcome.Exile);
                staticText = "If a creature dealt damage this way would die this turn, exile it instead";
        }

        public AnnihilatingFireEffect(final AnnihilatingFireEffect effect) {
                super(effect);
        }

        @Override
        public AnnihilatingFireEffect copy() {
                return new AnnihilatingFireEffect(this);
        }

        @Override
        public boolean apply(Game game, Ability source) {
                return true;
        }

        @Override
        public boolean replaceEvent(GameEvent event, Ability source, Game game) {
                Permanent permanent = ((ZoneChangeEvent)event).getTarget();
                if (permanent != null) {
                    return permanent.moveToExile(null, "", source.getSourceId(), game);
                }
                return false;
        }

        @Override
        public boolean applies(GameEvent event, Ability source, Game game) {
                if (event.getType() == EventType.ZONE_CHANGE && ((ZoneChangeEvent)event).isDiesEvent()) {
                        DamagedByWatcher watcher = (DamagedByWatcher) game.getState().getWatchers().get("DamagedByWatcher", source.getSourceId());
                        if (watcher != null) {
                            return watcher.damagedCreatures.contains(event.getTargetId());
                        }
                }
                return false;
        }
}