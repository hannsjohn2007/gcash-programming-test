package com.gcash.controller.delivery;

import com.gcash.model.ParcelInfo;

public abstract class DeliveryCostCalculator {
    private String ruleName;
    private int priority;
    private final boolean isRejected;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public DeliveryCostCalculator(String ruleName, int priority, boolean isRejected) {
        this.ruleName = ruleName;
        this.priority = priority;
        this.isRejected = isRejected;
    }
    public abstract boolean checkRule(ParcelInfo parcel);
    public abstract double computeCost(ParcelInfo parcel);

    public double getVolume(ParcelInfo parcel) {
        return parcel.getHeight() * parcel.getWidth() * parcel.getLength();
    }
}
