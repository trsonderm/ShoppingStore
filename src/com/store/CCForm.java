package com.store;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

interface CCFormListener {
    public void transactionCompleted();
}

public class CCForm extends javax.swing.JFrame {
    List<CCFormListener> listeners = new ArrayList<>();

    ShoppingCart cart;
    /**
     * Creates new form CCForm
     */
    public CCForm() {
        initComponents();
        cart = ShoppingCart.getCart();
        double total = cart.getPriceTotal();
        DecimalFormat df2 = new DecimalFormat("#0.00");
        String totalString = "$" + df2.format(total);
        totalLabel.setText(totalString);
    }
    
    public void addListener(CCFormListener toAdd) {
        listeners.add(toAdd);
    }
    
    public void checkFields () {
        String nameString = nameField.getText();
        String creditCardString = creditCardField.getText();
        
        if (nameString.length() > 0 && creditCardString.length() > 0) {
            submitButton.setEnabled(true);
        }
        else {
            submitButton.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        creditCardField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Credit Card");

        totalLabel.setText("Total: $0.00");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });

        creditCardField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCardFieldActionPerformed(evt);
            }
        });
        creditCardField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creditCardFieldKeyReleased(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setEnabled(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Checkout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameField)
                        .addComponent(creditCardField)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addGap(26, 26, 26)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(creditCardField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(totalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(179, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
        checkFields();
    }//GEN-LAST:event_nameFieldActionPerformed

    private void creditCardFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardFieldActionPerformed
        // TODO add your handling code here:
        checkFields();
    }//GEN-LAST:event_creditCardFieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        Sold sold = Sold.getInstance();
        StoreInventory inventory = StoreInventory.getInstance();
        cart.resetIterator();
        while (cart.hasNext()) {
            Map<String, Object> cartItem = cart.getNext();
            Product product = (Product)cartItem.get("item");
            int quantity = (int)cartItem.get("quantity");
            int itemID = product.sku;
            sold.addItem(product, quantity);
            inventory.decrement(itemID, quantity);
        }
        cart.resetItems();

        for (CCFormListener hl : listeners)
            hl.transactionCompleted();
        this.setVisible(false);
    }//GEN-LAST:event_submitButtonActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        // TODO add your handling code here:
        checkFields();
    }//GEN-LAST:event_nameFieldKeyReleased

    private void creditCardFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditCardFieldKeyReleased
        // TODO add your handling code here:
        checkFields();
    }//GEN-LAST:event_creditCardFieldKeyReleased

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CCForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField creditCardField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
