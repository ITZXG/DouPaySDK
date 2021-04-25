package me.doupay.sdk;

import me.doupay.sdk.net.ServerApi;

import java.util.HashMap;
import java.util.Map;

public class PaymentInfo {

    public static void test(String appid,String key) {
        Map<String, Object> map = new HashMap<>();
        map.put("appId",appid);
        map.put("key",key);
        ServerApi.SERVICE_API.test(Constants.basrUrl + "asc1/test6",map);
    }

    public  static  void getOrderInfo (String orderCode,String appId) {
        Map<String,Object> map = new HashMap<>();
        map.put("appId",appId);
        map.put("orderCode",orderCode);
        ServerApi.SERVICE_API.getOrderInfo(Constants.basrUrl + "trade/v1.0/getOrderInfo",map);
    }

    public static  void getPaymentInfo (String coinCode,String orderCode,String appId) {
        Map<String,Object> map = new HashMap<>();
        map.put("coinCode",coinCode);
        map.put("orderCode",orderCode);
        ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/v1.0/getPaymentInfo",map);
    }

    public  static void getPaymentMethod(String code,String coinCode,String appId) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("coinCode",coinCode);
        ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/v1.0/getPaymentInfo",map);
    }

    public  static void  pay (String appId,String body,String channel,
                              String clientIp,String currency,String description,
                              Long expireTime,String money,String orderNo,
                              String subject,String userAccount
                              ) {
        Map<String,Object> map = new HashMap<>();
        map.put("appId",appId);
        map.put("body",body);
        map.put("channel",channel);
        map.put("clientIp",clientIp);
        map.put("currency",currency);
        map.put("description",description);
        map.put("expireTime",expireTime);
        map.put("money",money);
        map.put("orderNo",orderNo);
        map.put("subject",subject);
        map.put("userAccount",userAccount);
        ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/v1.0/pay",map);
    }

    public  static void refund(String description,String merchantOrderNo,String money) {
        Map<String,Object> map = new HashMap<>();
        map.put("description",description);
        map.put("merchantOrderNo",merchantOrderNo);
        map.put("money",money);

        ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/v1.0/refund",map);
    }
}
