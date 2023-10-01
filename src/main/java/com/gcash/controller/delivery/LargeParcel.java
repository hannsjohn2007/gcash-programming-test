package com.gcash.controller.delivery;

import com.gcash.model.ParcelInfo;

public class LargeParcel extends DeliveryCostCalculator{
    public LargeParcel(String ruleName, int priority) {
        super(ruleName, priority, false);
    }

    @Override
    public boolean checkRule(ParcelInfo parcel) {
        double volume = getVolume(parcel);
        return volume > 2500;
    }

    @Override
    public double computeCost(ParcelInfo parcel) {
        double volume = getVolume(parcel);
        return 0.05 * volume;
    }

    @Override
    public String toString() {
        return "Large Parcel";
    }
}
