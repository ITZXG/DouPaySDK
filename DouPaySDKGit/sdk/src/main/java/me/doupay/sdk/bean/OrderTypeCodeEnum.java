package me.doupay.sdk.bean;

public enum OrderTypeCodeEnum {
    MoneyBuy("0001","金额买"),
    CountBuy("0002","数量买");
    private String key;
    private String value;

    OrderTypeCodeEnum(String key, String value) {
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
