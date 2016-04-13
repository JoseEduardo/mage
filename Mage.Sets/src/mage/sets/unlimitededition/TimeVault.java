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
package mage.sets.unlimitededition;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.ReplacementEffectImpl;
import mage.abilities.effects.common.DontUntapInControllersUntapStepSourceEffect;
import mage.abilities.effects.common.turn.AddExtraTurnControllerEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.events.GameEvent.EventType;
import mage.game.permanent.Permanent;
import mage.players.Player;

/**
 *
 * @author emerald000
 */
public class TimeVault extends CardImpl {

    public TimeVault(UUID ownerId) {
        super(ownerId, 275, "Time Vault", Rarity.RARE, new CardType[]{CardType.ARTIFACT}, "{2}");
        this.expansionSetCode = "2ED";

        // Time Vault enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());
        
        // Time Vault doesn't untap during your untap step.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new DontUntapInControllersUntapStepSourceEffect()));
        
        // If you would begin your turn while Time Vault is tapped, you may skip that turn instead. If you do, untap Time Vault.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new TimeVaultReplacementEffect()));
        
        // {tap}: Take an extra turn after this one.
        this.addAbility(new SimpleActivatedAbility(Zone.BATTLEFIELD, new AddExtraTurnControllerEffect(), new TapSourceCost()));

    }

    public TimeVault(final TimeVault card) {
        super(card);
    }

    @Override
    public TimeVault copy() {
        return new TimeVault(this);
    }
}

class TimeVaultReplacementEffect extends ReplacementEffectImpl {
    
    TimeVaultReplacementEffect() {
        super(Duration.WhileOnBattlefield, Outcome.Untap);
        staticText = "If you would begin your turn while {this} is tapped, you may skip that turn instead. If you do, untap Time Vault.";        
    }
    
    TimeVaultReplacementEffect(final TimeVaultReplacementEffect effect) {
        super(effect);
    }
    
    @Override
    public TimeVaultReplacementEffect copy() {
        return new TimeVaultReplacementEffect(this);
    }
    
    @Override
    public boolean checksEventType(GameEvent event, Game game) {
        return event.getType() == EventType.PLAY_TURN;
    }
    
    @Override
    public boolean applies(GameEvent event, Ability source, Game game) {
        if (source.getControllerId().equals(event.getPlayerId())) {
            Permanent permanent = game.getPermanent(source.getSourceId());
            if (permanent != null && permanent.isTapped()) {
                return true;
            }
        }
        return false;
    }
       
    @Override
    public boolean replaceEvent(GameEvent event, Ability source, Game game) {
        Player player = game.getPlayer(source.getControllerId());
        Permanent permanent = game.getPermanent(source.getSourceId());
        if (player != null && permanent != null) {
            if (player.chooseUse(Outcome.Untap, "Skip your turn to untap " + permanent.getName() + "?", source, game)) {
                permanent.untap(game);
                game.informPlayers(player.getLogName() + " skips his or her turn to untap " + permanent.getLogName());
                return true;
            }
        }
        return false;
    }
}
