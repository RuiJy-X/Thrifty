/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package thrifty.shopUIs;

import java.util.ArrayList;
import java.util.HashMap;
import thrifty.Dashboard;
import thrifty.ShopDTO;
import thrifty.SoldItemDTO;
import thrifty.UserDTO;

/**
 *
 * @author User
 */

public class PanelOverview extends javax.swing.JPanel {
    HashMap<String,UserDTO> allUsers;
    ShopDTO shop;
    Dashboard db;
    HashMap<String,SoldItemDTO> soldItems;
    int purchases = 0;
    int sales = 0;
    int productsListed = 0;
    
    /**
     * Creates new form PanelMyProducts
     */
    public PanelOverview() {
        initComponents();
    }
    
    public void setup(Dashboard db,ShopDTO shop){
        purchases = 0;
        sales = 0;
        productsListed = 0;
        container.removeAll();
        this.db = db;
        this.shop = shop;
        allUsers = db.getUserFiles();
        soldItems = db.getSoldItems();
        productsListed = shop.getProducts().size();
        ArrayList<String> sellLogItems = shop.getSellLog();
        
        for (String soldID : sellLogItems){
            purchases += 1;
            
            SoldItemDTO solditem = soldItems.get(soldID);
            sales += solditem.getTotalPrice();
            // public SellLogItems(String productName, String customerName, double unitPrice, int quantity, double totalPrice, String date) {
            String productName = solditem.getProductName();
            String customerName = allUsers.get(solditem.getBuyerID()).getName();
            double unitPrice = Double.parseDouble(solditem.getPrice());
            int quantity = solditem.getQuantitySold();
            double totalPrice = solditem.getTotalPrice();
            String date = solditem.getDateBought();
            
            SellLogItems sellLogComponent = new SellLogItems(productName,customerName,unitPrice,quantity,totalPrice,date);
            container.add(sellLogComponent);
        }
        
        purchasesLabel.setText(String.format("%,d",purchases));
        salesLabel.setText(String.format("₱%,.2f", sales / 1.0));
        productsListedLabel.setText(String.format("%,d", productsListed));
        
    }
    
    public void setShop(ShopDTO shop){
        this.shop = shop;
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
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        productsListedLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        salesLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        purchasesLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel1.setText("Overview");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 26, -1, -1));

        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thrifty/resources/rectoverview.png"))); // NOI18N
        jLayeredPane3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 280, 110));

        productsListedLabel.setBackground(new java.awt.Color(204, 0, 0));
        productsListedLabel.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        productsListedLabel.setForeground(new java.awt.Color(255, 255, 255));
        productsListedLabel.setText("0");
        jLayeredPane3.setLayer(productsListedLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane3.add(productsListedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, -1));

        jLabel7.setBackground(new java.awt.Color(204, 0, 0));
        jLabel7.setFont(new java.awt.Font("Outfit", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Products Listed");
        jLayeredPane3.setLayer(jLabel7, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 81, 294, -1));

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thrifty/resources/rectoverview.png"))); // NOI18N
        jLayeredPane2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 280, 110));

        salesLabel.setBackground(new java.awt.Color(204, 0, 0));
        salesLabel.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        salesLabel.setForeground(new java.awt.Color(255, 255, 255));
        salesLabel.setText("0");
        jLayeredPane2.setLayer(salesLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane2.add(salesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, -1));

        jLabel5.setBackground(new java.awt.Color(204, 0, 0));
        jLabel5.setFont(new java.awt.Font("Outfit", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sales");
        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 81, 300, -1));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(280, 112));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thrifty/resources/rectoverview.png"))); // NOI18N
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 110));

        purchasesLabel.setBackground(new java.awt.Color(204, 0, 0));
        purchasesLabel.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        purchasesLabel.setForeground(new java.awt.Color(255, 255, 255));
        purchasesLabel.setText("0");
        jLayeredPane1.setLayer(purchasesLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(purchasesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, -1));

        jLabel3.setBackground(new java.awt.Color(204, 0, 0));
        jLabel3.setFont(new java.awt.Font("Outfit", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Purchases");
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 81, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel8.setText("Sell Log");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 199, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel12.setText("Customer Name");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 254, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel13.setText("Product Name");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 254, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel14.setText("Unit Price");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 254, -1, -1));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel15.setText("Quantity");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 254, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel16.setText("Date Purchased");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(889, 254, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel17.setText("Total");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 254, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1093, 33));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(1093, 648));
        container.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane1.setViewportView(container);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 285, 1030, 370));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel productsListedLabel;
    private javax.swing.JLabel purchasesLabel;
    private javax.swing.JLabel salesLabel;
    // End of variables declaration//GEN-END:variables
}
