/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thrifty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static thrifty.Dashboard.file;
import static thrifty.Dashboard.mapper;
import static thrifty.Dashboard.uniqueProductList;


/**
 *
 * @author User
 */

public class Dashboard extends javax.swing.JFrame {
   
    public HashMap<String, HashMap<String, ProductDTO>> allProducts;
    public HashMap<String,ShopDTO> allShops;
    public HashMap<String,UserDTO> allUsers;
    public static ObjectMapper mapper = new ObjectMapper();
    
    public static File file = new File("src\\thrifty\\products.json");
    public static File shopFile = new File("src\\thrifty\\shops.json");
    public static File userFiles = new File("src\\thrifty\\userFiles.json");
    
    public static ArrayList<ProductDTO> uniqueProductList = new ArrayList<ProductDTO>();
    
    public UserDTO userLoggedIn;
    public ShopDTO userShop;
    public Dashboard()  {
       
        
            initComponents();
            
            navBar1.setDB(this);
            shopOverview2.setAddProduct(this);
            
            
            readFile();
            
            this.createProductComponent();
            this.setShop();
            fieldsRegisterShop1.setShopHashMap(allShops);
            fieldsRegisterShop1.setDB(this);
       
            
          
    }
    public Dashboard(UserDTO user)  {
        
        initComponents();
        this.userLoggedIn = user;
        navBar1.setDB(this);
        shopOverview2.setAddProduct(this);
        
        this.readFile();
        this.setShop();
       
        this.createProductComponent();
        

        System.out.println(allShops.keySet());
        fieldsRegisterShop1.setShopHashMap(allShops);
        fieldsRegisterShop1.setDB(this);
       
            
          
    }
    
    public HashMap<String,ShopDTO> getShop(){
        return this.allShops;
    }
    
    public UserDTO getUser(){
        return this.userLoggedIn;
    }
    
    public ShopDTO getUserShop(){
        return this.userShop;
    }
    
    public HashMap<String, UserDTO> getUserFiles(){
        return this.allUsers;
    }
            
    public void setShop(){
        //If a user doesn't have a shop, shop id is set to null in the register form
        if (!userLoggedIn.getShopID().equals("null")){
            //get user shop ID, find it in memory, then create a shop object, then make shop component
            
            userShop = allShops.get(userLoggedIn.getShopID());
              
            // The code below aims to achieve singleton pattern
            // Only one instance of the hashmap should be used to avoid rereading of files
            // We pass in the hashmaps of products and shop, and user so that the other classes/ objects can access the same variable
            
            //This allows the shop overview to access the shop of the user if he has one
            //The shop object contains information such as name, address, products list, etc.
            shopOverview2.setShop(userShop);// So the shop tab can access the shop object
            
            // These lines of code passes in the hashmaps the program iniated when it was ran
            // We need to pass in these variables so that we dont have to re read the hashmaps again from the files
            // The classes below shop overview needs to access these variables because the adding and editing of products are done through the shops.
            shopOverview2.setProductMap(allProducts);// the shop tab needs to access the product hashmap
            shopOverview2.setShopHashMap(allShops);// the shop tab needs to access the shop hashmap
            
            shopOverview2.setUser(userLoggedIn);
            
            fieldsRegisterShop1.setShopHashMap(allShops);
            fieldsRegisterShop1.setUser(userLoggedIn);
        }
    }
    
    
   public void readFile(){
        try{


            allProducts = mapper.readValue(file, new TypeReference<HashMap<String, HashMap<String, ProductDTO>>>() {}); 
            allShops = mapper.readValue(shopFile, new TypeReference<HashMap<String, ShopDTO>>() {});
            allUsers = mapper.readValue(userFiles, new TypeReference<HashMap<String,UserDTO>>() {});
        }catch(IOException e){
            e.printStackTrace();
        }
   }
   
   public void createProductComponent(){
       for (String key : allProducts.keySet()){
            for (ProductDTO product : allProducts.get(key).values()){
//           int storeID = product.getStoreID();
//           if (userCity == stores.get(storeID).get("city")){
//              then create object
//          this is to check for proximity

                Product individualProduct = new Product(product.getName(),"location",product.getPrice(),product.getImage());
                productPanel2.populate(individualProduct);
        
       }
      
       }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    public void shop(){
        System.out.println("im clicked");
        if (userLoggedIn.getShopID().equals("null")){
           tabs.setSelectedIndex(1);// Switches tab to shop tab
            // switches shop tab to register, 0 = register tab, 1 = shop overview tab (if shop exists)
        }else{
           tabs.setSelectedIndex(2);
        }
    }
    
    public void dashboard(){
        tabs.setSelectedIndex(0);
        
    }
    
    public void setUser(UserDTO user){
        userLoggedIn = user;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        navBar1 = new thrifty.NavBar();
        tabs = new javax.swing.JTabbedPane();
        productPanel2 = new thrifty.ProductPanel();
        fieldsRegisterShop1 = new thrifty.shopUIs.FieldsRegisterShop();
        shopOverview2 = new thrifty.ShopOverview();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 900));
        setSize(new java.awt.Dimension(1280, 800));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jLayeredPane1.setLayer(navBar1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(navBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabs.setMinimumSize(new java.awt.Dimension(1280, 800));
        tabs.setPreferredSize(new java.awt.Dimension(1280, 800));
        tabs.addTab("tab2", productPanel2);
        tabs.addTab("tab2", fieldsRegisterShop1);
        tabs.addTab("tab1", shopOverview2);

        jLayeredPane1.add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        getContentPane().add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public thrifty.shopUIs.FieldsRegisterShop fieldsRegisterShop1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private thrifty.NavBar navBar1;
    private thrifty.ProductPanel productPanel2;
    private thrifty.ShopOverview shopOverview2;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
