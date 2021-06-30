package me.doupay.sdk.net;

import java.util.Map;

import io.reactivex.Observable;
import me.doupay.sdk.bean.*;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ServerApi {
    ServerApi SERVICE_API = new RetrofitHelper().getINSTANCE(false).create(ServerApi.class);
    /*
     * 获取币种列表
     * */
    @FormUrlEncoded
    @POST()
    Observable<BaseVo<CoinResponseData>> getCoinList(@Url String url, @FieldMap Map<String, Object> body);
    /*
     * 获取法币列表
     * */
    @FormUrlEncoded
    @POST()
    Observable<BaseVo<CurrencyResponseData>> getCurrencyList(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 获取订单信息
    * */
    Observable<BaseVo<OrderInfoResponseData>> getOrderInfo(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 获取支付信息
    * */
    Observable<BaseVo<PaymentInfoResponseData>> getPaymentInfo(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 付款
    * */
    Observable<BaseVo<PayResponseData>> gotoPay(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 退款
    * */
    Observable<BaseVo<RefundResponseData>> gotoRefund(@Url String url, @FieldMap Map<String, Object> body);


    @FormUrlEncoded
    @POST()
        /*
         * 获取退款信息
         * */
    Observable<BaseVo<RefundInfoResponseData>> getRefundInfo(@Url String url, @FieldMap Map<String, Object> body);
    @FormUrlEncoded
    @POST()
        /*
         * 获取账单
         * */
    Observable<BaseVo<BillRecord>> getBillRecord(@Url String url, @FieldMap Map<String, Object> body);
    @FormUrlEncoded
    @POST()
        /*
         * 取消订单
         * */
    Observable<BaseVo<PayResponseData>> cancleOrder(@Url String url, @FieldMap Map<String, Object> body);
}
