package me.doupay.sdk.bean;

import java.util.List;

public class RefundInfoResponseData {


    private List<RecordsBean> records;

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        /**
         * address : 123123
         * description : 退100元的
         * refundStatus : 0
         * orderCode : ZF202105211638306838484070
         * refundCode : 202105211752108481672240
         * refundAmount : 10.00000000
         */

        private String address;
        private String description;
        private int refundStatus;
        private String orderCode;
        private String refundCode;
        private String refundAmount;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(int refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getRefundCode() {
            return refundCode;
        }

        public void setRefundCode(String refundCode) {
            this.refundCode = refundCode;
        }

        public String getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(String refundAmount) {
            this.refundAmount = refundAmount;
        }
    }
}
