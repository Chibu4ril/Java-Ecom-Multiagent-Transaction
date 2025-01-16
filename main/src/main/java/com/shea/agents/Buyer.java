package com.shea.agents;

import java.util.List;

import com.shea.model.BuyerProfile;
import com.shea.model.Offer;
import com.shea.model.OrderPurchase;

public class Buyer {
    private BuyerProfile profile;

    public Buyer(String name) {
        this.profile = new BuyerProfile(name);
    }

    public OrderPurchase createOrder(String product, int quantity, double minPrice, double maxPrice,
                                     int maxDeliveryTime, double minQualityRating, String preferredRetailer, String alternativeProduct) {
        System.out.println(profile.getName() + " creates an order request with the following details:");
        System.out.println("\nProduct Name: " + product + " \nQuantity: " + quantity + " \nMin Price: " + minPrice + " \nMax Price: " + maxPrice + " \nMax Delivery Time: " + maxDeliveryTime + " \nMin Quality Rating: " + minQualityRating + " \nPreferred Retailer: " + preferredRetailer + " \nAlternative Product: " + alternativeProduct);
        return new OrderPurchase(product, quantity, minPrice, maxPrice, maxDeliveryTime, minQualityRating, preferredRetailer, alternativeProduct);
    }

    public void decideOnOffers(List<Offer> proposals, Offer recommendation) {
        System.out.println("\n" + profile.getName() + " reviews the proposals:");

        for (Offer proposal : proposals) {
            System.out.println(proposal);
        }

        System.out.println("\nBroker's Recommendation: " + recommendation);

        if (recommendation != null) {
            System.out.println("\n" + profile.getName() + " accepts the recommendation: " + recommendation);
            System.out.println("\n" + recommendation.retailerName + " has been notified of the acceptance.");
            System.out.println("\n" + recommendation.retailerName + " has shipped the order to " + profile.getName() + ". It will arrive in " + recommendation.deliveryTime + " days.");
        } else {
            System.out.println(profile.getName() + " declines all proposals.");
        }
    }
}
