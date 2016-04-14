/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
 */
package mage.abilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mage.abilities.common.ZoneChangeTriggeredAbility;
import mage.abilities.costs.Cost;
import mage.abilities.keyword.ProtectionAbility;
import mage.abilities.mana.ManaAbility;
import mage.constants.Zone;
import mage.game.Game;
import mage.util.ThreadLocalStringBuilder;
import org.apache.log4j.Logger;

/**
 *
 * @author BetaSteward_at_googlemail.com
 * @param <T>
 */
public class AbilitiesImpl<T extends Ability> extends ArrayList<T> implements Abilities<T> {
    
    private static final Logger logger = Logger.getLogger(AbilitiesImpl.class);

    private static final ThreadLocalStringBuilder threadLocalBuilder = new ThreadLocalStringBuilder(200);

    public AbilitiesImpl() {
    }

    public AbilitiesImpl(T... abilities) {
        addAll(Arrays.asList(abilities));
    }

    public AbilitiesImpl(final AbilitiesImpl<T> abilities) {
        for (T ability : abilities) {
            this.add((T) ability.copy());
        }
    }

    @Override
    public AbilitiesImpl<T> copy() {
        return new AbilitiesImpl<>(this);
    }

    @Override
    public List<String> getRules(String source) {
        List<String> rules = new ArrayList<>();

        for (T ability : this) {
            if (!ability.getRuleVisible()) {
                continue;
            }
            if (!(ability instanceof SpellAbility || ability instanceof PlayLandAbility)) {
                String rule = ability.getRule();
                if (rule != null && rule.length() > 3) {
                    rule = Character.toUpperCase(rule.charAt(0)) + rule.substring(1);
                    if (ability.getRuleAtTheTop()) {
                        rules.add(0, rule);
                    } else {
                        rules.add(rule);
                    }
                }
                continue;
            }
            if (ability instanceof SpellAbility) {
                if (ability.getAdditionalCostsRuleVisible() && ability.getCosts().size() > 0) {
                    StringBuilder sbRule = threadLocalBuilder.get();
                    for (Cost cost : ability.getCosts()) {
                        if (cost.getText() != null && !cost.getText().isEmpty()) {
                            if (!cost.getText().startsWith("As an additional cost")) {
                                sbRule.append("As an additional cost to cast {this}, ");
                            }
                            sbRule.append(cost.getText()).append(".<br>");
                        }
                    }
                    rules.add(sbRule.toString());
                }
                String rule = ability.getRule();
                if (rule != null) {
                    if (rule.length() > 0) {
                        rules.add(Character.toUpperCase(rule.charAt(0)) + rule.substring(1));
                    }
                } else { // logging so we can still can be made aware of rule problems a card has
                    String cardName = ((SpellAbility) ability).getCardName();
                    logger.fatal("Error in rule text generation of " + cardName + ": Create a bug report or fix the source code");
                }
            }
        }

        return rules;
    }

