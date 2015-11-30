package com.store;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

interface CartListener {
    public void cartExited();
}

public class CartView extends javax.swing.JFrame implements PaymentListener {
    List<CartListener> listeners = new ArrayList<CartListener>();
    
    StoreInventory inventory;
    ShoppingCart cart;
    int productId;

    public CartView() {
        initComponents();
        inventory = StoreInventory.getInstance();
        cart = ShoppingCart.getCart();
        productId = 0;
        updateShoppingCartView();
    }
    
    public void addListener(CartListener toAdd) {
        listeners.add(toAdd);
    }
    
    private void updateShoppingCartView() {
        populateTable();
        updateTotal();
        if (cartTable.getRowCount() > 0)
            checkoutButton.setEnabled(true);
        else
            checkoutButton.setEnabled(false);

    }
    
    private void updateTotal() {
        double total = cart.getPriceTotal();
        DecimalFormat df2 = new DecimalFormat("#0.00");
        String totalString = "$" + df2.format(total);
        totalLabel.setText(totalString);
    }
    
    private void populateTable() {
        Object[][] cartListing = cart.getListing();
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            cartListing,
            new String [] {
                "ID", "Item", "Price", "Quantity", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        checkoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        cartTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cartTablePropertyChange(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("Total: $0.00");

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/com/store/Alarm-Arrow-Down-icon.png"))); // NOI18N
        downButton.setEnabled(false);
        downButton.setPreferredSize(new java.awt.Dimension(40, 40));
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/com/store/Alarm-Arrow-Up-icon.png"))); // NOI18N
        upButton.setEnabled(false);
        upButton.setPreferredSize(new java.awt.Dimension(40, 40));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        checkoutButton.setText("Check Out");
        checkoutButton.setEnabled(false);
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkoutButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(cartTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartTable, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(downButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        for (CartListener hl : listeners)
            hl.cartExited();
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed
    
    private void cartTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cartTablePropertyChange

    }//GEN-LAST:event_cartTablePropertyChange

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        int row = cartTable.getSelectedRow();
       // System.out.println("Row:" + row);
        if (row >= 0) {
            productId = Integer.parseInt(cartTable.getValueAt(row, 0).toString());
        //    System.out.println("currentItemID:" + productId);
            updateUpDownButtons();
        }
    }//GEN-LAST:event_cartTableMouseClicked

    private void updateUpDownButtons() {
        int quantityInInventory = inventory.retrieveQuantity(productId);
        int quantityInCart = cart.retrieveQuantity(productId);
        
        int quantityAvailable = quantityInInventory - quantityInCart;
        
        if (quantityInCart > 0)
            downButton.setEnabled(true);
        else
            downButton.setEnabled(false);
        
        if (quantityAvailable > 0)
            upButton.setEnabled(true);
        else
            upButton.setEnabled(false);
    }
    
    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        PurchaseForm pForm = new PurchaseForm();
        pForm.addListener(this);
        pForm.setVisible(true);
    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        cart.decrement(productId, 1);
        updateUpDownButtons();
        updateShoppingCartView();
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        cart.increment(productId, 1);
        updateUpDownButtons();
        updateShoppingCartView();
    }//GEN-LAST:event_upButtonActionPerformed

    @Override
    public void finished() {
        updateShoppingCartView();
    }
    
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
            java.util.logging.Logger.getLogger(CartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CartView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JButton downButton;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
