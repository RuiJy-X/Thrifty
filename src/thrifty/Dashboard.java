/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thrifty;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static thrifty.Dashboard.file;
import static thrifty.Dashboard.mapper;
import static thrifty.RegisterForm.random;


/**
 *
 * @author User
 */

public class Dashboard extends javax.swing.JFrame {
    private static boolean isFiltered = false;
    
    
     private static final int itemsPerPage = 12;
    private int currentPage = 0; // Tracks the current page
    
    public HashMap<String, HashMap<String, ProductDTO>> allProducts;
    public HashMap<String,ShopDTO> allShops;
    public HashMap<String,UserDTO> allUsers;
    public HashMap<String,OrderDTO> orders;
    public HashMap<String,SoldItemDTO> soldItems;
    ArrayList<String> cart;
    public static ObjectMapper mapper = new ObjectMapper();
    
    public static File file = new File("src\\thrifty\\products.json");
    public static File shopFile = new File("src\\thrifty\\shops.json");
    public static File userFiles = new File("src\\thrifty\\userFiles.json");
    
    public static ArrayList<Component> uniqueProductList = new ArrayList<>();
    
    public Component[] productComponents;
    public Component[] allProductComponents;
    
    public boolean isSearching = false;
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
        fieldsRegisterShop1.setDB(this);
        this.cart = user.getCart();
        this.readFile();
        this.setShop();
       
