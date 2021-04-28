package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import me.doupay.sdk.net.BaseVoObserver;
import me.doupay.sdk.net.ServerApi;

import java.util.HashMap;
import java.util.Map;

public class PaymentInfo {

    public static void test(String appid,String key) {



        Map<String, Object> map = new HashMap<>();
        map.put("appId",appid);
        map.put("key",key);
        ServerApi.SERVICE_API.test(Constants.basrUrl + "asc1/test6",map).subscribe(new BaseVoObserver<ContractCoinVo>(){
            @Override
            public void onPlaintextSuccess(ContractCoinVo data) {
                System.out.println(data.toString());

            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + msg);

            }
        });
    }
/*
获取订单信息
 */
    public  static  void getOrderInfo(String orderCode, CallBackListener<OrderInfoResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init(secret,privateKey)");
            return;
        }
        if (orderCode.isEmpty()) {
            listener.onError(9999,"缺少必要参数");
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        ServerApi.SERVICE_API.getOrderInfo(Constants.basrUrl + "trade/v1.0/getOrderInfo",map).subscribe(new BaseVoObserver<OrderInfoResponseData>(){
            @Override
            public void onPlaintextSuccess(OrderInfoResponseData data) {
                if (listener != null) {
                    listener.onFinish(data);
                }
            }

            @Override
            public void onError(int errorCode, String msg) {
                if (listener != null) {
                    listener.onError(errorCode,msg);
                }

            }
        });
    }
/*
获取支付信息
 */
    public static  void getPaymentInfo (String coinCode, String orderCode, CallBackListener<PaymentInfoResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init(secret,privateKey)");
            return;
        }
        if (orderCode.isEmpty() || coinCode.isEmpty()) {
            listener.onError(9999,"缺少必要参数");
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("coinCode",coinCode);
        map.put("orderCode",orderCode);
        ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/v1.0/getPaymentInfo",map).subscribe(new BaseVoObserver<PaymentInfoResponseData>(){
            @Override
            public void onPlaintextSuccess(PaymentInfoResponseData data) {
                if (listener != null) {
                    listener.onFinish(data);
                }
            }

            @Override
            public void onError(int errorCode, String msg) {
                if (listener != null) {
                    listener.onError(errorCode,msg);
                }
            }
        });
    }
/*
获取支付方式
 */
    public  static void getPaymentMethod(String code,String coinCode,String appId,CallBackListener<PaymentMethodResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init(secret,privateKey)");
            return;
        }
        if (code.isEmpty() || coinCode.isEmpty()) {
            listener.onError(9999,"缺少必要参数");
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("coinCode",coinCode);
        ServerApi.SERVICE_API.getPaymentMethod(Constants.basrUrl + "trade/v1.0/getPaymentMethod",map).subscribe(new BaseVoObserver<PaymentMethodResponseData>(){
            @Override
            public void onPlaintextSuccess(PaymentMethodResponseData data) {
                if (listener != null) {
                    listener.onFinish(data);
                }
            }

            @Override
            public void onError(int errorCode, String msg) {
                if (listener != null) {
                    listener.onError(errorCode,msg);
                }
            }
        });
    }
    /*
    付款
     */
    public  static void  pay (String appId,String body,String channel,
                              String clientIp,String currency,String description,
                              Long expireTime,String money,String orderNo,
                              String subject,String userAccount,CallBackListener<PayResponseData> listener
                              ) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init(secret,privateKey)");
            return;
        }
        if (appId.isEmpty() || body.isEmpty() || channel.isEmpty()
                || currency.isEmpty() || description.isEmpty() || expireTime == null
                || money.isEmpty() || orderNo.isEmpty() || subject.isEmpty()
            ) {
            listener.onError(9999,"缺少必要的参数");
            return;
        }

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
        ServerApi.SERVICE_API.gotoPay(Constants.basrUrl + "trade/v1.0/pay",map).subscribe(new BaseVoObserver<PayResponseData>(){
            @Override
            public void onPlaintextSuccess(PayResponseData data) {
                if (listener != null) {
                    listener.onFinish(data);
                }
            }

            @Override
            public void onError(int errorCode, String msg) {
                if (listener != null) {
                    listener.onError(errorCode,msg);
                }
            }
        });
    }
    /*
    退款
     */
    public  static void refund(String description,String merchantOrderNo,String money,CallBackListener<RefundResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init(secret,privateKey)");
            return;
        }
        if (description.isEmpty() || merchantOrderNo.isEmpty()) {
            listener.onError(9999,"缺少必要的参数");
            return;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("description",description);
        map.put("merchantOrderNo",merchantOrderNo);
        map.put("money",money);

        ServerApi.SERVICE_API.gotoRefund(Constants.basrUrl + "trade/v1.0/refund",map).subscribe(new BaseVoObserver<RefundResponseData>(){
            @Override
            public void onPlaintextSuccess(RefundResponseData data) {
                if (listener != null) {
                    listener.onFinish(data);
                }
            }

            @Override
            public void onError(int errorCode, String msg) {
                if (listener != null) {
                    listener.onError(errorCode,msg);
                }
            }
        });
    }
}
