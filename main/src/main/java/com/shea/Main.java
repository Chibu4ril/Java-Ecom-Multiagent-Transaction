package com.shea;

import java.util.List;
import java.util.Map;

import com.shea.agents.Buyer;
import com.shea.agents.MiddleBrokerAgent;
import com.shea.agents.Seller;
import com.shea.model.Offer;
import com.shea.model.OrderPurchase;

public class Main {
    public static void main(String[] args) {
        //  Buyer Agent created
        Buyer customer = new Buyer("Innocent Brad");

            // Customer creates a purchase order with constraints
            OrderPurchase order = customer.createOrder(
                "Black Winter Jacket",  // Product
                1,   // Quantity
                500.0,  // Min Budgeted Price
                900.0,   // Max Price Budget
                5,    // Max Delivery Time (days)
                4.0,    // Min Quality Rating
                "Any",        // Preferred Retailer (Any means no preference)
                "White Winter Jacket"     // Alternative Product
        );

        // Seller Agents with their inventories, delivery times, and quality ratings
        Seller retailer1 = new Seller("Zara", Map.of("Black Winter Jacket", 900.0, "White Winter Jacket", 500.0), 5, 4.5);
        Seller retailer2 = new Seller("New Look", Map.of("Black Winter Jacket", 850.0, "Green Winter Jacket", 300.0), 7, 4.0);
        Seller retailer3 = new Seller("Primark", Map.of("Black Winter Jacket", 950.0, "White Winter Jacket", 450.0), 3, 4.8);

        // Broker Agent with access to all retailers profile
        MiddleBrokerAgent broker = new MiddleBrokerAgent(List.of(retailer1, retailer2, retailer3));

    

        // Broker Agent collects proposals from Retailers
        List<Offer> proposals = broker.collectProposals(order);

        // Broker Agent recommends the best offer
        Offer bestOffer = broker.recommendBestOffer(proposals);

        // Buyer reviews and decides on the proposals
        customer.decideOnOffers(proposals, bestOffer);
    }
}