    @Override
    public Abilities<ActivatedAbility> getActivatedAbilities(Zone zone) {
        Abilities<ActivatedAbility> zonedAbilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof ActivatedAbility && ability.getZone().match(zone)) {
                zonedAbilities.add((ActivatedAbility) ability);
            }
        }
        return zonedAbilities;
    }

    @Override
    public Abilities<ActivatedAbility> getPlayableAbilities(Zone zone) {
        Abilities<ActivatedAbility> zonedAbilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if ((ability instanceof ActivatedAbility || (ability instanceof PlayLandAbility))
                    && ability.getZone().match(zone)) {
                zonedAbilities.add((ActivatedAbility) ability);
            }
        }
        return zonedAbilities;
    }

    @Override
    public Abilities<ManaAbility> getManaAbilities(Zone zone) {
        Abilities<ManaAbility> abilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof ManaAbility && ability.getZone().match(zone)) {
                abilities.add((ManaAbility) ability);
            }
        }
        return abilities;
    }

    @Override
    public Abilities<ManaAbility> getAvailableManaAbilities(Zone zone, Game game) {
        Abilities<ManaAbility> abilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof ManaAbility && ability.getZone().match(zone)) {
                if ((((ManaAbility) ability).canActivate(ability.getControllerId(), game))) {
                    abilities.add((ManaAbility) ability);
                }
            }
        }
        return abilities;
    }

    @Override
    public Abilities<EvasionAbility> getEvasionAbilities() {
        Abilities<EvasionAbility> abilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof EvasionAbility) {
                abilities.add((EvasionAbility) ability);
            }
        }
        return abilities;
    }

    @Override
    public Abilities<StaticAbility> getStaticAbilities(Zone zone) {
        Abilities<StaticAbility> zonedAbilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof StaticAbility && ability.getZone().match(zone)) {
                zonedAbilities.add((StaticAbility) ability);
            }
        }
        return zonedAbilities;
    }

    @Override
    public Abilities<TriggeredAbility> getTriggeredAbilities(Zone zone) {
        Abilities<TriggeredAbility> zonedAbilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof TriggeredAbility && ability.getZone().match(zone)) {
                zonedAbilities.add((TriggeredAbility) ability);
            } else if (ability instanceof ZoneChangeTriggeredAbility) {
                ZoneChangeTriggeredAbility zcAbility = (ZoneChangeTriggeredAbility) ability;
                if (zcAbility.getToZone() != null && zcAbility.getToZone().match(zone)) {
                    zonedAbilities.add((ZoneChangeTriggeredAbility) ability);
                }
            }
        }
        return zonedAbilities;
    }

    @Override
    public Abilities<ProtectionAbility> getProtectionAbilities() {
        Abilities<ProtectionAbility> abilities = new AbilitiesImpl<>();
        for (T ability : this) {
            if (ability instanceof ProtectionAbility) {
                abilities.add((ProtectionAbility) ability);
            }
        }
        return abilities;
    }

    @Override
    public void setControllerId(UUID controllerId) {
        for (Ability ability : this) {
            ability.setControllerId(controllerId);
        }
    }

    @Override
    public void setSourceId(UUID sourceId) {
        for (Ability ability : this) {
            ability.setSourceId(sourceId);
        }
    }

    @Override
    public void newId() {
        for (Ability ability : this) {
            ability.newId();
        }
    }

    @Override
    public void newOriginalId() {
        for (Ability ability : this) {
            ability.newOriginalId();
        }
    }

    @Override
    public boolean contains(T ability) {
        for (Iterator<T> iterator = this.iterator(); iterator.hasNext();) { // simple loop can cause java.util.ConcurrentModificationException
            T test = iterator.next();
            // Checking also by getRule() without other restrictions is a problem when a triggered ability will be copied to a permanent that had the same ability
            // already before the copy. Because then it keeps the triggered ability twice and it triggers twice.
            // e.g. 2 Biovisonary and one enchanted with Infinite Reflection
            if (ability.getId().equals(test.getId())) {
                return true;
            }
            if (ability.getOriginalId().equals(test.getId())) {
                return true;
            }
            if (ability instanceof MageSingleton && test instanceof MageSingleton && ability.getRule().equals(test.getRule())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsRule(T ability) {
        for (T test : this) {
            if (ability.getRule().equals(test.getRule())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Abilities<T> abilities) {
        if (this.size() < abilities.size()) {
            return false;
        }
        for (T ability : abilities) {
            if (!contains(ability)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsKey(UUID abilityId) {
        for (T ability : this) {
            if (ability.getId().equals(abilityId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsClass(Class classObject) {
        for (T ability : this) {
            if (ability.getClass().equals(classObject)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(UUID abilityId) {
        for (T ability : this) {
            if (ability.getId().equals(abilityId)) {
                return ability;
            }
        }
        return null;
    }

    @Override
    public int getOutcomeTotal() {
        int total = 0;
        for (T ability : this) {
            total += ability.getEffects().getOutcomeTotal();
        }
        return total;
    }

    @Override
    public String getValue() {
        List<String> abilities = new ArrayList<>();
        for (T ability : this) {
            if (ability.toString() != null) {
                abilities.add(ability.toString());
            }
        }
        Collections.sort(abilities);
        StringBuilder sb = threadLocalBuilder.get();
        for (String s : abilities) {
            sb.append(s);
        }
        return sb.toString();
    }
}
