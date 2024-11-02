/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

/**
 *
 * @author User
 */
public class SoldItemDTO extends OrderDTO{
    private int quantitySold;
    private String buyerID;
    private String dateBought;
    private String productID;
    private double totalPrice;
    private String orderID;
    private String shopID;
    private String price;
    private ProductDTO product;
   
    
    public SoldItemDTO(String orderID,String productID, int quantitySold, String buyerID, String dateBought, double totalPrice, String shopID,double price,ProductDTO product){
       super(orderID,productID,quantitySold,buyerID,dateBought,totalPrice,shopID,price,product);
    }
    
    
}
