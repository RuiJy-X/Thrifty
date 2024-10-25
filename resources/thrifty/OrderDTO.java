/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

/**
 *
 * @author User
 */
public class OrderDTO {
    private int quantitySold;
    private String buyerID;
    private String dateBought;
    private String productID;
    private double totalPrice;
    private String orderID;
    
    public OrderDTO(){
        
    }
    
    public OrderDTO(String orderID,String productID, int quantitySold, String buyerID, String dateBought, double totalPrice){
        this.orderID = orderID;
        this.productID = productID;
        this.quantitySold = quantitySold;
        this.buyerID = buyerID;
        this.dateBought = dateBought;
        this.totalPrice = totalPrice;
                
    }
    public String getOrderID(){return orderID;}
    public int getQuantitySold(){return quantitySold;}
    public String getBuyerID(){return buyerID;}
    public String getDateBought(){return dateBought;}
    public String getProductID(){return productID;}
    public double getTotalPrice(){return totalPrice;}
    
    
    
}
