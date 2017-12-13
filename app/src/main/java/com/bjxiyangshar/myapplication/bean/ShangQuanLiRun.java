package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class ShangQuanLiRun {

    /**
     * code : 0
     * time : 1506584158817
     * msg :
     * result : {"bussnesslistw":[{"sumafter":20.4,"days":"30"},{"sumafter":11.4,"days":"31"},{"sumafter":30.6,"days":"32"},{"sumafter":35,"days":"33"},{"sumafter":7,"days":"34"},{"sumafter":66.2,"days":"35"},{"sumafter":135.3,"days":"36"},{"sumafter":196.4,"days":"37"},{"sumafter":78.9,"days":"38"},{"sumafter":373.7,"days":"39"}],"bussnesslistd":[{"sumafter":23.9,"days":"21"},{"sumafter":3.2,"days":"22"},{"sumafter":10.4,"days":"23"},{"sumafter":1.8,"days":"24"},{"sumafter":11.6,"days":"25"},{"sumafter":12.6,"days":"26"},{"sumafter":340.9,"days":"27"},{"sumafter":11.6,"days":"28"},{"sumafter":20.4,"days":"29"},{"sumafter":2.8,"days":"30"}],"bussnesslistm":[{"sumafter":22.9,"days":"07"},{"sumafter":85.2,"days":"08"},{"sumafter":849.3,"days":"09"}],"sellerlist":[{"sellerId":1,"name":"名称1"},{"sellerId":20,"name":"qqu"}]}
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
        private List<BussnesslistwBean> bussnesslistw;
        private List<BussnesslistdBean> bussnesslistd;
        private List<BussnesslistmBean> bussnesslistm;
        private List<SellerlistBean> sellerlist;

        public List<BussnesslistwBean> getBussnesslistw() {
            return bussnesslistw;
        }

        public void setBussnesslistw(List<BussnesslistwBean> bussnesslistw) {
            this.bussnesslistw = bussnesslistw;
        }

        public List<BussnesslistdBean> getBussnesslistd() {
            return bussnesslistd;
        }

        public void setBussnesslistd(List<BussnesslistdBean> bussnesslistd) {
            this.bussnesslistd = bussnesslistd;
        }

        public List<BussnesslistmBean> getBussnesslistm() {
            return bussnesslistm;
        }

        public void setBussnesslistm(List<BussnesslistmBean> bussnesslistm) {
            this.bussnesslistm = bussnesslistm;
        }

        public List<SellerlistBean> getSellerlist() {
            return sellerlist;
        }

        public void setSellerlist(List<SellerlistBean> sellerlist) {
            this.sellerlist = sellerlist;
        }

        public static class BussnesslistwBean {
            /**
             * sumafter : 20.4
             * days : 30
             */

            private double sumafter;
            private String days;

            public double getSumafter() {
                return sumafter;
            }

            public void setSumafter(double sumafter) {
                this.sumafter = sumafter;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }
        }

        public static class BussnesslistdBean {
            /**
             * sumafter : 23.9
             * days : 21
             */

            private double sumafter;
            private String days;

            public double getSumafter() {
                return sumafter;
            }

            public void setSumafter(double sumafter) {
                this.sumafter = sumafter;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }
        }

        public static class BussnesslistmBean {
            /**
             * sumafter : 22.9
             * days : 07
             */

            private double sumafter;
            private String days;

            public double getSumafter() {
                return sumafter;
            }

            public void setSumafter(double sumafter) {
                this.sumafter = sumafter;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }
        }

        public static class SellerlistBean {
            /**
             * sellerId : 1
             * name : 名称1
             */

            private int sellerId;
            private String name;

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
