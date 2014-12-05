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

package mage.abilities.effects.common;

import mage.Mana;
import mage.abilities.Abilities;
import mage.abilities.Ability;
import mage.abilities.mana.ManaAbility;
import mage.choices.Choice;
import mage.choices.ChoiceImpl;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;

/**
 *
 * @author LevelX2
 */

public class AddManaOfAnyColorTargetCanProduceEffect extends ManaEffect {

    public AddManaOfAnyColorTargetCanProduceEffect() {
        super();
        staticText = "that player adds one mana to his or her mana pool of any type that land produced";
    }

    public AddManaOfAnyColorTargetCanProduceEffect(final AddManaOfAnyColorTargetCanProduceEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player controller = game.getPlayer(source.getControllerId());
        Permanent permanent = game.getPermanent(this.targetPointer.getFirst(game, source));
        if (controller != null && permanent != null) {
            Abilities<ManaAbility> mana = permanent.getAbilities().getManaAbilities(Zone.BATTLEFIELD);
            Mana types = new Mana();
            for (ManaAbility ability : mana) {
                for(Mana netMana: ability.getNetMana(game)) {
                    types.add(netMana);
                }                
            }
            Choice choice = new ChoiceImpl(true);
            choice.setMessage("Pick the type of mana to produce");
            if (types.getBlack() > 0) {
                choice.getChoices().add("Black");
            }
            if (types.getRed() > 0) {
                choice.getChoices().add("Red");
            }
            if (types.getBlue() > 0) {
                choice.getChoices().add("Blue");
            }
            if (types.getGreen() > 0) {
                choice.getChoices().add("Green");
            }
            if (types.getWhite() > 0) {
                choice.getChoices().add("White");
            }
            if (types.getColorless() > 0) {
                choice.getChoices().add("Colorless");
            }
            if (choice.getChoices().size() > 0) {
                if (choice.getChoices().size() == 1) {
                    choice.setChoice(choice.getChoices().iterator().next());
                } else {
                    controller.choose(outcome, choice, game);
                }
                if (choice.getChoice() == null) {
                    return false;
                }
                Mana newMana = new Mana();
                switch (choice.getChoice()) {
                    case "Black":
                        newMana.setBlack(1);
                        return true;
                    case "Blue":
                        newMana.setBlue(1);
                        return true;
                    case "Red":
                        newMana.setRed(1);
                        return true;
                    case "Green":
                        newMana.setGreen(1);
                        return true;
                    case "White":
                        newMana.setWhite(1);
                        return true;
                    case "Colorless":
                        newMana.setColorless(1);
                        return true;
                }                
                controller.getManaPool().addMana(newMana, game, source);
                checkToFirePossibleEvents(newMana, game, source);
            }
            return true;
        }
        return false;
    }

    @Override
    public AddManaOfAnyColorTargetCanProduceEffect copy() {
        return new AddManaOfAnyColorTargetCanProduceEffect(this);
    }

    @Override
    public Mana getMana(Game game, Ability source) {
        return null;
    }


}
