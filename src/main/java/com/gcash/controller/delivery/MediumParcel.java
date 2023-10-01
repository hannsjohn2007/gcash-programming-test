package com.gcash.controller.delivery;

import com.gcash.model.ParcelInfo;

public class MediumParcel extends DeliveryCostCalculator {
    public MediumParcel(String ruleName, int priority) {
        super(ruleName, priority, false);
    }

    @Override
    public boolean checkRule(ParcelInfo parcel) {
        double volume = getVolume(parcel);
        return volume < 2500 && volume > 1500;
    }

    @Override
    public double computeCost(ParcelInfo parcel) {
        double volume = getVolume(parcel);
        return 0.04 * volume;
    }

    @Override
    public String toString() {
        return "Medium Parcel";
    }

}
