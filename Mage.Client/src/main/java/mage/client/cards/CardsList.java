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

/*
 * CardsList.java
 *
 * Created on Dec 18, 2009, 10:40:12 AM
 */

package mage.client.cards;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Beans;
import java.util.UUID;

import mage.cards.MageCard;
import mage.client.plugins.impl.Plugins;
import mage.client.util.Config;
import mage.client.util.Event;
import mage.client.util.Listener;
import mage.view.CardView;
import mage.view.CardsView;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class CardsList extends javax.swing.JPanel implements MouseListener {

	protected CardEventSource cardEventSource = new CardEventSource();

    /** Creates new form Cards */
    public CardsList() {
        initComponents();
        jScrollPane1.setOpaque(false);
        cardArea.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
    }

	public void loadCards(CardsView showCards, BigCard bigCard, UUID gameId) {
		//FIXME: why we remove all cards? for performance it's better to merge changes
		cardArea.removeAll();
		if (showCards != null && showCards.size() > 0) {
			Rectangle rectangle = new Rectangle(Config.dimensions.frameWidth, Config.dimensions.frameHeight);
			int count = 0;
			for (CardView card: showCards.values()) {
				addCard(card, bigCard, gameId, rectangle);
				if (count >= 10) {
					rectangle.translate(Config.dimensions.frameWidth, -200);
					count = 0;
				} else {
					rectangle.translate(0, 20);
					count++;
				}
			}
		}
		cardArea.setPreferredSize(new Dimension(Config.dimensions.frameWidth, Config.dimensions.frameHeight + 200));
		cardArea.revalidate();
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}

	private void addCard(CardView card, BigCard bigCard, UUID gameId, Rectangle rectangle) {
		MageCard cardImg = Plugins.getInstance().getMageCard(card, bigCard, Config.dimensions, gameId);
		cardImg.setBounds(rectangle);
		cardArea.add(cardImg);
		cardArea.moveToFront(cardImg);
		cardImg.update(card);
		cardImg.addMouseListener(this);
		cardImg.setCardBounds(rectangle.x, rectangle.y, Config.dimensions.frameWidth, Config.dimensions.frameHeight);
	}
	
	public void addCardEventListener(Listener<Event> listener) {
		cardEventSource.addListener(listener);
	}

	public void clearCardEventListeners() {
		cardEventSource.clearListeners();
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cardArea = new javax.swing.JLayeredPane();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize((!Beans.isDesignTime())?(new Dimension(Config.dimensions.frameWidth, Config.dimensions.frameHeight)):(new Dimension(100, 100)));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(cardArea);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane cardArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume();
			Object obj = e.getSource(); 
			if (obj instanceof Card) {
				cardEventSource.doubleClick(((Card)obj).getCardId(), "double-click");
			} else if (obj instanceof MageCard) {
				cardEventSource.doubleClick(((MageCard)obj).getOriginal().getId(), "double-click");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
