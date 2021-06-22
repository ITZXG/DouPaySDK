package me.doupay.sdk;

import me.doupay.sdk.bean.*;
import me.doupay.sdk.interfaceCallback.CallBackListener;
import org.junit.Test;


public class SDKtest {


    public  static  void  initAllParameters() {
        String timeStamp = "1610697341483";
        String appId = "502808ee5427490abb40375022e28578";
        String secret = "c67100f61bfc684a8a288190026b53fb";
        String privateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDIZiI+x2Ic2ouxR6seBgj/kuTfNMxcGbdexssw6e0F7n+/BhArV/71xkQMHW31iDM51rbWuyyzZxv9tsfqTjXCO3kzn1/Y4e6iSF+x7RK49J6OlozSVEBA/sBTvi27UmbGd8RPCfPln5vaGMRpJuctgFT+gAybLCYcBrxiUjMRMnrtEQuMSFPsuhcec5t+C4ZSG1HQ0tJPAHFeus9qiNqLMIshLwvyiyiJybjYFSjTKjNDyrX8J4nm1pYtQ1O1uU4ZroBGZKBzIDoZHO93XmVrS6m/MKHpB7Wgzfq3sRPzgVcEaOFptt9uuU2q2FfuqxKvjF7CFR08rpwzY6HrizebAgMBAAECggEAdPLVrVliMoB/4Vd3zy+qdKvfETuYv27qik7tKYB6qGmE94+sQ/84dWndMEzEbPOtIWXikfHtpkzYEvpmNKCr0swucSfjIYjIYMBnyEgYEwP+vCuzxtMQJF4HE1f7DESMYepnD9E5GppIs8CcbtkbNHyeHV/Q+4WKP/TWX3KlBrUrO0YAIQHhkHURblg1g2UvUmP1fGo6AL5v101KrhpXzG99LfDN2qc10EuFq66d6LLnFWJvzW4DC0zCk336z0jyJgAV9y6gCRPKQmgrTJECYGYKY2svDsAtzW7lgjO+33dBxpt0bjqZsc/m7JBJ448Sor8E6cyNGtf2wCS3bin24QKBgQD6oWsyrtFW2/d4Hh8UwAkdQx5oY2swVWX0MGLKxjzqeeeb1WOa/YcbZfj6D+olewNDzWI1zdUcT5lpBAqyWdZkkRV5CsPPlaAAOQyMAXhBCKkIhBINH1j6auKdNKJrNIaApBm4hRRbX7w7EDnuSJJA6EmA/0qesDVAt3htkqLZ6QKBgQDMsThmGtSxoJl7yLI1rE6eLlvJVg9NZxfNDLwc7g1hgQEdr5hUuj1bqHjK8VFbMc5lJVpelJYwpO9pezMZdXUMexNHXJVEo2AnvAljmlYeRXm9lpiIpW+DmoE6B2tzZ22Hcn5y+p9v9j0ZDawQfgXt1rm7XTotGywrpsmeimdO4wKBgQCADiukaLfjBl7Jy7IbuwatIdcOhQWGW4vNGU/QxTronsKc14md7j2y3QY6VhlPbyu639x3GyTw4ybCBmOkvswQ9CQhhUOI860dkAh+HF4h9FfRVxGWDNc8k5IXuoXl+p9iaPYPVkeRbDfTgbXnrsKzUTwFIesxa1y6JUPt0EdOyQKBgGhkue7ZIEC3N4/5+2mER1RFMGquiX9gZLMfG5Fll01zDa6mL3qGwWRNt81I5cUs0aakNkKmZTLJ65BQVO9XCCslWd+7SCWJbTDWpbM2s1Uc+cnHVGPce9MSqXV+8z4YMbQyoGrjhw0C+IYegvKmUz/Jk1ALa/A1O4HHvmwtCiMhAoGAct3TFXFbn6zruHSstncJGtS1c3EzcrBCb6NhAG5GfqiKXqXY0wl/0plPffovH5okcMZiRLX2DPRLdkuDZSVYFDpJgED5C4M+62YiW33Sel5aDCIXME5rkmvAbYrqR7t7r4rj5JjPvvNiBPsPfHsvIEHqW2Y1eY87clsu++BkU/4=";
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyGYiPsdiHNqLsUerHgYI/5Lk3zTMXBm3XsbLMOntBe5/vwYQK1f+9cZEDB1t9YgzOda21rsss2cb/bbH6k41wjt5M59f2OHuokhfse0SuPSejpaM0lRAQP7AU74tu1JmxnfETwnz5Z+b2hjEaSbnLYBU/oAMmywmHAa8YlIzETJ67RELjEhT7LoXHnObfguGUhtR0NLSTwBxXrrPaojaizCLIS8L8osoicm42BUo0yozQ8q1/CeJ5taWLUNTtblOGa6ARmSgcyA6GRzvd15la0upvzCh6Qe1oM36t7ET84FXBGjhabbfbrlNqthX7qsSr4xewhUdPK6cM2Oh64s3mwIDAQAB";

        Constants.openSysLog = true;
        Constants.getInstance().init(secret,privateKey,publicKey,appId,"3600000");
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
                PaymentInfo.pay("10000", CoinCodeEnum.BTC, CurrencyCodeEnum.CNY, "17701278922", orderNo,
                "可口可乐哈哈哈哈", "哈哈哈,好喝极了,哈哈哈,好喝极了", "很好的可口可乐,大傻逼脑残", OrderTypeCodeEnum.MoneyBuy, new CallBackListener<PayResponseData>() {
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
        PaymentInfo.getOrderInfo("ZF202105211638306838484070", new CallBackListener<OrderInfoResponseData>() {
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

        PaymentInfo.getPaymentInfo("0004","" ,"ZF202105211638306838484070", new CallBackListener<PaymentInfoResponseData>() {
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
        PaymentInfo.refund("123123", "10", "ZF202105211638306838484070", "退100元的", new CallBackListener<RefundResponseData>() {
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
        PaymentInfo.getRefunds("ZF202105211638306838484070", new CallBackListener<RefundInfoResponseData>() {
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
    public void test2 () {
        initAllParameters();
//        PaymentInfo.test2("121212", new CallBackListener<RefundInfoResponseData>() {
//            @Override
//            public void onFinish(RefundInfoResponseData data) {
//                System.out.println("++++++++++++++++" + data.toString());
//            }
//
//            @Override
//            public void onError(int errorCode, String msg) {
//                System.out.println(errorCode + "-------------------------" + msg);
//            }
//        });

        String bodystring = "{\"address\":\"TQ1EgPhuDXLvDfycCBQadbfbLkBPhEDoZX\",\"amountPaid\":15.26717557,\"coinName\":\"USDT\",\"orderCode\":\"ZF202106221133335640422688\",\"paymentStatus\":1,\"protocolName\":\"TRC20\",\"result\":true}";
        String headstring = "uCJasnGz3H+2Xi86zeRkoDVEaXpM0LsCInOW1Kk28pn/3bXMn/2vUac7aQrWUzcf8YjTiXJt03IzS6k0y04TsvL1rdOj7TZgrk2aav8wM79ECviDW1+OQWd2XRhCRJGL4ca5lnXiE+1eHV5Tdq68Nu50tOkTKGI6cD3LT6imEWq5bTB0I+xuabnhSDfhWdmogmzEwKju3xSPcjxtzHGJ/c8Zc1NYH7ID92qWi77Wm6/UskHiATgULXYCbLHL/hBFDn4kGH8E+FQ0oSoPOTLOvpKnI27v6xD7CyHhMUOYRaVm5u/X4YNta65hF//JVPLnMw8I9NJA9WklDPFZ1DvIQQ==";
        PaymentInfo.verifySignAndGetResult(headstring, bodystring, new CallBackListener<PaymentResultResponse>() {
            @Override
            public void onFinish(PaymentResultResponse data) {

            }

            @Override
            public void onError(int errorCode, String msg) {

            }
        });
    }




}