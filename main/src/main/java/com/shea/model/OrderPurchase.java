package com.shea.model;

public class OrderPurchase {
    public String product;
    public int quantity;
    public double minPrice;
    public double maxPrice;
    public int maxDeliveryTime; // in days
    public double minQualityRating;
    public String preferredRetailer; 
    public String alternativeProduct; 

    public OrderPurchase(String product, int quantity, double minPrice, double maxPrice,
                         int maxDeliveryTime, double minQualityRating, String preferredRetailer, String alternativeProduct) {
        this.product = product;
        this.quantity = quantity;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.maxDeliveryTime = maxDeliveryTime;
        this.minQualityRating = minQualityRating;
        this.preferredRetailer = preferredRetailer;
        this.alternativeProduct = alternativeProduct;
    }

    @Override
    public String toString() {
        return "Order [Product: " + product + ", Quantity: " + quantity + ", Price Range: " +
                minPrice + "-" + maxPrice + ", Max Delivery: " + maxDeliveryTime +
                " days, Min Quality: " + minQualityRating + "]";
    }
}
