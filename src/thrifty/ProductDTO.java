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
    private int id;
    private int quantity;
    private double price;
    private String name;
    private String store;
    
    public ProductDTO(){
        
    }
    
    public ProductDTO(int id, int quantity, double price, String name, String store) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.store = store;
    }
    
    public int getId() { return id; }
    public int getQuantity() {return quantity;}
    public double getPrice() {return price;}
    public String getName() { return name;}
    public String getStore() {return store;}
}
