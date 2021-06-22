package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import me.doupay.sdk.net.BaseVoObserver;
import me.doupay.sdk.net.ServerApi;
import me.doupay.sdk.sign.RSAUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PaymentInfo {
    /**
     * 获取币种列表
     * @param listener 回调
     */
    public static void  getCoinList (CallBackListener<CoinResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()");
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("test","test");
        ServerApi.SERVICE_API.getCoinList(Constants.basrUrl + "trade/getCoinList",map).subscribe(new BaseVoObserver<CoinResponseData>(){
            @Override
            public void onPlaintextSuccess(CoinResponseData data) {
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

    /**
     * 获取法币列表
     * @param listener 回调
     */
    public static void getCurrencyList(CallBackListener<CurrencyResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()");
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("test","test");
        ServerApi.SERVICE_API.getCurrencyList(Constants.basrUrl + "trade/getCurrencyList",map).subscribe(new BaseVoObserver<CurrencyResponseData>(){
            @Override
            public void onPlaintextSuccess(CurrencyResponseData data) {
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

    /**
     * 获取订单信息
     * @param orderCode 订单号【长度20到50】
     * @param listener 回调
     */
    public  static  void getOrderInfo(String orderCode, CallBackListener<OrderInfoResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()");
            return;
        }


        if (orderCode == null || orderCode.isEmpty()) {
            listener.onError(9999,"缺少必要参数");
            return;
        }

        if (orderCode.length() > 50 || orderCode.length() < 20) {
            listener.onError(9999,"orderCode长度20到50");
            return;
        }


        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);
        ServerApi.SERVICE_API.getOrderInfo(Constants.basrUrl + "trade/getOrderInfo",map).subscribe(new BaseVoObserver<OrderInfoResponseData>(){
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

 */

    /**
     * 获取支付信息
     * @param coinCode  币种代码【长度4】
     * @param chainCoinCode 链币种代码【长度4】,非必传
     * @param orderCode 订单号【长度10到30】
     * @param listener 回调
     */
    public static  void getPaymentInfo (String coinCode,String chainCoinCode, String orderCode, CallBackListener<PaymentInfoResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()");
            return;
        }

        if (orderCode == null || coinCode == null || orderCode.isEmpty() || coinCode.isEmpty()) {
            listener.onError(9999,"缺少必要参数");
            return;
        }

        if (coinCode.length() != 4) {
            listener.onError(9999,"coinCode长度为4");
            return;
        }
        if (orderCode.length() < 10 || orderCode.length() > 30) {
            listener.onError(9999,"orderCode长度为10到30");
            return;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("coinCode",coinCode);
        map.put("orderCode",orderCode);
        if (chainCoinCode != null && !chainCoinCode.isEmpty()) {
            map.put("chainCoinCode",chainCoinCode);
        }
        ServerApi.SERVICE_API.getPaymentInfo(Constants.basrUrl + "trade/getPaymentInfo",map).subscribe(new BaseVoObserver<PaymentInfoResponseData>(){
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

    /**
     * 付款,当orderType为0001时,amount内容为金额,currencyCode为必传,当orderType为0002时amount内容为数量,coinCode为必传
     * @param amount        金额(0001)
     * @param coinCode      币种(0002)【长度4】
     * @param currencyCode  法币(0001:人民币cny,美元usa)【长度3到4】
     * @param merchantUser  商家用户【长度10到20之间】
     * @param orderNo       订单号【长度10到30】
     * @param subject       商品标题【长度5~10】
     * @param body          商品描述信息【长度10到100】
     * @param description   附加说明【长度10到50】
     * @param orderType     订单类型(0001金额 0002数量)【长度4】
     * @param listener      回调
     */
    public  static void  pay (
            String amount, CoinCodeEnum coinCode,CurrencyCodeEnum currencyCode,
            String merchantUser,String orderNo,String subject,
            String body, String description,
            OrderTypeCodeEnum orderType, CallBackListener<PayResponseData> listener
                              ) {
        if (!Constants.getInstance().isInitAllParameters()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()方法");
            return;
        }
        if ( amount == null  || orderNo == null || orderType == null
                || subject == null|| amount.isEmpty()
                ||  orderNo.isEmpty()  || subject.isEmpty()
            ) {
            listener.onError(9999,"缺少必要的参数");
            return;
        }

        if (!orderType.getKey().equals(OrderTypeCodeEnum.MoneyBuy.getKey())
                && !orderType.getKey().equals(OrderTypeCodeEnum.CountBuy.getKey())) {
            listener.onError(9999,"orderType订单类型【0001金额 0002数量】");
            return;
        }

        if (orderType.getKey().equals(OrderTypeCodeEnum.MoneyBuy.getKey())) {
            if (currencyCode == null) {
                listener.onError(9999,"currencyCode不能为空");
                return;
            }

        }

        if (orderType.getKey().equals(OrderTypeCodeEnum.CountBuy.getKey())) {
            if (coinCode == null) {
                listener.onError(9999,"coinCode参数不能为空");
                return;
            }
        }

        if (subject.length() < 5 || subject.length() > 10) {
            listener.onError(9999,"subject长度为5-10");
            return;
        }

        if (orderNo.length() < 10 || orderNo.length() > 30) {
            listener.onError(9999,"orderNo长度为10-30");
            return;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("appId",Constants.getAppId());
        map.put("body",body);
        map.put("description",description);
        map.put("expireTime",Constants.getExpireTime());
        map.put("merchantUser",merchantUser);
        map.put("orderNo",orderNo);
        map.put("orderType",orderType.getKey());
        map.put("subject",subject);
        if (orderType .getKey().equals(OrderTypeCodeEnum.MoneyBuy.getKey())) {
            map.put("money",amount);
            map.put("currency",currencyCode.getKey());
        }
        if (orderType.getKey().equals(OrderTypeCodeEnum.CountBuy.getKey())) {
            map.put("amount",amount);
            map.put("coinCode",coinCode.getKey());
        }
        ServerApi.SERVICE_API.gotoPay(Constants.basrUrl + "trade/pay",map).subscribe(new BaseVoObserver<PayResponseData>(){
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

    /**
     * 退款
     * @param address       退款地址【长度5到50】
     * @param amount        退款数量【长度1到50
     * @param orderCode     订单编号【长度5到50】
     * @param description   退款描述【长度5到50】
     * @param listener      回调
     */
    public  static void refund(String address,String amount,String orderCode,String description,CallBackListener<RefundResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()");
            return;
        }
        if (address ==null || amount == null || description == null || orderCode == null || description.isEmpty() || orderCode.isEmpty() || amount.isEmpty() || address.isEmpty()) {
            listener.onError(9999,"缺少必要的参数");
            return;
        }

        if (address.length() < 5 || address.length() > 50) {
            listener.onError(9999,"退款地址【长度5到50】");
            return;
        }
        if (orderCode.length() < 5 || orderCode.length() > 50) {
            listener.onError(9999,"订单编号【长度5到50】");
            return;
        }
        if (description.length() < 5 || description.length() > 50) {
            listener.onError(9999,"退款描述【长度5到50】");
            return;
        }


        Map<String,Object> map = new HashMap<>();
        map.put("description",description);
        map.put("amount",amount);
        map.put("appId",Constants.getAppId());
        map.put("orderCode",orderCode);
        map.put("address",address);
        ServerApi.SERVICE_API.gotoRefund(Constants.basrUrl + "trade/refund",map).subscribe(new BaseVoObserver<RefundResponseData>(){
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

    /**
     * 获取退款信息
     * @param orderCode     订单编号【长度20到50】
     * @param listener      回调
     */
    public  static void getRefunds(String orderCode,CallBackListener<RefundInfoResponseData> listener) {
        if (Constants.getSecret().isEmpty() || Constants.getPrivateKey().isEmpty()) {
            listener.onError(9999,"请先调用Constants.getInstance().init()");
            return;
        }

        if (orderCode == null || orderCode.isEmpty() ) {
            listener.onError(9999,"缺少必要参数");
            return;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("orderCode",orderCode);

        ServerApi.SERVICE_API.getRefundInfo(Constants.basrUrl + "trade/getRefunds",map).subscribe(new BaseVoObserver<RefundInfoResponseData>(){
            @Override
            public void onPlaintextSuccess(RefundInfoResponseData data) {
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

    /**
     * 验证回调签名并组装回调对象
     * @param headerSignString header中的签名(X-Merchant-sign)
     * @param bodyString  body体内容
     * @param listener 回调结果
     */
    public  static void verifySignAndGetResult (String headerSignString,String bodyString,CallBackListener<PaymentResultResponse> listener) {

        // 拼接成a=b,c=d的形式
        String signString = generateClearTextSign(bodyString);
        // 验证签名
        boolean isRight = RSAUtils.verifySign(Constants.getPublicKey(), signString, headerSignString);

        if (!isRight) { // 验签失败
            listener.onError(9999,"验签失败");
            return;
        }

        JSONObject jsonObject = new JSONObject(bodyString);
        String orderCode = jsonObject.getString("orderCode");
        String coinName = jsonObject.getString("coinName");
        String address = jsonObject.getString("address");
        String amount = jsonObject.getString("amountPaid");
        String protocolName = jsonObject.getString("protocolName");
        Integer paymentStatus = jsonObject.getInt("paymentStatus");
        boolean result = jsonObject.getBoolean("result");

        PaymentResultResponse resultResponse = new PaymentResultResponse(orderCode,coinName,address,amount,protocolName,paymentStatus,result);
        listener.onFinish(resultResponse);

    }

    /**
     * 根据json串生成明文签名
     *
     * @param jsonStr
     * @return
     */
    public static String generateClearTextSign(String jsonStr) {
        JSONObject jsonObject = new  JSONObject(jsonStr);
        Map<String, Object> treeMap = new TreeMap<>();

        for (String key : jsonObject.keySet()) {
                treeMap.put(key, jsonObject.get(key));

        }

        StringBuffer sb = new StringBuffer();
        for (String key : treeMap.keySet()) {
            // 字母序降序排列拼接
            if (!(treeMap.get(key) instanceof List)) {
                sb.append(key + "=" + treeMap.get(key) + ",");
            }else {
                sb.append(key + "=" +  ((List<String>) treeMap.get(key)).get(0) + ",");
            }

        }
//        log.debug("生成商家签名明文：{}", sb.toString().substring(0, sb.length() - 1));
        return sb.toString().substring(0, sb.length() - 1);
    }


    public  static void test2(String orderCode,CallBackListener<RefundInfoResponseData> listener) {


        Map<String,Object> map = new HashMap<>();
        map.put("type","9");
        map.put("loginAccount","2");
        map.put("serviceId","app");
        map.put("operateBeginTime","1620835200000");
        map.put("operateEndTime","1622525937000");
        map.put("pageNum",1);
        map.put("pageSize",10);


        ServerApi.SERVICE_API.test2(Constants.basrUrl + "trade/log",map).subscribe(new BaseVoObserver<RefundInfoResponseData>(){
            @Override
            public void onPlaintextSuccess(RefundInfoResponseData data) {
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
