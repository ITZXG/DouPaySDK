package me.doupay.sdk.bean;

public class PaymentResultResponse {

    /**
     * 支付订单号
     */
    private String orderCode;

    /**
     *币种名称
     */
    private String coinCode;
    /**
     *地址
     */
    private String address;
    /**
     *支付数量
     */
    private String amountPaid;
    /**
     *协议名称
     */
    private String protocolName;
    /**
     *支付状态 0未付款 1正常付款 2多付 3少付
     */
    private Integer paymentStatus;
    /**
     *结果 true成功 false失败
     */
    private boolean result;

    public PaymentResultResponse(String orderCode, String coinCode, String address, String amountPaid, String protocolName, Integer paymentStatus, boolean result) {
        this.orderCode = orderCode;
        this.coinCode = coinCode;
        this.address = address;
        this.amountPaid = amountPaid;
        this.protocolName = protocolName;
        this.paymentStatus = paymentStatus;
        this.result = result;
    }

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

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
