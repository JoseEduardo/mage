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
package mage.cards.j;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.effects.common.combat.CantBeBlockedSourceEffect;
import mage.abilities.effects.common.continuous.BoostSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.predicate.mageobject.CardTypePredicate;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.permanent.ControllerPredicate;

/**
 *
 * @author TheElk801
 */
public class JacesSentinel extends CardImpl {

    private static final FilterPermanent filter = new FilterPermanent("a Jace planeswalker");

    static {
        filter.add(new ControllerPredicate(TargetController.YOU));
        filter.add(new CardTypePredicate(CardType.PLANESWALKER));
        filter.add(new SubtypePredicate(SubType.JACE));
    }

    public JacesSentinel(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{U}");

        this.subtype.add(SubType.MERFOLK);
        this.subtype.add(SubType.WARRIOR);
        this.power = new MageInt(1);
        this.toughness = new MageInt(3);

        // As long as you control a Jace planeswalker, Jace's Sentinel gets +1/+0 and can't be blocked.
        Ability ability = new SimpleStaticAbility(Zone.BATTLEFIELD, new ConditionalContinuousEffect(
                new BoostSourceEffect(1, 0, Duration.WhileOnBattlefield),
                new PermanentsOnTheBattlefieldCondition(filter),
                "As long as you control a Jace planeswalker, {this} gets +1/+0"));
        ability.addEffect(new ConditionalContinuousEffect(
                new CantBeBlockedSourceEffect(),
                new PermanentsOnTheBattlefieldCondition(filter),
                "and has can't be blocked"));
    }

    public JacesSentinel(final JacesSentinel card) {
        super(card);
    }

    @Override
    public JacesSentinel copy() {
        return new JacesSentinel(this);
    }
}
