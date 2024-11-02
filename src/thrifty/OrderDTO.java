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
    private String shopID;
    private String price;
    private ProductDTO product;
    public OrderDTO(){
        
    }
    
    public OrderDTO(String orderID,String productID, int quantitySold, String buyerID, String dateBought, double totalPrice, String shopID,double price,ProductDTO product){
        this.orderID = orderID;
        this.productID = productID;
        this.quantitySold = quantitySold;
        this.buyerID = buyerID;
        this.dateBought = dateBought;
        this.totalPrice = totalPrice;
        this.shopID = shopID;
        this.price = String.valueOf(price);
        this.product = product;
                
    }
    public OrderDTO(OrderDTO order, int quantitySold,double totalPrice){
        this.orderID = order.getOrderID();
        this.productID = order.getProductID();
        this.quantitySold = quantitySold;
        this.buyerID = order.getBuyerID();
        this.dateBought = order.getDateBought();
        this.totalPrice = totalPrice;
        this.shopID = order.getShopID();
        this.price = String.valueOf(order.getProduct().getPrice());
        this.product = order.getProduct();
                
    }
    public ProductDTO getProduct(){return product;}
    public String getPrice(){return price;}
    public String getShopID(){return shopID;}
    public String getOrderID(){return orderID;}
    public int getQuantitySold(){return quantitySold;}
    public String getBuyerID(){return buyerID;}
    public String getDateBought(){return dateBought;}
    public String getProductID(){return productID;}
    public double getTotalPrice(){return totalPrice;}
}
