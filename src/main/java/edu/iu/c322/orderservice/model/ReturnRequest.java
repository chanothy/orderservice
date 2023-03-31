package edu.iu.c322.orderservice.model;

import java.util.Objects;

public class ReturnRequest {
    private int orderId;
    private int itemId;
    private String reason;

//    public CancelledOrder(int orderId, Integer itemId, String reason) {
//        this.orderId = orderId;
//        this.itemId = itemId;
//        this.reason = reason;
//    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnRequest that = (ReturnRequest) o;
        return orderId == that.orderId && itemId == that.itemId && reason.equals(that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId, reason);
    }
}
