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

package mage.sets.shardsofalara;

import java.util.UUID;

import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.Constants.Zone;
import mage.abilities.Ability;
import mage.abilities.dynamicvalue.common.CountersCount;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.common.RemoveCountersSourceCost;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.continious.BoostEquippedEffect;
import mage.abilities.keyword.EquipAbility;
import mage.cards.CardImpl;
import mage.counters.CounterType;
import mage.game.Game;
import mage.game.permanent.Permanent;

/**
 *
 * @author Loki
 */
public class SigilofDistinction extends CardImpl<SigilofDistinction> {

    public SigilofDistinction (UUID ownerId) {
        super(ownerId, 219, "Sigil of Distinction", Rarity.RARE, new CardType[]{CardType.ARTIFACT}, "{X}");
        this.expansionSetCode = "ALA";
        this.subtype.add("Equipment");
        this.addAbility(new EntersBattlefieldAbility(new SigilofDistinctionEffect(), "Sigil of Distinction enters the battlefield with X charge counters on it"));
        this.addAbility(new EquipAbility(Constants.Outcome.AddAbility, new RemoveCountersSourceCost(CounterType.CHARGE.createInstance())));
        BoostEquippedEffect effect = new BoostEquippedEffect(new CountersCount(CounterType.CHARGE), new CountersCount(CounterType.CHARGE));
        effect.setStaticText("Equipped creature gets +1/+1 for each charge counter on Sigil of Distinction");
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, effect));
    }

    public SigilofDistinction (final SigilofDistinction card) {
        super(card);
    }

    @Override
    public SigilofDistinction copy() {
        return new SigilofDistinction(this);
    }
}

class SigilofDistinctionEffect extends OneShotEffect<SigilofDistinctionEffect> {
    public SigilofDistinctionEffect() {
        super(Constants.Outcome.Benefit);
    }

    public SigilofDistinctionEffect(final SigilofDistinctionEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        int amount = source.getManaCosts().getVariableCosts().get(0).getAmount();
        Permanent p = game.getPermanent(source.getSourceId());
        if (p != null) {
            p.addCounters(CounterType.CHARGE.createInstance(amount));
            return true;
        }
        return true;
    }

    @Override
    public SigilofDistinctionEffect copy() {
        return new SigilofDistinctionEffect(this);
    }
}