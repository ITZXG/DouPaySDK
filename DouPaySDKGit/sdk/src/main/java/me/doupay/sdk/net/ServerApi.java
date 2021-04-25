package me.doupay.sdk.net;

import java.util.Map;

import io.reactivex.Observable;
import me.doupay.sdk.bean.ContractCoinVo;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ServerApi {
    ServerApi SERVICE_API = new RetrofitHelper().getINSTANCE(false).create(ServerApi.class);

    @FormUrlEncoded
    @POST()
    Observable<BaseVo<ContractCoinVo>> test(@Url String url, @FieldMap Map<String, Object> body);


    @FormUrlEncoded
    @POST()
    /*
    * 获取订单信息
    * */
    Observable<BaseVo<ContractCoinVo>> getOrderInfo(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 获取支付信息
    * */
    Observable<BaseVo<ContractCoinVo>> getPaymentInfo(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 获取支付方式
    * */
    Observable<BaseVo<ContractCoinVo>> getPaymentMethod(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 付款
    * */
    Observable<BaseVo<ContractCoinVo>> gotoPay(@Url String url, @FieldMap Map<String, Object> body);

    @FormUrlEncoded
    @POST()
    /*
    * 退款
    * */
    Observable<BaseVo<ContractCoinVo>> gotoRefund(@Url String url, @FieldMap Map<String, Object> body);
}
