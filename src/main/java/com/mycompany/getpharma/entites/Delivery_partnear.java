/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.getpharma.entites;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Utkarsh Kumar
 */
public class Delivery_partnear {
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
       @Column(length=10,name="driver_id")
    private int userId;
    @Column(length=100,name="driver_name")
    private String userName;
     @Column(length=100,name="driver_email")
    private String userEmail;
     @Column(length=100,name="driver_password")
    private String userPassword;
  @Column(length=12,name="driver_phone")
    private String userPhone;
         @Column(length=1500,name="imagedriver")
  private String userPic;
    @Column(length=1500,name="driver_address")
    private String userAddress;

    public Delivery_partnear(int userId, String userName, String userEmail, String userPassword, String userPhone, String userPic, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPic = userPic;
        this.userAddress = userAddress;
    }

    public Delivery_partnear(String userName, String userEmail, String userPassword, String userPhone, String userPic, String userAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPic = userPic;
        this.userAddress = userAddress;
    }

    public Delivery_partnear() {
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    
    

    
}