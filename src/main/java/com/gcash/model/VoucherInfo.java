package com.gcash.model;

import java.util.Date;

public class VoucherInfo {
    private String code;
    private float discount;
    private Date expiry;

    public VoucherInfo(String code, float discount, Date expiry) {
        this.code = code;
        this.discount = discount;
        this.expiry = expiry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
