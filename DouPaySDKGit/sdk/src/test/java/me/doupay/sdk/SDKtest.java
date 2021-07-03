package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import org.junit.Test;

import java.time.LocalDateTime;


public class SDKtest {


    public  static  void  initAllParameters() {
        String timeStamp = "1610697341483";
        String appId = "502808ee5427490abb40375022e28578";
        String secret = "c67100f61bfc684a8a288190026b53fb";
        String privateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCQvYSsFqKCNv2tzjsoPIgpDhR+01URpjvyUbyinKhCdDZuTY2AvlbmqPtMBBtKrUxvKl/0G9VQS4mfI8Gel8c9SrSVtPzagjVIypSMiRKU8xsNtNLc1ZM7Tl59bgJVeZPnPUsRvL1ckbFQTLMKxViPXT0DILE6Rf4cUNeIG3pTdyF07uRxpMpCG7geHyp0OlYLVzlrMWSqaxW1Xp7X/wia72kez5NGfo3UK4QHtc/AQ63F2YHlRDKVw9DMcdEA+ZodE3LZmCEXtFQCxiBEY9jqY7568KY2DP6p8OpXugYts4L/9lAQWAMkqWWByjsRr9fE3ejt2h5+vrY1FYUbm5X1AgMBAAECggEAa9X3Eatveep0h9h9tJWcsFHALVlQKO0b/oatLs3eglxI7Vc0VLX60rEVQOZSWwnQR4ZfpORTwhX1O66NI5ZbJ6wP7PXB6R5Xipr7n9TEFlslTcnpzAQHRIk31uVuMbZ53i+JTXa78krNu1DZl+299Fn4CeuCfzMEhp4oZkxqj+GrzImfXxBxov6Afbf56KSgjnpKARP9NG8imuPcIoqPEXGLz1urpAHzfhShdSbw2uYDTrBD/jwBES/9zWJZAy4w6RxKapDa8VrP3q9wN6B6QjkQLgBFdpogGlct0gQxaQLYUqyPq0Wu0iJ5uaeCCI7TlZMOYt3xQPtqhz/IBr3MhQKBgQD02hFwVy/MisakrZ6c3HQb2pe9r5h1jkJnMxCMIgpVMy8vB8R7JA/7CVG2GkPn0/gMermgo54sl7U5Dga0WjSua5IARTxbuLxUbkEx6q3D/Y7rdhLOhKYfDRGevFuSyHIBVyZT1WMwSD5ScocAupr4zQfV8OTeO4taABoGa12KgwKBgQCXVJM+nFO8faygUq7Jr1VkQnxhgWEQKN8UiaSKX/o9TSpoJniRcYkEOCP4FRcmShPiqNW9hHx/THiUfxZgsT0Jj6k5NMREPXDn8S1c63PaTgDhDd8mnyyRT7Wji/cGbIbOhONUhJ+4AzcEdmF3RiMKxBr9Bo0NDfRWLeRp6w3UJwKBgQDLobBvJZNzINcjjeEjw5QsthcMgkThP3aqLSXN5WGCihbrniIh51QDCzURpbZjzz2z4z0OBAVAQMtOsAOTapH1nTDHWM1h2rmF3kwKH4p0PSPnX0M0zcz6dfv5b90YretiggA2KHldZjeuieENEiRgVuP1YWp2CD9UklESlagt0QKBgGUSJKHNkRO0MCaH8ptbkkG7Mg2Bds1vLsctwwp0XdKxhiA3iZFCbgu2XzejBmoZUbyxnMfOA8SV03cChnSgC68mFxTRDECzdIRFDVIhI6hrLqUhOag26XJH9X28zoio1UR7dsWNKouhAg7l7eTWoDLhlVDnHi/Y4Rbp4cNoLT1DAoGAShOsIiWzCaJFXpSH1SwL925QURbU8N+N7rZT1xIWqJi/aBMpYQInvEKgvj7EV75JEGGFPokcO0TElLDR1gZqiq2WgDk9pu1aPPcc5sjnKQ+K0bEYxeheBT9CkJB3sSrJwhdlVcp9gLqgJq39SaNSmjbwszLCQp7KoEOxGTsNXQo=";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyGYiPsdiHNqLsUerHgYI/5Lk3zTMXBm3XsbLMOntBe5/vwYQK1f+9cZEDB1t9YgzOda21rsss2cb/bbH6k41wjt5M59f2OHuokhfse0SuPSejpaM0lRAQP7AU74tu1JmxnfETwnz5Z+b2hjEaSbnLYBU/oAMmywmHAa8YlIzETJ67RELjEhT7LoXHnObfguGUhtR0NLSTwBxXrrPaojaizCLIS8L8osoicm42BUo0yozQ8q1/CeJ5taWLUNTtblOGa6ARmSgcyA6GRzvd15la0upvzCh6Qe1oM36t7ET84FXBGjhabbfbrlNqthX7qsSr4xewhUdPK6cM2Oh64s3mwIDAQAB";

        Constants.openSysLog = true;
        Constants.getInstance().init(secret,privateKey,publicKey,appId,"200");
    }

