package com.mycompany.getpharma.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    @ManyToOne
    private User user;
    
    private String shippingAddress;
    private String contactNumber;
    private double totalAmount;
    private String orderStatus;
    private Date orderDate;
    private String paymentMethod;
    private String paymentStatus;
    
    @ManyToOne
    private Delivery_partnear deliveryPartner;

    public Order() {
    }

    public Order(User user, String shippingAddress, String contactNumber, double totalAmount, String orderStatus, Date orderDate, String paymentMethod, String paymentStatus) {
        this.user = user;
        this.shippingAddress = shippingAddress;
        this.contactNumber = contactNumber;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Delivery_partnear getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(Delivery_partnear deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }
}