package com.gcash.controller.delivery;

import com.gcash.model.ParcelInfo;

public class HeavyParcel extends DeliveryCostCalculator{
    public HeavyParcel(String ruleName, int priority) {
        super(ruleName, priority, false);
    }

    @Override
    public boolean checkRule(ParcelInfo parcel) {
        return parcel.getWeight() <= 50 && parcel.getWeight() > 10;
    }

    @Override
    public double computeCost(ParcelInfo parcel) {
        return 20 * parcel.getWeight();
    }

    @Override
    public String toString() {
        return "Heavy Parcel";
    }
}
