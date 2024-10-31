/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ShopDTO {
    private String shopID;
    private String shopName;
    private String ownerName;
    private String address;
    private String city;
    private String businessType;
    private String phoneNumber;
    private String email;
    private String description;
    private List<String>products;
    private ArrayList<String>orders;
    private List<String>sellLog;
    
    public ShopDTO(){
        
    }
    
    public ShopDTO(String shopID,String shopName, String ownerName, String address, String city, String businessType, String phoneNumber, String email, String description,List<String> products,ArrayList<String> orders,List<String> sellLog){
        this.shopID = shopID;
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.address = address;
        this.city = city;
        this.businessType = businessType;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.products = products;
        this.orders = orders;
        this.sellLog = sellLog;
    }
    
    public ShopDTO(ShopDTO shop){
        this.shopID = shop.getShopID();
        this.shopName = shop.getShopName();
        this.ownerName = shop.getOwnerName();
        this.address = shop.getAddress();
        this.city = shop.getCity();
        this.businessType = shop.getBusinessType();
        this.phoneNumber = shop.getPhoneNumber();
        this.email = shop.getEmail();
        this.description = shop.getDescription();
        this.products = shop.getProducts();
        this.orders = shop.getOrders();
        this.sellLog = shop.getSellLog();
    }
    public List<String> getSellLog(){return sellLog;}
    public ArrayList<String> getOrders(){return orders;}
    public String getShopID(){return shopID;}
    public String getShopName(){return shopName;}
    public String getOwnerName(){return ownerName;}
    public String getAddress(){return address;}
    public String getCity(){return city;}
    public String getBusinessType(){return businessType;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getEmail(){return email;}
    public String getDescription(){return description;}
    public List<String> getProducts(){return products;}
    
    public void addProducts(String productID){
        products.add(productID);
    }
    
}
