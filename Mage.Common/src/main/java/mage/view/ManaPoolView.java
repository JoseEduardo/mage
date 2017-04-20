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
package mage.view;

import mage.ConditionalMana;
import mage.players.ManaPool;

import java.io.Serializable;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ManaPoolView implements Serializable {

    private static final long serialVersionUID = 1L;

    private int red;
    private int green;
    private int blue;
    private int white;
    private int black;
    private int colorless;

    public ManaPoolView(ManaPool pool) {
        this.red = pool.getRed();
        this.green = pool.getGreen();
        this.blue = pool.getBlue();
        this.white = pool.getWhite();
        this.black = pool.getBlack();
        this.colorless = pool.getColorless();
        for (ConditionalMana mana : pool.getConditionalMana()) {
            this.red += mana.getRed();
            this.green += mana.getGreen();
            this.blue += mana.getBlue();
            this.white += mana.getWhite();
            this.black += mana.getBlack();
            this.colorless += mana.getColorless();
        }
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getWhite() {
        return white;
    }

    public int getBlack() {
        return black;
    }

    public int getColorless() {
        return colorless;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final ManaPoolView that = (ManaPoolView) o;

        if (getRed() != that.getRed()) return false;
        if (getGreen() != that.getGreen()) return false;
        if (getBlue() != that.getBlue()) return false;
        if (getWhite() != that.getWhite()) return false;
        if (getBlack() != that.getBlack()) return false;
        return getColorless() == that.getColorless();

    }

    @Override
    public int hashCode() {
        int result = getRed();
        result = 31 * result + getGreen();
        result = 31 * result + getBlue();
        result = 31 * result + getWhite();
        result = 31 * result + getBlack();
        result = 31 * result + getColorless();
        return result;
    }
}
