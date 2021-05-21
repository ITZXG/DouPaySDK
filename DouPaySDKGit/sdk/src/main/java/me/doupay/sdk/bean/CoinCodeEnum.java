package me.doupay.sdk.bean;

public enum CoinCodeEnum {

//    String BTCCoinCode = "0001";
//    String ETHCoinCode = "0002";
//    String TRXCoinCode = "0003";
//    String USDTCoinCode = "0004";

    BTC("0001","BTC"),
    ETH("0002","ETH"),
    TRX("0003","TRX"),
    USDT("0004","USDT");


    private String key;
    private String value;

    CoinCodeEnum(String key, String value) {
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
