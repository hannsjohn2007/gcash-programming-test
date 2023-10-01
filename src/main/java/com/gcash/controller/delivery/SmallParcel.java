package com.gcash.controller.delivery;

import com.gcash.model.ParcelInfo;

public class SmallParcel extends DeliveryCostCalculator {
    public SmallParcel(String ruleName, int priority) {
        super(ruleName, priority, false);
    }

    @Override
    public boolean checkRule(ParcelInfo parcel) {
        double volume = getVolume(parcel);
        return volume < 1500;
    }

    @Override
    public double computeCost(ParcelInfo parcel) {
        double volume = getVolume(parcel);
        return 0.03 * volume;
    }

    @Override
    public String toString() {
        return "Small Parcel";
    }

}
