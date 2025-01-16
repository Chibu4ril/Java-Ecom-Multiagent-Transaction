package com.shea.model;

public class Offer {
    public String retailerName;
    public double price;
    public int deliveryTime; // in days
    public boolean isValid;

    public Offer(String retailerName, double price, int deliveryTime, boolean isValid) {
        this.retailerName = retailerName;
        this.price = price;
        this.deliveryTime = deliveryTime;
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Retailer: " + retailerName + ", Price: " + price + ", Delivery: " + deliveryTime + " days";
    }
}
