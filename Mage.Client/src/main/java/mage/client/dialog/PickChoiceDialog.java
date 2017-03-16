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
 * PickNumberDialog.java
 *
 * Created on Feb 25, 2010, 12:03:39 PM
 */

package mage.client.dialog;

import java.awt.Point;
import java.util.Map;
import java.util.UUID;
import javax.swing.JLayeredPane;
import mage.choices.Choice;
import mage.client.MageFrame;
import mage.client.util.SettingsManager;
import mage.client.util.gui.GuiDisplayUtil;
import mage.client.util.gui.MageDialogState;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class PickChoiceDialog extends MageDialog {

    /** Creates new form PickNumberDialog */
    public PickChoiceDialog() {
        initComponents();
        this.setModal(true);
    }
    Choice choice;
    boolean autoSelect;

    public void showDialog(Choice choice, UUID objectId, MageDialogState mageDialogState) {
        this.lblMessage.setText("<html>" + choice.getMessage());
        this.choice = choice;
        this.autoSelect = false;
        btnAutoSelect.setVisible(choice.isKeyChoice());
        
        if (choice.isKeyChoice()){

            ComboItem[] comboItems = new ComboItem[choice.getKeyChoices().size()];
            int count = 0;
            for (Map.Entry<String, String> entry : choice.getKeyChoices().entrySet()) {
                comboItems[count] = new ComboItem(entry.getKey(), entry.getValue());
                count++;
            }
            this.lstChoices.setListData(comboItems);
        } else {
             this.lstChoices.setListData(choice.getChoices().toArray());
        }
        
        MageFrame.getDesktop().add(this, JLayeredPane.PALETTE_LAYER);
        if (mageDialogState != null) {
            mageDialogState.setStateToDialog(this);
            
        } else {
            Point centered = SettingsManager.instance.getComponentPosition(getWidth(), getHeight());
            this.setLocation(centered.x, centered.y);
            GuiDisplayUtil.keepComponentInsideScreen(centered.x, centered.y, this);
        }
        

        this.setVisible(true);
    }

    public boolean isAutoSelect() {
        return autoSelect;
    }

    public void setChoice() {
        if (this.lstChoices.getSelectedValue() == null) {
            choice.clearChoice();
        }
        
        if (choice.isKeyChoice()) {
            ComboItem item = (ComboItem)this.lstChoices.getSelectedValue();
            if (item != null) {
                choice.setChoiceByKey(item.getValue());
            } else {
                choice.clearChoice();
            }
        } else {
            choice.setChoice((String)this.lstChoices.getSelectedValue());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAutoSelect = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstChoices = new javax.swing.JList();
        lblMessage = new javax.swing.JLabel();

        setResizable(true);
        setMinimumSize(new java.awt.Dimension(280, 200));
        setName(""); // NOI18N

        btnAutoSelect.setText("Auto select");
        btnAutoSelect.setToolTipText("If you select an effect with \"Auto select\", this effect will be selected the next time automatically first.");
        btnAutoSelect.addActionListener(evt -> btnAutoSelectActionPerformed(evt));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(evt -> btnCancelActionPerformed(evt));

        btnOk.setText("OK");
        btnOk.addActionListener(evt -> btnOkActionPerformed(evt));

        lstChoices.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstChoices);

        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMessage.setText("message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAutoSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(lblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOk)
                    .addComponent(btnAutoSelect))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        setChoice();
        this.hideDialog();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.lstChoices.clearSelection();
        this.choice.clearChoice();
        this.hideDialog();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAutoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoSelectActionPerformed
        this.autoSelect = true;
        setChoice();
        this.hideDialog();
    }//GEN-LAST:event_btnAutoSelectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoSelect;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JList lstChoices;
    // End of variables declaration//GEN-END:variables

}
  class ComboItem {

        private final String value;
        private final String label;

        public ComboItem(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getValue() {
            return this.value;
        }

        public String getLabel() {
            return this.label;
        }

        @Override
        public String toString() {
            return label;
        }
    }