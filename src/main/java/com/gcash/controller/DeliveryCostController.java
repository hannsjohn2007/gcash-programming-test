package com.gcash.controller;


import com.gcash.controller.delivery.DeliveryCostCalculator;
import com.gcash.controller.delivery.ParcelRuleFactory;
import com.gcash.model.DeliveryCostInfo;
import com.gcash.model.ParcelInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class DeliveryCostController {
    private final Logger logger = LoggerFactory.getLogger(DeliveryCostController.class);

    public DeliveryCostInfo computeDeliveryCost(ParcelInfo parcel) {
        ArrayList<DeliveryCostCalculator> deliveryCost = getAllRules();
        DeliveryCostCalculator matchedRule;
        matchedRule = deliveryCost
                .stream()
                .filter((n) -> n.checkRule(parcel))
                .findAny()
                .orElse(ParcelRuleFactory.HeavyParcel.createRule());
        logger.debug("Compute Delivery Cost!");

        return new DeliveryCostInfo(parcel, matchedRule.computeCost(parcel), matchedRule.isRejected(), matchedRule.toString());
    }

    private ArrayList<DeliveryCostCalculator> getAllRules () {
        logger.debug("Get All Parcel Delivery Cost Rules");
        Logger logger = LoggerFactory.getLogger(DeliveryCostController.class);
        ArrayList<DeliveryCostCalculator> deliveryCost = new ArrayList<>();
        for (ParcelRuleFactory rule: ParcelRuleFactory.values()) {
            DeliveryCostCalculator createdRule = rule.createRule();
            deliveryCost.add(createdRule);
        }
        return deliveryCost;
    }
}
