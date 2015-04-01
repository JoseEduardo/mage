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
package mage.sets.tempestremastered;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.RemoveCountersSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.counters.CounterType;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author fireshoes
 */
public class SpittingHydra extends CardImpl {

    public SpittingHydra(UUID ownerId) {
        super(ownerId, 161, "Spitting Hydra", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{3}{R}{R}");
        this.expansionSetCode = "TPR";
        this.subtype.add("Hydra");
        this.power = new MageInt(0);
        this.toughness = new MageInt(0);

        // Spitting Hydra enters the battlefield with four +1/+1 counters on it.
        Effect effect = new AddCountersSourceEffect(CounterType.P1P1.createInstance(4));
        effect.setText("with four +1/+1 counters on it");
        this.addAbility(new EntersBattlefieldAbility(effect));
        
        // {1}{R}, Remove a +1/+1 counter from Spitting Hydra: Spitting Hydra deals 1 damage to target creature.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new DamageTargetEffect(1), new ManaCostsImpl("{1}{R}"));
        ability.addCost(new RemoveCountersSourceCost(CounterType.P1P1.createInstance(1)));
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
    }

    public SpittingHydra(final SpittingHydra card) {
        super(card);
    }

    @Override
    public SpittingHydra copy() {
        return new SpittingHydra(this);
    }
}