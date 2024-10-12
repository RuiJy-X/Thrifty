/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thrifty;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class UserDTO {
    private String userID;
    private String name;
    private String password;
    private String location;
    private String city;
    private String shopID;
    private String image;
    private ArrayList<String> cart;
    
    public UserDTO(){
        
    }
    
    public UserDTO(String userID, String name, String password, String location, String city, String shopID, String image, ArrayList<String> cart){
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.location = location;
        this.city = city;
        this.shopID = shopID;
        this.image = image;
        this.cart = cart;
        
    }          
    public String getUserID(){return userID;}
    public String getName(){return name;}
    public String getPassword(){return password;}
    public String getlocation(){return location;}
    public String getCity(){return city;}
    public String getShopID(){return shopID;}
    public String getImage(){return image;}
    public ArrayList<String> getCart(){return cart;}
    
    public void setShopID(String id){
        shopID = id;
    }
    
        
}
