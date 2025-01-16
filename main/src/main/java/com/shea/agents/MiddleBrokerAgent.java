package com.shea.agents;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.shea.model.Offer;
import com.shea.model.OrderPurchase;

public class MiddleBrokerAgent {
    private List<Seller> retailers;

    public MiddleBrokerAgent(List<Seller> retailers) {
        this.retailers = retailers;
    }

    public List<Offer> collectProposals(OrderPurchase order) {
        System.out.println("\nBroker Agent sends a Call For Proposals(CFP) to retailers...");
        List<Offer> proposals = new ArrayList<>();

        for (Seller retailer : retailers) {
            Offer proposal = retailer.respondToCFP(order);
            if (proposal.isValid) {
                System.out.println(retailer.getName() + " submits a proposal.");
                proposals.add(proposal);
            } else {
                System.out.println(retailer.getName() + " declines the CFP.");
            }
        }

        return proposals;
    }

    public Offer recommendBestOffer(List<Offer> proposals) {
        if (proposals.isEmpty()) {
            System.out.println("\nBroker Agent: No valid proposals to recommend.");
            return null;
        }

        proposals.sort(Comparator.comparingDouble((Offer p) -> p.price)
                .thenComparingInt(p -> p.deliveryTime));

        Offer bestProposal = proposals.get(0);
        System.out.println("\nBroker Agent recommends: " + bestProposal);
        return bestProposal;
    }
}
