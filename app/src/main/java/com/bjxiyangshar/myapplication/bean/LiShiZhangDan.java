package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class LiShiZhangDan {

    /**
     * code : 0
     * time : 1506569930136
     * msg :
     * result : {"settlelist":[{"settlement_total":200,"cycle_begin":"2017-09-21","settlement_date":1506787200000,"settlement_id":3,"sharer_id":1,"cycle_end":"2017-09-30","settlement_satues":3,"settlement_man":"磊磊"},{"settlement_total":10000,"cycle_begin":"2017-07-10","settlement_date":1500566400000,"settlement_id":1,"sharer_id":1,"cycle_end":"2017-07-20","settlement_satues":0,"settlement_man":"崔鹏飞"}]}
     */

    private int code;
    private long time;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<SettlelistBean> settlelist;

        public List<SettlelistBean> getSettlelist() {
            return settlelist;
        }

        public void setSettlelist(List<SettlelistBean> settlelist) {
            this.settlelist = settlelist;
        }

        public static class SettlelistBean {
            /**
             * settlement_total : 200.0
             * cycle_begin : 2017-09-21
             * settlement_date : 1506787200000
             * settlement_id : 3
             * sharer_id : 1
             * cycle_end : 2017-09-30
             * settlement_satues : 3
             * settlement_man : 磊磊
             */

            private double settlement_total;
            private String cycle_begin;
            private long settlement_date;
            private int settlement_id;
            private int sharer_id;
            private String cycle_end;
            private int settlement_satues;
            private String settlement_man;

            public double getSettlement_total() {
                return settlement_total;
            }

            public void setSettlement_total(double settlement_total) {
                this.settlement_total = settlement_total;
            }

            public String getCycle_begin() {
                return cycle_begin;
            }

            public void setCycle_begin(String cycle_begin) {
                this.cycle_begin = cycle_begin;
            }

            public long getSettlement_date() {
                return settlement_date;
            }

            public void setSettlement_date(long settlement_date) {
                this.settlement_date = settlement_date;
            }

            public int getSettlement_id() {
                return settlement_id;
            }

            public void setSettlement_id(int settlement_id) {
                this.settlement_id = settlement_id;
            }

            public int getSharer_id() {
                return sharer_id;
            }

            public void setSharer_id(int sharer_id) {
                this.sharer_id = sharer_id;
            }

            public String getCycle_end() {
                return cycle_end;
            }

            public void setCycle_end(String cycle_end) {
                this.cycle_end = cycle_end;
            }

            public int getSettlement_satues() {
                return settlement_satues;
            }

            public void setSettlement_satues(int settlement_satues) {
                this.settlement_satues = settlement_satues;
            }

            public String getSettlement_man() {
                return settlement_man;
            }

            public void setSettlement_man(String settlement_man) {
                this.settlement_man = settlement_man;
            }
        }
    }
}
