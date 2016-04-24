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
package mage.sets.masterseditioniv;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.common.ControlsPermanentsControllerTriggeredAbility;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.SacrificeSourceEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.Filter;
import mage.filter.common.FilterControlledLandPermanent;
import mage.filter.common.FilterLandPermanent;
import mage.filter.predicate.permanent.AnotherPredicate;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.target.Target;
import mage.target.common.TargetControlledPermanent;



/**
 *
 * @author MarcoMarin
 */
public class SerendibDjinn extends CardImpl {

    public SerendibDjinn(UUID ownerId) {
        super(ownerId, 61, "Serendib Djinn", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{2}{U}{U}");
        this.expansionSetCode = "ME4";
        this.subtype.add("Djinn");
        this.power = new MageInt(5);
        this.toughness = new MageInt(6);

        // Flying
        this.addAbility(FlyingAbility.getInstance());
        // At the beginning of your upkeep, sacrifice a land. If you sacrifice an Island this way, Serendib Djinn deals 3 damage to you.
        this.addAbility(new BeginningOfUpkeepTriggeredAbility(new SerendibDjinnEffect(), TargetController.YOU, false));
        // When you control no lands, sacrifice Serendib Djinn.
        this.addAbility(new ControlsPermanentsControllerTriggeredAbility(
                new FilterLandPermanent(), Filter.ComparisonType.Equal, 0,
                new SacrificeSourceEffect()));
    }

    public SerendibDjinn(final SerendibDjinn card) {
        super(card);
    }

    @Override
    public SerendibDjinn copy() {
        return new SerendibDjinn(this);
    }
}
class SerendibDjinnEffect extends OneShotEffect {

    public SerendibDjinnEffect() {
        super(Outcome.Damage);
        this.staticText = "Sacrifice a Land. If it is an Island {this} deals 3 damage to you.";
    }

    public SerendibDjinnEffect(final SerendibDjinnEffect effect) {
        super(effect);
    }

    @Override
    public SerendibDjinnEffect copy() {
        return new SerendibDjinnEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        Permanent sourcePermanent = game.getPermanent(source.getSourceId());
        if (sourcePermanent == null) {
            sourcePermanent = (Permanent) game.getLastKnownInformation(source.getSourceId(), Zone.BATTLEFIELD);
        }
        if (player == null || sourcePermanent == null) {
            return false;
        }

        FilterControlledLandPermanent filter = new FilterControlledLandPermanent("Controlled Land");
        filter.add(new AnotherPredicate());

        Target target = new TargetControlledPermanent(1, 1, filter, true);
        
        if (target.canChoose(source.getSourceId(), player.getId(), game)) {
            player.choose(Outcome.Sacrifice, target, source.getSourceId(), game);
            Permanent permanent = game.getPermanent(target.getFirstTarget());
            if (permanent != null) {
                permanent.sacrifice(source.getSourceId(), game);
                if (permanent.hasSubtype("Island")) {
                    player.damage(3, source.getSourceId(), game, false, true);
                }
                return true;
            }
        }
        return false;
    }
}
