package com.shea.model;


import java.util.ArrayList;
import java.util.List;

public class BuyerProfile {
    private String name;
    private List<OrderPurchase> orderHistory;
    private double loyaltyPoints;

    public BuyerProfile(String name) {
        this.name = name;
        this.orderHistory = new ArrayList<>();
        this.loyaltyPoints = 0.0;
    }

    public String getName() {
        return name;
    }

    public List<OrderPurchase> getOrderHistory() {
        return orderHistory;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addOrder(OrderPurchase order) {
        orderHistory.add(order);
    }

    public void addLoyaltyPoints(double points) {
        loyaltyPoints += points;
    }

    @Override
    public String toString() {
        return "Customer: " + name + ", Loyalty Points: " + loyaltyPoints + ", Order History: " + orderHistory.size();
    }
}
