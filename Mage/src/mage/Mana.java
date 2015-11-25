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
package mage;

import java.io.Serializable;
import java.util.Objects;

import mage.constants.ColoredManaSymbol;
import mage.constants.ManaType;
import static mage.constants.ManaType.COLORLESS;
import mage.filter.FilterMana;
import mage.util.Copyable;
import mage.util.ThreadLocalStringBuilder;
import org.apache.log4j.Logger;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class Mana implements Comparable<Mana>, Serializable, Copyable<Mana> {

    private static final transient Logger logger = Logger.getLogger(Mana.class);


    protected int red;
    protected int green;
    protected int blue;
    protected int white;
    protected int black;
    protected int colorless;
    protected int any;
    protected boolean flag = false;

    public static final Mana RedMana = RedMana(1);
    public static final Mana GreenMana = GreenMana(1);
    public static final Mana BlueMana = BlueMana(1);
    public static final Mana WhiteMana = WhiteMana(1);
    public static final Mana BlackMana = BlackMana(1);
    public static final Mana ColorlessMana = ColorlessMana(1);

    public Mana() {
    }

    public Mana(final Mana mana) {
        Objects.requireNonNull(mana, "The passed in mana can not be null");
        this.red = mana.red;
        this.green = mana.green;
        this.blue = mana.blue;
        this.white = mana.white;
        this.black = mana.black;
        this.colorless = mana.colorless;
        this.any = mana.any;
        this.flag = mana.flag;
    }

    public Mana(final ColoredManaSymbol color) {
        Objects.requireNonNull(color, "The passed in ColoredManaSymbol can not be null");
        switch (color) {
            case G:
                green = 1;
                break;
            case R:
                red = 1;
                break;
            case B:
                black = 1;
                break;
            case U:
                blue = 1;
                break;
            case W:
                white = 1;
                break;
        }
    }

    public static Mana RedMana(int num) {
        return new Mana(notNegative(num, "Red"), 0, 0, 0, 0, 0, 0);
    }

    public static Mana GreenMana(int num) {
        return new Mana(0, notNegative(num, "Green"), 0, 0, 0, 0, 0);
    }

    public static Mana BlueMana(int num) {
        return new Mana(0, 0, notNegative(num, "Blue"), 0, 0, 0, 0);
    }

    public static Mana WhiteMana(int num) {
        return new Mana(0, 0, 0, notNegative(num, "White"), 0, 0, 0);
    }

    public static Mana BlackMana(int num) {
        return new Mana(0, 0, 0, 0, notNegative(num, "Black"), 0, 0);
    }

    public static Mana ColorlessMana(int num) {
        return new Mana(0, 0, 0, 0, 0, notNegative(num, "Colorless"), 0);
    }

    public Mana(int red, int green, int blue, int white, int black, int colorless, int any) {
        this.red = notNegative(red, "Red");
        this.green = notNegative(green, "Green");
        this.blue = notNegative(blue, "Blue");
        this.white = notNegative(white, "White");
        this.black = notNegative(black, "Black");
        this.colorless = notNegative(colorless, "Colorless");
        this.any = notNegative(any, "Any");
    }

    public void add(Mana mana) {
        red += mana.getRed();
        green += mana.getGreen();
        blue += mana.getBlue();
        white += mana.getWhite();
        black += mana.getBlack();
        colorless += mana.getColorless();
        any += mana.getAny();
    }

    public void increaseRed() {
        red++;
    }

    public void increaseGreen() {
        green++;
    }

    public void increaseBlue() {
        blue++;
    }

    public void increaseWhite() {
        white++;
    }

    public void increaseBlack() {
        black++;
    }

    public void increaseColorless() {
        colorless++;
    }

    /**
     * Subtracts the passed in mana values from this instance. Will not
     * reduce this instances mana below 0.
     *
     * @param mana mana values to subtract
     */
    public void subtract(final Mana mana) throws ArithmeticException {
        red -= mana.red;
        green -= mana.green;
        blue -= mana.blue;
        white -= mana.white;
        black -= mana.black;
        colorless -= mana.colorless;
        any -= mana.any;
    }


    /**
     * Subtracts the passed in mana values from this instance. Will not
     * reduce this instances mana below 0. The difference between this and
     * {@code subtract()} is that if we do not have the available colorlesss
     * mana to pay, we take mana from our colored mana pools.
     *
     * @param mana mana values to subtract
     * @throws ArithmeticException thrown if there is not enough available
     *                             colored mana to make up the negative colorless cost
     */
    public void subtractCost(final Mana mana) throws ArithmeticException {
        red -= mana.red;
        green -= mana.green;
        blue -= mana.blue;
        white -= mana.white;
        black -= mana.black;
        any -= mana.any;
        colorless -= mana.colorless;

        while (colorless < 0) {
            int oldColorless = colorless;
            if (red > 0) {
                red--;
                colorless++;
                continue;
            }
            if (green > 0) {
                green--;
                colorless++;
                continue;
            }
            if (blue > 0) {
                blue--;
                colorless++;
                continue;
            }
            if (white > 0) {
                white--;
                colorless++;
                continue;
            }
            if (black > 0) {
                black--;
                colorless++;
            }
            if (any > 0) {
                any--;
                colorless++;
            }
            if (oldColorless == colorless) {
                throw new ArithmeticException("Not enough mana to pay colorless");
            }
        }
    }

    public int count() {
        return red + green + blue + white + black + colorless + any;
    }

    public int countColored() {
        return red + green + blue + white + black + any;
    }

    public int count(FilterMana filter) {
        if (filter == null) {
            return count();
        }
        int count = 0;
        if (filter.isBlack()) {
            count += black;
        }
        if (filter.isBlue()) {
            count += blue;
        }
        if (filter.isWhite()) {
            count += white;
        }
        if (filter.isGreen()) {
            count += green;
        }
        if (filter.isRed()) {
            count += red;
        }
        if (filter.isColorless()) {
            count += colorless;
        }
        return count;
    }

    public void clear() {
        red = 0;
        green = 0;
        blue = 0;
        white = 0;
        black = 0;
        colorless = 0;
        any = 0;
    }

    @Override
    public String toString() {
        StringBuilder sbMana = new StringBuilder();
        if (colorless > 0) {
            sbMana.append("{").append(Integer.toString(colorless)).append("}");
        }
        for (int i = 0; i < red; i++) {
            sbMana.append("{R}");
        }
        for (int i = 0; i < green; i++) {
            sbMana.append("{G}");
        }
        for (int i = 0; i < blue; i++) {
            sbMana.append("{U}");
        }
        for (int i = 0; i < white; i++) {
            sbMana.append("{W}");
        }
        for (int i = 0; i < black; i++) {
            sbMana.append("{B}");
        }
        for (int i = 0; i < any; i++) {
            sbMana.append("{Any}");
        }
        return sbMana.toString();
    }

    private static final transient ThreadLocalStringBuilder threadLocalBuilder = new ThreadLocalStringBuilder(10);

    @Override
    public Mana copy() {
        return new Mana(this);
    }

    public boolean enough(Mana avail) {
        Mana compare = avail.copy();
        compare.subtract(this);
        if (compare.red < 0) {
            compare.any = compare.getAny() + compare.getRed();
            if (compare.any < 0) {
                return false;
            }
            compare.red =0;
        }
        if (compare.green < 0) {
            compare.any = compare.getAny() + compare.getGreen();
            if (compare.any < 0) {
                return false;
            }
            compare.green = 0;
        }
        if (compare.blue < 0) {
            compare.any = compare.getAny() + compare.getBlue();
            if (compare.any < 0) {
                return false;
            }
            compare.blue = 0;
        }
        if (compare.black < 0) {
            compare.any = compare.getAny() + compare.getBlack();
            if (compare.any < 0) {
                return false;
            }
            compare.black = 0;
        }
        if (compare.white < 0) {
            compare.any = compare.getAny() + compare.getWhite();
            if (compare.any < 0) {
                return false;
            }
            compare.white = 0;
        }
        if (compare.colorless < 0) {
            int remaining = compare.red + compare.green + compare.black + compare.blue + compare.white + compare.any;
            if (compare.colorless + remaining < 0) {
                return false;
            }
        }
        return true;
    }

    public Mana needed(Mana avail) {
        Mana compare = avail.copy();
        compare.subtract(this);
        if (compare.red < 0 && compare.any > 0) {
            int diff = Math.min(compare.any, Math.abs(compare.red));
            compare.any = compare.getAny() - diff;
            compare.red = compare.getRed() + diff;
        }
        if (compare.green < 0 && compare.any > 0) {
            int diff = Math.min(compare.any, Math.abs(compare.green));
            compare.any = compare.any - diff;
            compare.green = compare.green + diff;
        }
        if (compare.blue < 0 && compare.any > 0) {
            int diff = Math.min(compare.any, Math.abs(compare.blue));
            compare.any = compare.any - diff;
            compare.blue = compare.blue + diff;
        }
        if (compare.black < 0 && compare.any > 0) {
            int diff = Math.min(compare.any, Math.abs(compare.black));
            compare.any = compare.any - diff;
            compare.black = compare.getBlack() + diff;
        }
        if (compare.white < 0 && compare.any > 0) {
            int diff = Math.min(compare.any, Math.abs(compare.white));
            compare.any = compare.any - diff;
            compare.white = compare.white + diff;
        }
        if (compare.colorless < 0) {
            int remaining = 0;
            remaining += Math.min(0, compare.red);
            remaining += Math.min(0, compare.white);
            remaining += Math.min(0, compare.green);
            remaining += Math.min(0, compare.black);
            remaining += Math.min(0, compare.blue);
            remaining += Math.min(0, compare.any);
            if (remaining > 0) {
                int diff = Math.min(remaining, Math.abs(compare.colorless));
                compare.colorless = compare.colorless + diff;
            }
        }
        Mana needed = new Mana();
        if (compare.red < 0) {
            needed.red = Math.abs(compare.red);
        }
        if (compare.white < 0) {
            needed.white = Math.abs(compare.white);
        }
        if (compare.green < 0) {
            needed.green = Math.abs(compare.green);
        }
        if (compare.black < 0) {
            needed.black = Math.abs(compare.black);
        }
        if (compare.blue < 0) {
            needed.blue = Math.abs(compare.blue);
        }
        if (compare.colorless < 0) {
            needed.colorless = Math.abs(compare.colorless);
        }
        return needed;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = notNegative(red, "Red");
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = notNegative(green, "Green");
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = notNegative(blue, "Blue");
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = notNegative(white, "White");
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = notNegative(black, "Black");
    }

    public int getColorless() {
        return colorless;
    }

    public void setColorless(int colorless) {
        this.colorless = notNegative(colorless, "Colorless");
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = notNegative(any, "Any");
    }

    @Override
    public int compareTo(Mana o) {
        return this.count() - o.count();
    }

    /**
     *
     * @param mana
     * @return true if this contains any values that mana has
     */
    public boolean contains(Mana mana) {
        if (mana.black > 0 && this.black > 0) {
            return true;
        }
        if (mana.blue > 0 && this.blue > 0) {
            return true;
        }
        if (mana.red > 0 && this.red > 0) {
            return true;
        }
        if (mana.white > 0 && this.white > 0) {
            return true;
        }
        if (mana.green > 0 && this.green > 0) {
            return true;
        }
        if (mana.colorless > 0 && this.count() > 0) {
            return true;
        }

        return false;
    }

    public int getColor(ColoredManaSymbol color) {
        if (color.equals(ColoredManaSymbol.G)) {
            return getGreen();
        }
        if (color.equals(ColoredManaSymbol.R)) {
            return getRed();
        }
        if (color.equals(ColoredManaSymbol.B)) {
            return getBlack();
        }
        if (color.equals(ColoredManaSymbol.U)) {
            return getBlue();
        }
        if (color.equals(ColoredManaSymbol.W)) {
            return getWhite();
        }
        return 0;
    }

    public int get(ManaType manaType) {
        switch (manaType) {
            case BLACK:
                return black;
            case BLUE:
                return blue;
            case GREEN:
                return green;
            case RED:
                return red;
            case WHITE:
                return white;
            case COLORLESS:
                return colorless;
        }
        return 0;
    }

    public void set(ManaType manaType, int amount) {
        switch (manaType) {
            case BLACK:
                black = amount;
                break;
            case BLUE:
                blue = amount;
                break;
            case GREEN:
                green = amount;
                break;
            case RED:
                red = amount;
                break;
            case WHITE:
                white = amount;
                break;
            case COLORLESS:
                colorless = amount;
                break;
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setToMana(Mana mana) {
        this.any = mana.any;
        this.red = mana.red;
        this.green = mana.green;
        this.white = mana.white;
        this.blue = mana.blue;
        this.black = mana.black;
        this.colorless = mana.colorless;
    }

    public boolean equalManaValue(Mana mana) {
        return this.any == mana.any
                && this.red == mana.red
                && this.green == mana.green
                && this.white == mana.white
                && this.blue == mana.blue
                && this.black == mana.black
                && this.colorless == mana.colorless;
    }

    /**
     * Don't takes any mana into account to be usable in calculating available
     * mana
     *
     * @param mana
     * @return
     */
    public boolean includesMana(Mana mana) {
        return this.green >= mana.green
                && this.blue >= mana.blue
                && this.white >= mana.white
                && this.black >= mana.black
                && this.red >= mana.red
                && (this.colorless >= mana.colorless
                || this.countColored() >= mana.countColored() + mana.colorless);

    }

    /**
     * Returns the mana that is more colored or has a greater amount but does
     * not contain one less mana in any color but colorless if you call with
     * {1}{W}{R} and {G}{W}{R} you get back {G}{W}{R} if you call with {G}{W}{R}
     * and {G}{W}{R} you get back {G}{W}{R} if you call with {G}{W}{B} and
     * {G}{W}{R} you get back null
     *
     * @param mana1
     * @param mana2
     * @return
     */
    public static Mana getMoreValuableMana(Mana mana1, Mana mana2) {
        Mana moreMana;
        Mana lessMana;
        if (mana2.countColored() > mana1.countColored() || mana2.getAny() > mana1.getAny() || mana2.count() > mana1.count()) {
            moreMana = mana2;
            lessMana = mana1;
        } else {
            moreMana = mana1;
            lessMana = mana2;
        }
        if (lessMana.getWhite() > moreMana.getWhite()
                || lessMana.getRed() > moreMana.getRed()
                || lessMana.getGreen() > moreMana.getGreen()
                || lessMana.getBlue() > moreMana.getBlue()
                || lessMana.getBlack() > moreMana.getBlack()
                || lessMana.getAny() > moreMana.getAny()) {
            return null;
        }
        return moreMana;
    }

    public int getDifferentColors() {
        int count = 0;
        if (blue > 0) {
            count++;
        }
        if (black > 0) {
            count++;
        }
        if (green > 0) {
            count++;
        }
        if (white > 0) {
            count++;
        }
        if (red > 0) {
            count++;
        }
        return count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mana mana = (Mana) o;

        if (red != mana.red) return false;
        if (green != mana.green) return false;
        if (blue != mana.blue) return false;
        if (white != mana.white) return false;
        if (black != mana.black) return false;
        if (colorless != mana.colorless) return false;
        if (any != mana.any) return false;
        return flag == mana.flag;

    }

    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        result = 31 * result + white;
        result = 31 * result + black;
        result = 31 * result + colorless;
        result = 31 * result + any;
        result = 31 * result + (flag ? 1 : 0);
        return result;
    }

    private static int notNegative(int value, final String name) {
        if (value < 0) {
            logger.info(name + " can not be less than 0. Passed in: " + value + " Defaulting to 0.");
            value = 0;
        }

        return value;
    }
}
