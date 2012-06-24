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

/*
 * NewTournamentDialog.java
 *
 * Created on Jan 28, 2011, 12:15:56 PM
 */

package mage.client.dialog;

import mage.Constants.MultiplayerAttackOption;
import mage.Constants.RangeOfInfluence;
import mage.cards.ExpansionSet;
import mage.client.MageFrame;
import mage.client.table.TournamentPlayerPanel;
import mage.game.draft.DraftOptions;
import mage.game.draft.DraftOptions.TimingOption;
import mage.game.tournament.LimitedOptions;
import mage.game.tournament.TournamentOptions;
import mage.remote.Session;
import mage.sets.Sets;
import mage.view.TableView;
import mage.view.TournamentTypeView;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class NewTournamentDialog extends MageDialog {

    private final static Logger logger = Logger.getLogger(NewTournamentDialog.class);

    private TableView table;
    private UUID playerId;
    private UUID roomId;
    private Session session;
    private List<TournamentPlayerPanel> players = new ArrayList<TournamentPlayerPanel>();
    private List<JComboBox> packs = new ArrayList<JComboBox>();

    /** Creates new form NewTournamentDialog */
    public NewTournamentDialog() {
        initComponents();
        txtName.setText("Tournament");
    }

    public void showDialog(UUID roomId) {
        this.roomId = roomId;
        session = MageFrame.getSession();
        this.txtPlayer1Name.setText(session.getUserName());
        cbTournamentType.setModel(new DefaultComboBoxModel(session.getTournamentTypes().toArray()));
        cbDraftTiming.setModel(new DefaultComboBoxModel(DraftOptions.TimingOption.values()));
        this.setModal(true);
        setTournamentOptions();
        this.setLocation(150, 100);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbTournamentType = new javax.swing.JComboBox();
        spnNumPlayers = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlPacks = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlayer1Name = new javax.swing.JTextField();
        pnlOtherPlayers = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        pnlDraftOptions = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbDraftTiming = new javax.swing.JComboBox();

        setTitle("New Tournament");

        jLabel1.setText("Tournament Type:");

        cbTournamentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTournamentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTournamentTypeActionPerformed(evt);
            }
        });

        spnNumPlayers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnNumPlayersStateChanged(evt);
            }
        });

        jLabel2.setText("Players:");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pnlPacks.setLayout(new java.awt.GridLayout(0, 1, 2, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Player 1 (You)");

        jLabel4.setText("Name:");

        txtPlayer1Name.setEditable(false);

        pnlOtherPlayers.setLayout(new java.awt.GridLayout(0, 1, 2, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlOtherPlayers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlayer1Name, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPlayer1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlOtherPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Packs");

        lblName.setText("Name:");

        jLabel6.setText("Timing:");

        cbDraftTiming.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlDraftOptionsLayout = new javax.swing.GroupLayout(pnlDraftOptions);
        pnlDraftOptions.setLayout(pnlDraftOptionsLayout);
        pnlDraftOptionsLayout.setHorizontalGroup(
            pnlDraftOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDraftOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDraftTiming, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDraftOptionsLayout.setVerticalGroup(
            pnlDraftOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDraftOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cbDraftTiming)
                .addComponent(jLabel6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPacks, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnNumPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDraftOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addComponent(cbTournamentType, javax.swing.GroupLayout.Alignment.LEADING, 0, 470, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTournamentType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPacks, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnNumPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(pnlDraftOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbTournamentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTournamentTypeActionPerformed
        setTournamentOptions();
    }//GEN-LAST:event_cbTournamentTypeActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
        TournamentOptions tOptions = new TournamentOptions(this.txtName.getText());
        tOptions.setTournamentType(tournamentType.getName());
        tOptions.getPlayerTypes().add("Human");
        for (TournamentPlayerPanel player: players) {
            tOptions.getPlayerTypes().add((String) player.getPlayerType().getSelectedItem());
        }
        if (tournamentType.isDraft()) {
            DraftOptions options = new DraftOptions();
            options.setDraftType("");
            options.setTiming((TimingOption) this.cbDraftTiming.getSelectedItem());
            tOptions.setLimitedOptions(options);
        }
        if (tournamentType.isLimited()) {
            if (tOptions.getLimitedOptions() == null)
                tOptions.setLimitedOptions(new LimitedOptions());
            for (JComboBox pack: packs) {
                tOptions.getLimitedOptions().getSetCodes().add(((ExpansionSet) pack.getSelectedItem()).getCode());
            }
        }
        tOptions.getMatchOptions().setDeckType("Limited");
        tOptions.getMatchOptions().setWinsNeeded(2);
        tOptions.getMatchOptions().setAttackOption(MultiplayerAttackOption.LEFT);
        tOptions.getMatchOptions().setRange(RangeOfInfluence.ALL);
        tOptions.getMatchOptions().setLimited(true);
        table = session.createTournamentTable(roomId, tOptions);
        if (table == null) {
            JOptionPane.showMessageDialog(MageFrame.getDesktop(), "Error creating table.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (session.joinTournamentTable(roomId, table.getTableId(), this.txtPlayer1Name.getText(), "Human", 1)) {
            for (TournamentPlayerPanel player: players) {
                if (!player.getPlayerType().equals("Human")) {
                    if (!player.joinTournamentTable(roomId, table.getTableId())) {
                        JOptionPane.showMessageDialog(MageFrame.getDesktop(), "Error joining tournament.", "Error", JOptionPane.ERROR_MESSAGE);
                        session.removeTable(roomId, table.getTableId());
                        table = null;
                        return;
                    }
                }
            }
            this.hideDialog();
            return;
        }
        JOptionPane.showMessageDialog(MageFrame.getDesktop(), "Error joining tournament.", "Error", JOptionPane.ERROR_MESSAGE);
        session.removeTable(roomId, table.getTableId());
        table = null;
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.table = null;
        this.playerId = null;
        this.hideDialog();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void spnNumPlayersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnNumPlayersStateChanged
        int numPlayers = (Integer)this.spnNumPlayers.getValue() - 1;
        createPlayers(numPlayers);
    }//GEN-LAST:event_spnNumPlayersStateChanged

    private void setTournamentOptions() {
        TournamentTypeView tournamentType = (TournamentTypeView) cbTournamentType.getSelectedItem();
        this.spnNumPlayers.setModel(new SpinnerNumberModel(tournamentType.getMinPlayers(), tournamentType.getMinPlayers(), tournamentType.getMaxPlayers(), 1));
        this.spnNumPlayers.setEnabled(tournamentType.getMinPlayers() != tournamentType.getMaxPlayers());
        createPlayers(tournamentType.getMinPlayers() - 1);
        if (tournamentType.isLimited()) {
            this.pnlPacks.setVisible(true);
            createPacks(tournamentType.getNumBoosters());
        }
        else {
            this.pnlPacks.setVisible(false);
        }
        this.pnlDraftOptions.setVisible(tournamentType.isDraft());
    }

    private void createPacks(int numPacks) {
        while (packs.size() > numPacks) {
            pnlPacks.remove(packs.get(packs.size() - 1));
            packs.remove(packs.size() - 1);
        }
        while (packs.size() < numPacks) {
            JComboBox pack = new JComboBox();
            pack.setModel(new DefaultComboBoxModel(Sets.getInstance().getSortedByReleaseDate()));
            pnlPacks.add(pack);
            packs.add(pack);
            pack.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    packActionPerformed(evt);
                }
            });
        }
        this.pack();
        this.revalidate();
        this.repaint();
    }

    private void packActionPerformed(java.awt.event.ActionEvent evt) {
        boolean start = false;
        int selectedIndex = 0;
        for (JComboBox pack: packs) {
            if (!start) {
                if (evt.getSource().equals(pack)) {
                    start = true;
                    selectedIndex = pack.getSelectedIndex();
                }
            }
            else {
                pack.setSelectedIndex(selectedIndex);
            }
        }
    }

    private void createPlayers(int numPlayers) {
        if (numPlayers > players.size()) {
            while (players.size() != numPlayers) {
                TournamentPlayerPanel playerPanel = new TournamentPlayerPanel();
                playerPanel.init(players.size() + 2);
                players.add(playerPanel);
            }
        }
        else if (numPlayers < players.size()) {
            while (players.size() != numPlayers) {
                players.remove(players.size() - 1);
            }
        }
        drawPlayers();
    }

    private void drawPlayers() {
        this.pnlOtherPlayers.removeAll();
        for (TournamentPlayerPanel panel: players) {
            this.pnlOtherPlayers.add(panel);
            panel.getPlayerType().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    playerActionPerformed(evt);
                }
            });
        }
        this.pack();
        this.revalidate();
        this.repaint();
    }

    private void playerActionPerformed(java.awt.event.ActionEvent evt) {
        boolean start = false;
        int selectedIndex = 0;
        for (TournamentPlayerPanel player: players) {
            if (!start) {
                if (evt.getSource().equals(player.getPlayerType())) {
                    start = true;
                    selectedIndex = player.getPlayerType().getSelectedIndex();
                }
            }
            else {
                player.getPlayerType().setSelectedIndex(selectedIndex);
            }
        }
    }

    public TableView getTable() {
        return table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox cbDraftTiming;
    private javax.swing.JComboBox cbTournamentType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel pnlDraftOptions;
    private javax.swing.JPanel pnlOtherPlayers;
    private javax.swing.JPanel pnlPacks;
    private javax.swing.JSpinner spnNumPlayers;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPlayer1Name;
    // End of variables declaration//GEN-END:variables

}