        this.createProductComponent();
        

        
        
       
            
          
    }
    
            
    public void setShop(){
        //If a user doesn't have a shop, shop id is set to null in the register form
        if (!userLoggedIn.getShopID().equals("null")){
            //get user shop ID, find it in memory, then create a shop object, then make shop component
            System.out.println("this works");
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
            
           
            fieldsRegisterShop1.setUser(userLoggedIn);
            fieldsRegisterShop1.setShopHashMap(allShops);
            System.out.println("fields");
            fieldsRegisterShop1.setDB(this);
            
            shopOverview2.setDB(this);
            
            productPanel2.setDB(this);
                    
        }
    }
    
    
   public void readFile(){
        try{


            allProducts = mapper.readValue(file, new TypeReference<HashMap<String, HashMap<String, ProductDTO>>>() {}); 
            allShops = mapper.readValue(shopFile, new TypeReference<HashMap<String, ShopDTO>>() {});
            allUsers = mapper.readValue(userFiles, new TypeReference<HashMap<String,UserDTO>>() {});
            orders = mapper.readValue(new File("src\\thrifty\\orders.json"), new TypeReference<HashMap<String,OrderDTO>>() {});
            soldItems = mapper.readValue(new File("src\\thrifty\\solditems.json"), new TypeReference<HashMap<String,SoldItemDTO>>() {});
        }catch(IOException e){
            e.printStackTrace();
        }
   }
   
   public String getLocation(String shopID){
       String location = allShops.get(shopID).getCity();
       return location;
   }
   

   public void createProductComponent(){
       
       uniqueProductList.clear();
       productComponents = null;
        productPanel2.removeAll();
        productPanel2.revalidate();
        productPanel2.repaint();
       for (String key : allProducts.keySet()){
            for (ProductDTO product : allProducts.get(key).values()){
                String location = this.getLocation(product.getStoreID());

                if (userLoggedIn.getCity().equalsIgnoreCase(location)){
                    Product individualProduct = new Product(product.getName(),location,product.getPrice(),product.getStore(),product.getImage(),product.getDescription(),product.getQuantity(),this,product);
                    uniqueProductList.add(individualProduct);
                    
                }
            }
       }
       
       
      this.displayComponents();
       this.setResults("");
       allProductComponents = productPanel2.getProductComponents();
       isSearching = false;
       
   }
   public void filteredComponents(int i){
//       productPanel2.removeAll();
       
       uniqueProductList.clear();

       productPanel2.revalidate();
       productPanel2.repaint(); 
       
       
       int lowerBound = 0;
        int upperBound = 0;
        
        // //Filter, ₱1.00 -  ₱100.00, ₱100.00 -  ₱300.00, ₱300.00 -  ₱600.00, ₱600.00 -  ₱1000.00, ₱1000.00 -  ₱1500.00, ₱1500.00+
        if (i == 1){
            lowerBound = 1;
            upperBound = 100;
        }else if (i == 2) {
            lowerBound = 100;
            upperBound = 300;
        
        }else if (i == 3) {
            lowerBound = 300;
            upperBound = 600;
        
        }else if (i == 4) {
            lowerBound = 600;
            upperBound = 1000;
        
        }else if (i == 5) {
            lowerBound = 1000;
            upperBound = 1500;
        
        }else if (i == 6) {
            lowerBound = 1500;
            upperBound = Integer.MAX_VALUE;
        }
//         Component[] components = productPanel2.getProductComponents();
        if (isSearching){
             productPanel2.removeAll();
            productPanel2.revalidate();
            productPanel2.repaint(); 
             for (Component component : productComponents){
//           System.out.println(components);

           if (component instanceof Product){
               
               Product product = (Product) component;
               String location = this.getLocation(product.getStoreID());
               
               if (userLoggedIn.getCity().equalsIgnoreCase(location)){
                    if (product.getPrice() >= lowerBound && product.getPrice() <= upperBound){
                       // public Product(String Name, double Price,String shopName, String image, String description, int quantity, Dashboard db, ProductDTO product){
                       Product individualProduct = new Product(product.getName(),location,product.getPrice(),product.getStore(),product.getImage(),product.getDescription(),product.getQuantity(),this,product.getProduct());
                       
                       uniqueProductList.add(individualProduct);

                    }
                }
               
               
           }
        }
      
       }else{
            productPanel2.removeAll();
            productPanel2.revalidate();
            productPanel2.repaint(); 
            for (Component component : allProductComponents){
//           System.out.println(components);

           if (component instanceof Product){
               
               Product product = (Product) component;
               String location = this.getLocation(product.getStoreID());
               if (userLoggedIn.getCity().equalsIgnoreCase(location)){
                    if (product.getPrice() >= lowerBound && product.getPrice() <= upperBound){
                       // public Product(String Name, double Price,String shopName, String image, String description, int quantity, Dashboard db, ProductDTO product){
                       Product individualProduct = new Product(product.getName(),location,product.getPrice(),product.getStore(),product.getImage(),product.getDescription(),product.getQuantity(),this,product.getProduct());
                       uniqueProductList.add(individualProduct);

                    }
               }
           }
           
        }
            
        }
       
       
        this.displayComponents();
   }
   
   
   
   public void resetPanel(){
       productPanel2.removeAll();
       productPanel2.revalidate();
       productPanel2.repaint(); 
   }
    public void searchedComponents(String keyword){
        uniqueProductList.clear();
        isSearching = true;
        productComponents = null;
        for (String key : allProducts.keySet()){
            if (keyword.contains(key)){

                for (ProductDTO product : allProducts.get(key).values()){
                    
                    String location = this.getLocation(product.getStoreID());
                    if (userLoggedIn.getCity().equalsIgnoreCase(location)){
                        Product individualProduct = new Product(product.getName(),location,product.getPrice(),product.getStore(),product.getImage(),product.getDescription(),product.getQuantity(),this,product);
                        uniqueProductList.add(individualProduct);
                    }
                }
            }
        }
        productComponents = productPanel2.getProductComponents();
        this.displayComponents();
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
           this.shopOverview2.overviewTab();
           tabs.remove(4);
        }
    }
    
    public void dashboard(){
        currentPage = 0;
        tabs.setSelectedIndex(0);
        productPanel2.removeAll();
        productPanel2.revalidate();
        productPanel2.repaint();
        this.createProductComponent();
        
        tabs.remove(4);
        
        isFiltered = false;
        isSearching = false;
        
    }
    public void cartTab(){
        tabs.setSelectedIndex(3);
        cart1.removeAll();
        //public CartItems(String name, String image, String location, String price, String totalPrice, ProductDTO product){
        for (String order : cart){
            
            String userID = orders.get(order).getBuyerID();
            
            String image = allUsers.get(userID).getImage();
            String location = allShops.get(orders.get(order).getShopID()).getAddress();
            String price = orders.get(order).getPrice();
            String totalPrice = String.valueOf(orders.get(order).getTotalPrice());
            String quantity = String.valueOf(orders.get(order).getQuantitySold());
            CartItems cartItem = new CartItems(image,location,price,totalPrice,quantity,orders.get(order).getProduct(),order,this);
            cart1.addCartItem(cartItem);
        }
    }
    
    public void setUser(UserDTO user){
        userLoggedIn = user;
    }
    
    public void viewProduct(Component jpanel){
        tabs.add(jpanel);
        tabs.revalidate();
        tabs.repaint();
        tabs.setSelectedIndex(4);
    }
    
    public void search(String item){
        tabs.setSelectedIndex(0);
        productPanel2.removeAll();
        productPanel2.revalidate();
        productPanel2.repaint();
        this.searchedComponents(item);
    }
    
    public void deleteCartAndOrderItem(String order,ProductDTO product){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
       
        
        cart.remove(order);

        ArrayList cartOfUser = userLoggedIn.getCart();
        cartOfUser.remove(order);
        
        allUsers.replace(userLoggedIn.getUserID(), userLoggedIn);
        
        orders.remove(order);
        
        ArrayList<String> orderList = allShops.get(product.getStoreID()).getOrders();
        orderList.remove(order);
        
       
        
        try {
         
            mapper.writeValue(new File("src\\thrifty\\shops.json"), this.allShops);
            mapper.writeValue(new File("src\\thrifty\\orders.json"), orders);
            mapper.writeValue(new File("src\\thrifty\\userFiles.json"), allUsers);
            
        } catch (IOException ex) {
            Logger.getLogger(ProductViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.cartTab();
        this.revalidate();
        this.repaint();
        
    
        
        
    }
    
    public void deletePurchase(String order,ProductDTO product,UserDTO buyer){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        cart.remove(order);
        ArrayList cartOfUser = buyer.getCart();
        cartOfUser.remove(order);
        
        allUsers.replace(buyer.getUserID(), buyer);
        
        orders.remove(order);
        
        ArrayList<String> orderList = allShops.get(product.getStoreID()).getOrders();
        orderList.remove(order);
        
       
        
        try {
         
            mapper.writeValue(new File("src\\thrifty\\shops.json"), this.allShops);
            mapper.writeValue(new File("src\\thrifty\\orders.json"), orders);
            mapper.writeValue(new File("src\\thrifty\\userFiles.json"), allUsers);
            
        } catch (IOException ex) {
            Logger.getLogger(ProductViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.shopOverview2.purchasesTab();
       
        
    
        
        
    }
    
    public void approvePurchase(String orderID,UserDTO buyer, ShopDTO shop,ProductDTO product){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        OrderDTO order = orders.get(orderID);
        
        /*
        1. delete the order on object, user, shop, order json
        2. make a sell item object
        3. put the sell item on the shop's sell order list
        */
        //delete
        cart.remove(orderID);
        ArrayList cartOfUser = buyer.getCart();
        cartOfUser.remove(orderID);
        
        allUsers.replace(buyer.getUserID(), buyer);
        
        orders.remove(orderID);
        
        ArrayList<String> orderList = allShops.get(product.getStoreID()).getOrders();
        orderList.remove(orderID);
        
        
        //Make sold item object
        // public SoldItemDTO(String orderID,String productID, int quantitySold, String buyerID, String dateBought, double totalPrice, String shopID,double price,ProductDTO product)
        String key = this.generateID(createIDKey());
        double price = Double.parseDouble(order.getPrice());
        SoldItemDTO soldItem = new SoldItemDTO(key,order.getProductID(),order.getQuantitySold(),order.getBuyerID(),order.getDateBought(),order.getTotalPrice(),order.getShopID(),price,order.getProduct().getName());
        soldItems.put(key,soldItem);
        ArrayList<String> userShopItemsInstance = userShop.getSellLog();
//        ArrayList<String> userShopSoldItemsHashmap = allShops.get(userShop.getShopID()).getSellLog();
//        userShopSoldItemsHashmap.add(key);
        userShopItemsInstance.add(key);
        
           try {
         
            mapper.writeValue(new File("src\\thrifty\\solditems.json"), this.soldItems);
            mapper.writeValue(new File("src\\thrifty\\shops.json"),this.allShops);
            mapper.writeValue(new File("src\\thrifty\\orders.json"), orders);
            mapper.writeValue(new File("src\\thrifty\\userFiles.json"), allUsers);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ProductViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.shopOverview2.purchasesTab();
        
    }
    
    public void setResults(String name){
        productPanel2.setResults(name);
    }
    
    public Dashboard getDB(){
       return this;
   }
   
   public HashMap<String, HashMap<String, ProductDTO>> getallProducts(){
        return this.allProducts;
    }
    public HashMap<String,ShopDTO> getShop(){
        return this.allShops;
    }
    public void updateUser(UserDTO user){
        this.userLoggedIn = user;
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
    
    public HashMap<String, OrderDTO> getOrder(){
        return this.orders;
    }
    
    public ArrayList<String> getCart(){
        return this.cart;
    }
    
    public HashMap<String,SoldItemDTO> getSoldItems(){
        return this.soldItems;
    }
    
     public String generateID(String ID){ //recursion for creating ID and checks if it exists
        //ID = Sx where x is a number, S means Shop
        for (String key : this.soldItems.keySet()){
            if (key.equals(ID)){ // if ID key exists then create ID
                String newKey = createIDKey(); 
                return generateID(newKey);
            }
        }
        
        return ID;
    }
    
    public static String createIDKey(){ //create ID key
        int randomNumber = random.nextInt(100000);
        String idNum = String.valueOf(randomNumber);
        String key = "SI".concat(idNum);
        return key;
        
    }
    
   public thrifty.ShopOverview getSo(){
       return this.shopOverview2;
   }
   
   public void nextPageUnfiltered(){
       currentPage += 1;
       this.displayComponents();
   }
   
   public void displayComponents(){
       int start = currentPage * itemsPerPage;
       int end = Math.min(start + itemsPerPage, uniqueProductList.size());
       productPanel2.removeAll();
       productPanel2.revalidate();
       productPanel2.repaint();
       if (uniqueProductList.isEmpty()){
           
       }else{
       for (int i = start; i < end ; i++) {
            productPanel2.populate((Product) uniqueProductList.get(i));
        }
       }
   }
   
   public void setUserShop(ShopDTO shop){
       this.userShop = shop;
   }
   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        navBar1 = new thrifty.NavBar();
        tabs = new javax.swing.JTabbedPane();
        productPanel2 = new thrifty.ProductPanel();
        fieldsRegisterShop1 = new thrifty.shopUIs.FieldsRegisterShop();
        shopOverview2 = new thrifty.ShopOverview();
        cart1 = new thrifty.Cart();

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
        tabs.addTab("tab4", cart1);

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
    private thrifty.Cart cart1;
    public thrifty.shopUIs.FieldsRegisterShop fieldsRegisterShop1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private thrifty.NavBar navBar1;
    private thrifty.ProductPanel productPanel2;
    private thrifty.ShopOverview shopOverview2;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
