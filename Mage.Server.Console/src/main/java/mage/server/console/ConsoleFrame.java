/*
* Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
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
 * ConsoleFrame.java
 *
 * Created on May 13, 2011, 2:39:10 PM
 */

package mage.server.console;

import java.util.prefs.Preferences;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import mage.server.console.remote.Session;
import mage.utils.MageVersion;
import org.apache.log4j.Logger;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ConsoleFrame extends javax.swing.JFrame {

    private final static Logger logger = Logger.getLogger(ConsoleFrame.class);

    private static Session session;
    private ConnectDialog connectDialog;
    private static Preferences prefs = Preferences.userNodeForPackage(ConsoleFrame.class);
	private final static MageVersion version = new MageVersion(0, 7, 4, "beta");

    /**
     * @return the session
     */
    public static Session getSession() {
        return session;
    }

    public static Preferences getPreferences() {
        return prefs;
    }

	public static MageVersion getVersion() {
		return version;
	}

	/** Creates new form ConsoleFrame */
    public ConsoleFrame() {
		initComponents();
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			session = new Session(this);
			connectDialog = new ConnectDialog();
		} catch (Exception ex) {
			logger.fatal("", ex);
		}
    }

   public boolean connect(String password, String serverName, int port) {
        if (session.connect(password, serverName, port)) {
			this.consolePanel1.start();
			return true;
		}
		return false;
    }

	public boolean connect(String password, String serverName, int port, String proxyServer, int proxyPort) {
        if (session.connect(password, serverName, port, proxyServer, proxyPort)) {
			this.consolePanel1.start();
			return true;
		}
		return false;
    }

	public void setStatusText(String status) {
        this.lblStatus.setText(status);
    }

	public void enableButtons() {
        btnConnect.setEnabled(true);
        btnConnect.setText("Disconnect");
    }

    public void disableButtons() {
        btnConnect.setEnabled(true);
        btnConnect.setText("Connect");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnConnect = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        consolePanel1 = new mage.server.console.ConsolePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnConnect.setText("Connect");
        btnConnect.setFocusable(false);
        btnConnect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConnect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });
        jToolBar1.add(btnConnect);

        lblStatus.setText("Not Connected");
        jToolBar1.add(Box.createHorizontalGlue());
        jToolBar1.add(lblStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
            .addComponent(consolePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(consolePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        if (session.isConnected()) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to disconnect?", "Confirm disconnect", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.consolePanel1.stop();
                session.disconnect();
            }
        } else {
            connectDialog.showDialog(this);
        }
	}//GEN-LAST:event_btnConnectActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsoleFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private mage.server.console.ConsolePanel consolePanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables

}
