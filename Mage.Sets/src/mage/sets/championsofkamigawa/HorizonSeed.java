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

package mage.sets.championsofkamigawa;

import java.util.UUID;

import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SpellCastTriggeredAbility;
import mage.abilities.effects.common.RegenerateTargetEffect;
import mage.cards.CardImpl;
import mage.filter.Filter;
import mage.filter.FilterCard;
import mage.target.common.TargetCreaturePermanent;

/**
 * @author Loki
 */
public class HorizonSeed extends CardImpl<HorizonSeed> {

    private final static FilterCard filter = new FilterCard("Spirit or Arcane spell");

    static {
        filter.getSubtype().add("Spirit");
        filter.getSubtype().add("Arcane");
        filter.setScopeSubtype(Filter.ComparisonScope.Any);
    }

    public HorizonSeed(UUID ownerId) {
        super(ownerId, 15, "Horizon Seed", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{4}{W}");
        this.expansionSetCode = "CHK";
        this.subtype.add("Spirit");
        this.color.setWhite(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(1);
        Ability ability = new SpellCastTriggeredAbility(new RegenerateTargetEffect(), filter, false);
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
    }

    public HorizonSeed(final HorizonSeed card) {
        super(card);
    }

    @Override
    public HorizonSeed copy() {
        return new HorizonSeed(this);
    }

}
