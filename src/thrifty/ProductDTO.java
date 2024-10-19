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
    public ProductDTO(){
        
    }
    
    public ProductDTO(String id, int quantity, double price, String name, String store, String storeID,String image) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.store = store;
        this.storeID = storeID;
        this.image = image;
    }
    
    public String getId() { return id; }
    public int getQuantity() {return quantity;}
    public double getPrice() {return price;}
    public String getName() { return name;}
    public String getStore() {return store;}
    public String getStoreID(){return storeID;}
    public String getImage(){return image;}
    
}
