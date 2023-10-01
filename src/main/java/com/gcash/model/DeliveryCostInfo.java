package com.gcash.model;

public class DeliveryCostInfo {
    private ParcelInfo parcel;
    private double cost;
    private boolean isRejected;

    private String message;

    public DeliveryCostInfo(ParcelInfo parcel, double cost, boolean isRejected, String message) {
        this.parcel = parcel;
        this.cost = cost;
        this.isRejected = isRejected;
        this.message = message;
    }

    public ParcelInfo getParcel() {
        return parcel;
    }

    public void setParcel(ParcelInfo parcel) {
        this.parcel = parcel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public void setRejected(boolean rejected) {
        isRejected = rejected;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DeliveryCostInfo{" +
                "parcel=" + parcel +
                ", cost=" + cost +
                ", isRejected=" + isRejected +
                ", message='" + message + '\'' +
                '}';
    }
}
