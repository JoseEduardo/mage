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
 * MageDialog.java
 *
 * Created on 15-Dec-2009, 10:28:27 PM
 */
package mage.client.dialog;

import java.awt.AWTEvent;
import java.awt.ActiveEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import java.awt.MenuComponent;
import java.awt.TrayIcon;
import java.awt.event.InvocationEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import mage.client.MageFrame;
import org.apache.log4j.Logger;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class MageDialog extends javax.swing.JInternalFrame {

    private static final Logger LOGGER = Logger.getLogger(MageDialog.class);

    protected boolean modal = false;

    /**
     * Creates new form MageDialog
     */
    public MageDialog() {
        initComponents();
    }

    public void changeGUISize() {

    }

    @Override
    public void show() {
        super.show();
        this.toFront();
        if (modal) {
            this.setClosable(false);
        }
        if (this.modal) {
            startModal();
        }
    }

    @Override
    public void setVisible(boolean value) {
        super.setVisible(value);
        if (value) {
            this.toFront();
        }
        if (modal) {
            this.setClosable(false);
            if (value) {
                startModal();
            } else if (SwingUtilities.isEventDispatchThread()) {
                stopModal();
            } else {
                try {
                    SwingUtilities.invokeAndWait(() -> stopModal());
                } catch (InterruptedException ex) {
                    LOGGER.fatal("MageDialog error", ex);
                } catch (InvocationTargetException ex) {
                    LOGGER.fatal("MageDialog error", ex);
                }
            }
        }
    }

    private synchronized void startModal() {

        try {
            if (SwingUtilities.isEventDispatchThread()) {
                EventQueue theQueue = getToolkit().getSystemEventQueue();
                while (isVisible()) {
                    AWTEvent event = theQueue.getNextEvent();
                    Object source = event.getSource();
                    boolean dispatch = true;

                    // https://github.com/magefree/mage/issues/584 - Let's hope this will fix the Linux window problem
                    if (event.getSource() != null && event.getSource() instanceof TrayIcon && !(event instanceof InvocationEvent)) {
                        return;
                    }
                    if (event instanceof MouseEvent && event.getSource() instanceof Component) {
                        MouseEvent e = (MouseEvent) event;
                        MouseEvent m = SwingUtilities.convertMouseEvent((Component) e.getSource(), e, this);
                        if (!this.contains(m.getPoint()) && e.getID() != MouseEvent.MOUSE_DRAGGED) {
                            dispatch = false;
                        }
                    }

                    if (dispatch) {
                        if (event instanceof ActiveEvent) {
                            ((ActiveEvent) event).dispatch();
                        } else if (source instanceof Component) {
                            ((Component) source).dispatchEvent(event);
                        } else if (source instanceof MenuComponent) {
                            ((MenuComponent) source).dispatchEvent(event);
                        } else {
                            LOGGER.warn("Unable to dispatch: " + event);
                        }
                    }
                }
            } else {
                while (isVisible()) {
                    wait();
                }
            }
        } catch (InterruptedException ignored) {
        }

    }

    private synchronized void stopModal() {
        notifyAll();
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public boolean isModal() {
        return this.modal;
    }

    public void hideDialog() {
        this.setVisible(false);
    }

    public void removeDialog() {
        // avoid memory leak of javax.swing.plaf.nimbus.NimbusStyle$CacheKey
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        //this.setVisible(false);
        // important to set close before removing the JInternalFrame to avoid memory leaks (http://bugs.java.com/view_bug.do?bug_id=7163808)
        try {
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            java.util.logging.Logger.getLogger(MageDialog.class.getName()).log(Level.SEVERE, "setClosed(false) failed", ex);
        }
        MageFrame.getDesktop().remove(this);

    }

    /**
     * Used to set a tooltip text on icon and titel bar
     *
     * used in {@link ExileZoneDialog} and {@link ShowCardsDialog}
     *
     * @param text
     */
    public void setTitelBarToolTip(final String text) {
        desktopIcon.setToolTipText(text); //tooltip on icon
        Component[] children = getComponents();
        if (children != null) {
            for (Component children1 : children) {
                if (children1.getClass().getName().equalsIgnoreCase("javax.swing.plaf.synth.SynthInternalFrameTitlePane")) {
                    ((JComponent) children1).setToolTipText(text); //tooltip on title bar
                    break;
                }
            }
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
