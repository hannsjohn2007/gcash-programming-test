package com.gcash.model;

import org.springframework.lang.NonNull;

public class ParcelInfo {
    @NonNull
    private float weight;
    @NonNull
    private float height;
    @NonNull
    private float width;
    @NonNull
    private float length;

    public ParcelInfo(float weight, float height, float width,float length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ParcelInfo{" +
                "weight=" + weight +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
