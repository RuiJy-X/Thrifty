/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

import java.util.List;

/**
 *
 * @author User
 */
public class ShopDTO {
    private String shopName;
    private String ownerName;
    private String address;
    private String city;
    private String businessType;
    private String phoneNumber;
    private String email;
    private String description;
    private List<String>products;
    
    public ShopDTO(){
        
    }
    
    public ShopDTO(String shopName, String ownerName, String address, String city, String businessType, String phoneNumber, String email, String description,List<String> products){
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.address = address;
        this.city = city;
        this.businessType = businessType;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.products = products;
    }
    
    public String getShopName(){return shopName;}
    public String getOwnerName(){return ownerName;}
    public String getAddress(){return address;}
    public String getCity(){return city;}
    public String getBusinessType(){return businessType;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getEmail(){return email;}
    public String getDescription(){return description;}
    public List<String> getProducts(){return products;}
    
}