    @Test
    public void getCoinList () {
        initAllParameters();
        PaymentInfo.getCoinList(new CallBackListener<CoinResponseData>() {
            @Override
            public void onFinish(CoinResponseData data) {
                System.out.println("-------------------------" + data.toString());

            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);

            }
        });
    }
    @Test
    public void getCurrencyList() {
        initAllParameters();
        PaymentInfo.getCurrencyList(new CallBackListener<CurrencyResponseData>() {
            @Override
            public void onFinish(CurrencyResponseData data) {
                System.out.println("-------------------------" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }


    @Test
    public void getPay() {
                 initAllParameters();
                String orderNo = String.valueOf(System.currentTimeMillis());
                PaymentInfo.pay("2", CoinCodeEnum.USDT, CurrencyCodeEnum.CNY, "17701278922", orderNo,
                "我很好啊啊", "", "", OrderTypeCodeEnum.CountBuy, new CallBackListener<PayResponseData>() {
                    @Override
                    public void onFinish(PayResponseData data) {
                        System.out.println("++++++++++++++++" + data.toString());
                    }

                    @Override
                    public void onError(int errorCode, String msg) {
                        System.out.println(errorCode + "-------------------------" + msg);
                    }
                });
    }

    @Test
    public void cancle() {
        initAllParameters();
        PaymentInfo.cancleOrder("ZF202107031430314990720038", new CallBackListener<PayResponseData>() {
            @Override
            public void onFinish(PayResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getOrderInfo() {
        initAllParameters();
        PaymentInfo.getOrderInfo("ZF202107031429308835343624", new CallBackListener<OrderInfoResponseData>() {
            @Override
            public void onFinish(OrderInfoResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getPaymentInfo() {
        initAllParameters();

        PaymentInfo.getPaymentInfo("0001","" ,"ZF202107031353384554486189", new CallBackListener<PaymentInfoResponseData>() {
            @Override
            public void onFinish(PaymentInfoResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());

            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);

            }
        });
    }

    @Test
    public void getRefund() {
        initAllParameters();
        PaymentInfo.refund("TEQrvHyU54YibVHMGb7475n8y3mXBofaaR", "5", "ZF202107031353384554486189", "退0.5个,啦啦啦", new CallBackListener<RefundResponseData>() {
            @Override
            public void onFinish(RefundResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }

    @Test
    public void getRefundInfo() {
        initAllParameters();
        PaymentInfo.getRefunds("ZF202107021555237920508776", new CallBackListener<RefundInfoResponseData>() {
            @Override
            public void onFinish(RefundInfoResponseData data) {
                System.out.println("++++++++++++++++" + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println(errorCode + "-------------------------" + msg);
            }
        });
    }


    @Test
    public void verifySignAndGetResult () {
        initAllParameters();

        String bodystring = "{\"address\":\"TQ1EgPhuDXLvDfycCBQadbfbLkBPhEDoZX\",\"amountPaid\":\"15.26717557\",\"coinName\":\"USDT\",\"orderCode\":\"ZF202106221133335640422688\",\"paymentStatus\":1,\"protocolName\":\"TRC20\",\"result\":true}";
        String headstring = "uCJasnGz3H+2Xi86zeRkoDVEaXpM0LsCInOW1Kk28pn/3bXMn/2vUac7aQrWUzcf8YjTiXJt03IzS6k0y04TsvL1rdOj7TZgrk2aav8wM79ECviDW1+OQWd2XRhCRJGL4ca5lnXiE+1eHV5Tdq68Nu50tOkTKGI6cD3LT6imEWq5bTB0I+xuabnhSDfhWdmogmzEwKju3xSPcjxtzHGJ/c8Zc1NYH7ID92qWi77Wm6/UskHiATgULXYCbLHL/hBFDn4kGH8E+FQ0oSoPOTLOvpKnI27v6xD7CyHhMUOYRaVm5u/X4YNta65hF//JVPLnMw8I9NJA9WklDPFZ1DvIQQ==";
        PaymentInfo.verifySignAndGetResult(headstring, bodystring, new CallBackListener<PaymentResultResponse>() {
            @Override
            public void onFinish(PaymentResultResponse data) {
            System.out.println("PaymentResultResponse = " + data.toString());
            }

            @Override
            public void onError(int errorCode, String msg) {
                System.out.println("errorCode=" + errorCode + "msg =" + msg);

            }
        });
    }

    @Test
    public void  getBillRecord () {
        initAllParameters();
        LocalDateTime start =  LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();
        PaymentInfo.getBillRecords("502808ee5427490abb40375022e28578", null, null, 10, 1, new CallBackListener<BillRecord>() {
            @Override
            public void onFinish(BillRecord data) {

            }

            @Override
            public void onError(int errorCode, String msg) {

            }
        });
    }



}