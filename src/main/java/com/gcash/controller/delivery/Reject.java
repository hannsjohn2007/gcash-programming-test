package com.gcash.controller.delivery;

import com.gcash.model.ParcelInfo;

public class Reject extends DeliveryCostCalculator {
    public Reject(String ruleName, int priority) {
        super(ruleName, priority, true);
    }

    @Override
    public boolean checkRule(ParcelInfo parcel) {
        return parcel.getWeight() > 50;
    }

    @Override
    public double computeCost(ParcelInfo parcel) {
        return 0;
    }

    @Override
    public String toString() {
        return "Rejected Parcel";
    }
}
