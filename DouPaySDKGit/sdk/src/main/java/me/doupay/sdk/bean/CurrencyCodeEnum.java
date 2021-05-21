package me.doupay.sdk.bean;

public enum CurrencyCodeEnum {
    CNY("cny","人民币"),
    USA("usd","美元");

    private String key;
    private String value;

    CurrencyCodeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
