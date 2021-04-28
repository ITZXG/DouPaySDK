package me.doupay.sdk.bean;

public class OrderInfoResponseData {
    private String code;
    private String coinCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    @Override
    public String toString() {
        return "OrderInfoResponseData{" +
                "code='" + code + '\'' +
                ", coinCode='" + coinCode + '\'' +
                '}';
    }
}
