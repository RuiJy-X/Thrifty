/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

/**
 *
 * @author User
 */
public class ProductDTO {
    private String id;
    private int quantity;
    private double price;
    private String name;
    private String store;
    private String storeID;    
    private String image;
    private String description;
    private int purchases;
    public ProductDTO(){
        
    }
    
    public ProductDTO(String id, int quantity, double price, String name, String store, String storeID,String image, String description, int purchases) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.store = store;
        this.storeID = storeID;
        this.image = image;
        this.description = description;
        this.purchases = purchases;
    }
    public int getPurchases(){return purchases;}
    public void setPurchases(int purchases){this.purchases = purchases;};
    public String getDescription(){return description;}
    public String getId() { return id; }
    public int getQuantity() {return quantity;}
    public double getPrice() {return price;}
    public String getName() { return name;}
    public String getStore() {return store;}
    public String getStoreID(){return storeID;}
    public String getImage(){return image;}
    
}
