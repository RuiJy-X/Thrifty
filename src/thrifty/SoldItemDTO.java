/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

/**
 *
 * @author User
 */
public class SoldItemDTO{
    private int quantitySold;
    private String buyerID;
    private String dateBought;
    private String productID;
    private double totalPrice;
    private String shopID;
    private String price;
    private String soldItemID;
    private String productName;
   
    public SoldItemDTO(){
        
    }
    
    public SoldItemDTO(String soldItemID,String productID, int quantitySold, String buyerID, String dateBought, double totalPrice, String shopID,double price, String productName){
   
       this.soldItemID = soldItemID;
       this.quantitySold = quantitySold;
       this.buyerID = buyerID;
       this.productID = productID;
       this.dateBought = dateBought;
       this.totalPrice = totalPrice;
       this.shopID = shopID;
       String temp = String.valueOf(price);
       this.price = temp;
       this.productName = productName;
       
    }
    
    public String getProductName(){return productName;}
    public String getPrice(){return price;}
    public String getShopID(){return shopID;}
    public String getSoldItemID(){return soldItemID;}
    public int getQuantitySold(){return quantitySold;}
    public String getBuyerID(){return buyerID;}
    public String getDateBought(){return dateBought;}
    public String getProductID(){return productID;}
    public double getTotalPrice(){return totalPrice;}
    
}
