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
 * PlayerPanel.java
 *
 * Created on Nov 18, 2009, 3:01:31 PM
 */
package mage.client.unusedFiles;
//package mage.client.game;

import java.awt.Color;
import java.util.UUID;
import mage.client.MageFrame;
import mage.client.cards.BigCard;
import mage.client.dialog.ShowCardsDialog;
import mage.remote.Session;
import mage.view.PlayerView;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class PlayerPanel extends javax.swing.JPanel {

    private UUID playerId;
    private UUID gameId;
    private Session session;
    private PlayerView player;

    private ShowCardsDialog graveyard;
    private BigCard bigCard;

    /**
     * Creates new form PlayerPanel
     */
    public PlayerPanel() {
        initComponents();
    }

    public void init(UUID gameId, UUID playerId, BigCard bigCard) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.bigCard = bigCard;
        session = MageFrame.getSession();
    }

    public void update(PlayerView player) {
        this.player = player;
        this.txtLife.setText(Integer.toString(player.getLife()));
        this.txtHand.setText(Integer.toString(player.getHandCount()));
        this.txtLibrary.setText(Integer.toString(player.getLibraryCount()));
        this.btnGrave.setText(Integer.toString(player.getGraveyard().size()));
        this.btnPlayerName.setText(player.getName());
        if (player.isActive()) {
            this.btnPlayerName.setBackground(Color.DARK_GRAY);
        } else if (player.hasLeft()) {
            this.btnPlayerName.setBackground(Color.RED);
        } else {
            this.btnPlayerName.setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlayerName = new javax.swing.JButton();
        lblLife = new javax.swing.JLabel();
        lblLibrary = new javax.swing.JLabel();
        lblHand = new javax.swing.JLabel();
        txtLife = new javax.swing.JLabel();
        txtLibrary = new javax.swing.JLabel();
        txtHand = new javax.swing.JLabel();
        lblGrave = new javax.swing.JLabel();
        btnGrave = new javax.swing.JButton();

        setName("Form"); // NOI18N

        btnPlayerName.setText("Player Name"); // NOI18N
        btnPlayerName.setName("btnPlayerName"); // NOI18N
        btnPlayerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerNameActionPerformed(evt);
            }
        });

        lblLife.setLabelFor(txtLife);
        lblLife.setText("Life:"); // NOI18N
        lblLife.setName("lblLife"); // NOI18N

        lblLibrary.setLabelFor(txtLibrary);
        lblLibrary.setText("Library:"); // NOI18N
        lblLibrary.setName("lblLibrary"); // NOI18N

        lblHand.setLabelFor(txtHand);
        lblHand.setText("Hand:"); // NOI18N
        lblHand.setName("lblHand"); // NOI18N

        txtLife.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLife.setName("txtLife"); // NOI18N

        txtLibrary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLibrary.setName("txtLibrary"); // NOI18N

        txtHand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtHand.setName("txtHand"); // NOI18N

        lblGrave.setLabelFor(btnGrave);
        lblGrave.setText("Grave:"); // NOI18N
        lblGrave.setName("lblGrave"); // NOI18N

        btnGrave.setName("btnGrave"); // NOI18N
        btnGrave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLife, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(lblGrave, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(lblHand, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(lblLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLife, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(txtLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(txtHand, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnGrave, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLife, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLife, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHand, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                    .addComponent(lblHand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGrave)
                    .addComponent(btnGrave, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerNameActionPerformed
        session.sendPlayerUUID(gameId, playerId);
    }//GEN-LAST:event_btnPlayerNameActionPerformed

    private void btnGraveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraveActionPerformed
        if (graveyard == null) {
            graveyard = new ShowCardsDialog();
        }
        graveyard.loadCards(player.getName() + " graveyard", player.getGraveyard(), bigCard, gameId, false, null, null, null);
    }//GEN-LAST:event_btnGraveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGrave;
    private javax.swing.JButton btnPlayerName;
    private javax.swing.JLabel lblGrave;
    private javax.swing.JLabel lblHand;
    private javax.swing.JLabel lblLibrary;
    private javax.swing.JLabel lblLife;
    private javax.swing.JLabel txtHand;
    private javax.swing.JLabel txtLibrary;
    private javax.swing.JLabel txtLife;
    // End of variables declaration//GEN-END:variables

}
