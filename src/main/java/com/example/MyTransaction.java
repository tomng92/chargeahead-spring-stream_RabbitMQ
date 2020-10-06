package com.example;

public class MyTransaction {
    int orderId;
    int itemId;
    int qty;
    String region;

    public MyTransaction(int orderId, int itemId, int qty, String region) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.qty = qty;
        this.region = region;
    }

    public MyTransaction() {}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


}
