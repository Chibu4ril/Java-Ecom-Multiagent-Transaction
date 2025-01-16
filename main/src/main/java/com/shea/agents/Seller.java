package com.shea.agents;


import java.util.Map;

import com.shea.model.Offer;
import com.shea.model.OrderPurchase;

public class Seller {
    private String name;
    private Map<String, Double> inventory; // Product -> Price
    private int deliveryTime;
    private double qualityRating;

    public Seller(String name, Map<String, Double> inventory, int deliveryTime, double qualityRating) {
        this.name = name;
        this.inventory = inventory;
        this.deliveryTime = deliveryTime;
        this.qualityRating = qualityRating;
    }

    public Offer respondToCFP(OrderPurchase order) {
        if (inventory.containsKey(order.product) && inventory.get(order.product) >= order.minPrice
                && inventory.get(order.product) <= order.maxPrice && deliveryTime <= order.maxDeliveryTime
                && qualityRating >= order.minQualityRating) {
            return new Offer(name, inventory.get(order.product), deliveryTime, true);
        }
        return new Offer(name, 0, 0, false);
    }

    public String getName() {
        return name;
    }
}
