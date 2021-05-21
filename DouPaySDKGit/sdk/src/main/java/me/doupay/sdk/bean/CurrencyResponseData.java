package me.doupay.sdk.bean;

public class CurrencyResponseData {
    /**
     * 简称
     */
    private String currency;
    /**
     * 是否默认 0否 1是
     */
    private int isDefault;
    /**
     * 名称
     */
    private String name;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrencyResponseData{" +
                "currency='" + currency + '\'' +
                ", isDefault=" + isDefault +
                ", name='" + name + '\'' +
                '}';
    }
}
