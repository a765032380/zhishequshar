package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class LiShiZhangDanXiangQing {

    /**
     * code : 0
     * msg :
     * result : {"maxsettle":21.2,"settleMentDetail":[{"days":"10","sumafter":1.2},{"days":"11","sumafter":1.2},{"days":"12","sumafter":1.2},{"days":"13","sumafter":1.2},{"days":"14","sumafter":1},{"days":"15","sumafter":11.4},{"days":"16","sumafter":1.4},{"days":"17","sumafter":1.2},{"days":"19","sumafter":1.2},{"days":"20","sumafter":1.2},{"days":"21","sumafter":21.2}]}
     * time : 1506571581077
     */

    private int code;
    private String msg;
    private ResultBean result;
    private long time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public static class ResultBean {
        /**
         * maxsettle : 21.2
         * settleMentDetail : [{"days":"10","sumafter":1.2},{"days":"11","sumafter":1.2},{"days":"12","sumafter":1.2},{"days":"13","sumafter":1.2},{"days":"14","sumafter":1},{"days":"15","sumafter":11.4},{"days":"16","sumafter":1.4},{"days":"17","sumafter":1.2},{"days":"19","sumafter":1.2},{"days":"20","sumafter":1.2},{"days":"21","sumafter":21.2}]
         */

        private double maxsettle;
        private List<SettleMentDetailBean> settleMentDetail;

        public double getMaxsettle() {
            return maxsettle;
        }

        public void setMaxsettle(double maxsettle) {
            this.maxsettle = maxsettle;
        }

        public List<SettleMentDetailBean> getSettleMentDetail() {
            return settleMentDetail;
        }

        public void setSettleMentDetail(List<SettleMentDetailBean> settleMentDetail) {
            this.settleMentDetail = settleMentDetail;
        }

        public static class SettleMentDetailBean {
            /**
             * days : 10
             * sumafter : 1.2
             */

            private String days;
            private double sumafter;

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public double getSumafter() {
                return sumafter;
            }

            public void setSumafter(double sumafter) {
                this.sumafter = sumafter;
            }
        }
    }
}
