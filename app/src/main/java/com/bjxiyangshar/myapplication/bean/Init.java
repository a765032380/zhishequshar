package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class Init {

    /**
     * code : 0
     * time : 1506678149966
     * msg :
     * result : {"todaycommodity":0,"tradingList":[{"summoney":"376.6","month":"09","communityName":"鹏景阁","communityId":4},{"communityName":"测试2","communityId":3}],"totalmoney":16623.6,"todaymoney":0,"remaining":6,"settlement":3}
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
        /**
         * todaycommodity : 0
         * tradingList : [{"summoney":"376.6","month":"09","communityName":"鹏景阁","communityId":4},{"communityName":"测试2","communityId":3}]
         * totalmoney : 16623.6
         * todaymoney : 0
         * remaining : 6
         * settlement : 3
         */

        private int todaycommodity;
        private double totalmoney;
        private int todaymoney;
        private int remaining;
        private int settlement;
        private List<TradingListBean> tradingList;

        public int getTodaycommodity() {
            return todaycommodity;
        }

        public void setTodaycommodity(int todaycommodity) {
            this.todaycommodity = todaycommodity;
        }

        public double getTotalmoney() {
            return totalmoney;
        }

        public void setTotalmoney(double totalmoney) {
            this.totalmoney = totalmoney;
        }

        public int getTodaymoney() {
            return todaymoney;
        }

        public void setTodaymoney(int todaymoney) {
            this.todaymoney = todaymoney;
        }

        public int getRemaining() {
            return remaining;
        }

        public void setRemaining(int remaining) {
            this.remaining = remaining;
        }

        public int getSettlement() {
            return settlement;
        }

        public void setSettlement(int settlement) {
            this.settlement = settlement;
        }

        public List<TradingListBean> getTradingList() {
            return tradingList;
        }

        public void setTradingList(List<TradingListBean> tradingList) {
            this.tradingList = tradingList;
        }

        public static class TradingListBean {
            /**
             * summoney : 376.6
             * month : 09
             * communityName : 鹏景阁
             * communityId : 4
             */

            private String summoney;
            private String month;
            private String communityName;
            private int communityId;

            public String getSummoney() {
                return summoney;
            }

            public void setSummoney(String summoney) {
                this.summoney = summoney;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public int getCommunityId() {
                return communityId;
            }

            public void setCommunityId(int communityId) {
                this.communityId = communityId;
            }
        }
    }
}
