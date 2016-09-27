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
package mage.sets.starwars;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.AttacksOrBlocksTriggeredAbility;
import mage.abilities.common.EntersBattlefieldOrDiesSourceTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.RepairAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.game.permanent.token.DroidToken;

/**
 *
 * @author Styxo
 */
public class TankDroid extends CardImpl {

    public TankDroid(UUID ownerId) {
        super(ownerId, 219, "Tank Droid", Rarity.RARE, new CardType[]{CardType.ARTIFACT, CardType.CREATURE}, "{4}{W}{U}{B}");
        this.expansionSetCode = "SWS";
        this.subtype.add("Droid");
        this.power = new MageInt(5);
        this.toughness = new MageInt(5);

        // Whenever Tank Droid enters the battlefield, attacks, blocks or dies, create a 1/1 colorless Droid token creature.
        Ability ability = new AttacksOrBlocksTriggeredAbility(new CreateTokenEffect(new DroidToken()), false);
        this.addAbility(ability);
        ability = new EntersBattlefieldOrDiesSourceTriggeredAbility(new CreateTokenEffect(new DroidToken()), false);
        this.addAbility(ability);
        // Repair 3
        this.addAbility(new RepairAbility(3));
    }

    public TankDroid(final TankDroid card) {
        super(card);
    }

    @Override
    public TankDroid copy() {
        return new TankDroid(this);
    }
}
