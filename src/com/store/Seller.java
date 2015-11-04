package com.store;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Map;

public class Seller extends javax.swing.JFrame implements AddItemListener {
    
    StoreInventory inventory;
    ShoppingCart cart;
    Sold sold;
    
    String[] inventoryListLabels;
    int currentItemID;

    public Seller() {
        initComponents();
        inventory = StoreInventory.getInstance();
        cart = ShoppingCart.getCart();
        sold = Sold.getInstance();
        
        updateInventoryList();
        updateFinancials();
        
        currentItemID = 0;
    }
    
    private void updateFinancials() {
        double cost = sold.getCostTotal() + inventory.getCostTotal();
        double revenue = sold.getPriceTotal();
        double profit = revenue - cost;
        
        DecimalFormat df2 = new DecimalFormat( "#0.00" );

        costLabel.setText("$" + df2.format(cost));
        revenueLabel.setText("$" + df2.format(revenue));
        
        if (profit < 0)
            profitLabel.setForeground(Color.RED);
        else
            profitLabel.setForeground(Color.GREEN);
        
        profitLabel.setText("$" + df2.format(profit));
    }
    
    public void updateInventoryList() {
        String[] rawInventoryListLabels = new String[inventory.getIteratorCount()];
        int iterator = 0;
        while (inventory.hasNext()) {
            Map<String, Object> inventoryItem = inventory.getNext();
            DecimalFormat df2 = new DecimalFormat( "#0.00" );
            Product product = (Product)inventoryItem.get("product");

            rawInventoryListLabels[iterator] = product.name + " - $" + df2.format(product.price);
            iterator++;
        }
        inventory.resetIterator();
        
        productList.removeAll();
        productList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = rawInventoryListLabels;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        priceLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        downButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plusButton = new javax.swing.JButton();
        minusButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        revenueLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        profitLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        productList.setToolTipText("");
        productList.setMaximumSize(new java.awt.Dimension(260, 368));
        productList.setMinimumSize(new java.awt.Dimension(260, 368));
        productList.setPreferredSize(new java.awt.Dimension(260, 368));
        productList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                productListPropertyChange(evt);
            }
        });
        productList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(productList);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane2.setViewportView(descriptionTextArea);

        priceLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        priceLabel.setText(" ");

        quantityLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        quantityLabel.setText(" ");

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alarm-Arrow-Down-icon.png"))); // NOI18N
        downButton.setEnabled(false);
        downButton.setPreferredSize(new java.awt.Dimension(40, 40));
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alarm-Arrow-Up-icon.png"))); // NOI18N
        upButton.setEnabled(false);
        upButton.setPreferredSize(new java.awt.Dimension(40, 40));
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(downButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(quantityLabel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(downButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Products");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Details");

        plusButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        plusButton.setText("+");
        plusButton.setToolTipText("");
        plusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusButtonActionPerformed(evt);
            }
        });

        minusButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        minusButton.setText("-");
        minusButton.setToolTipText("");
        minusButton.setEnabled(false);
        minusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Cost: ");

        costLabel.setText("$0.00");

        jLabel5.setText("Revenue: ");

        revenueLabel.setText("$0.00");

        jLabel7.setText("Profit: ");

        profitLabel.setText("$0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(revenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(costLabel)
                    .addComponent(jLabel5)
                    .addComponent(revenueLabel)
                    .addComponent(jLabel7)
                    .addComponent(profitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void productListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_productListPropertyChange

    }//GEN-LAST:event_productListPropertyChange

    private void productListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productListValueChanged
        if (evt.getValueIsAdjusting()) {
            titleLabel.setText("");
            priceLabel.setText("");
            descriptionTextArea.setText("");
            currentItemID = inventory.getItemID(productList.getSelectedIndex());
            minusButton.setEnabled(true);
            updateProductDetails(currentItemID);
            downButton.setEnabled(true);
            upButton.setEnabled(true);
        }
    }//GEN-LAST:event_productListValueChanged

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        int quantity = inventory.getQuantity(currentItemID);
        inventory.decrement(currentItemID, 1);
        quantity--;
        if (quantity < 1) {
            clearProductDetails();
            updateInventoryList();
        }
        else {
            updateProductDetails(currentItemID);
        }
        updateFinancials();
    }//GEN-LAST:event_downButtonActionPerformed

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        inventory.increment(currentItemID, 1);
        updateProductDetails(currentItemID);
        updateFinancials();
    }//GEN-LAST:event_upButtonActionPerformed

    private void minusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusButtonActionPerformed
        // TODO add your handling code here:
        clearProductDetails();
        inventory.removeItem(currentItemID);
        updateInventoryList();
        updateFinancials();
    }//GEN-LAST:event_minusButtonActionPerformed

    private void plusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusButtonActionPerformed
        // TODO add your handling code here:
        clearProductDetails();
        AddItem addItem = new AddItem();
        addItem.addListener(this);
        addItem.setVisible(true);
    }//GEN-LAST:event_plusButtonActionPerformed

    public void newItemAdded() {
        updateInventoryList();
        updateFinancials();
    }
    
    private void updateProductDetails (int itemID) {
        Product product = inventory.getProductByID(itemID);
        int quantityInInventory = inventory.getQuantity(itemID);
        int quantityInCart = cart.getQuantity(itemID);
        titleLabel.setText(product.name);
        DecimalFormat df2 = new DecimalFormat( "#0.00" );
        priceLabel.setText("$" + df2.format(product.price) );
        descriptionTextArea.setText(product.description);

        int quantityAvailable = quantityInInventory - quantityInCart;

        quantityLabel.setText("Quantity in stock: " + quantityAvailable);
    }
    
    private void clearProductDetails() {
        titleLabel.setText("");
        priceLabel.setText("");
        descriptionTextArea.setText("");
        quantityLabel.setText("");
        downButton.setEnabled(false);
        upButton.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton downButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton minusButton;
    private javax.swing.JButton plusButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JList productList;
    private javax.swing.JLabel profitLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel revenueLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}