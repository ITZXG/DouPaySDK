package me.doupay.sdk.bean;

public class PaymentResultResponse {

    /**
     * 支付订单号
     */
    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     *币种代码
     */
    private String coinCode;
    /**
     *地址
     */
    private String address;

    public PaymentResultResponse(String orderCode, String coinCode, String address, String amount) {
        this.orderCode = orderCode;
        this.coinCode = coinCode;
        this.address = address;
        this.amount = amount;
    }

    /**
     *数量
     */
    private String amount;
}
