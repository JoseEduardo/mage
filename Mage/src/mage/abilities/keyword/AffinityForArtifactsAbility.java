/*
 *  Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
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
package mage.abilities.keyword;

import mage.Constants;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.AdjustingSourceCosts;
import mage.abilities.effects.CostModificationEffect;
import mage.abilities.effects.common.AffinityEffect;
import mage.filter.Filter;
import mage.filter.common.FilterControlledPermanent;
import mage.game.Game;

/**
 * Affinity for artifacts
 */
public class AffinityForArtifactsAbility extends SimpleStaticAbility implements AdjustingSourceCosts {
    private static final FilterControlledPermanent filter = new FilterControlledPermanent();

    static {
        filter.getCardType().add(Constants.CardType.ARTIFACT);
        filter.setScopeCardType(Filter.ComparisonScope.Any);
    }

    public AffinityForArtifactsAbility() {
        super(Constants.Zone.OUTSIDE, new AffinityEffect(filter));
    }

    public AffinityForArtifactsAbility(final AffinityForArtifactsAbility ability) {
        super(ability);
    }

    @Override
    public SimpleStaticAbility copy() {
        return new AffinityForArtifactsAbility(this);
    }

    @Override
    public String getRule() {
        return "Affinity for artifacts";
    }

    @Override
    public void adjustCosts(Ability ability, Game game) {
        ((CostModificationEffect)getEffects().get(0)).apply(game, this, ability);
    }
}
