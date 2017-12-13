package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class XiaoShouE {

    /**
     * code : 0
     * time : 1506570992821
     * msg :
     * result : {"resultDay":[{"sumafter":1.2,"days":"20"},{"sumafter":21.2,"days":"21"},{"sumafter":20.4,"days":"22"},{"sumafter":22.8,"days":"23"},{"sumafter":22.6,"days":"24"},{"sumafter":23.8,"days":"25"},{"sumafter":32.8,"days":"26"},{"sumafter":228,"days":"27"},{"sumafter":1.2,"days":"29"},{"sumafter":1.2,"days":"30"}],"resultWeek":[{"sumafter":1.2,"days":"21"},{"sumafter":1.2,"days":"26"},{"sumafter":2.4,"days":"30"},{"sumafter":32,"days":"34"},{"sumafter":6,"days":"35"},{"sumafter":17.2,"days":"36"},{"sumafter":18.6,"days":"37"},{"sumafter":86,"days":"38"},{"sumafter":251.2,"days":"39"}],"resultMonth":[{"sumafter":1.2,"days":"05"},{"sumafter":1.2,"days":"06"},{"sumafter":2.4,"days":"07"},{"sumafter":34.4,"days":"08"},{"sumafter":376.6,"days":"09"}]}
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
        private List<ResultDayBean> resultDay;
        private List<ResultWeekBean> resultWeek;
        private List<ResultMonthBean> resultMonth;

        public List<ResultDayBean> getResultDay() {
            return resultDay;
        }

        public void setResultDay(List<ResultDayBean> resultDay) {
            this.resultDay = resultDay;
        }

        public List<ResultWeekBean> getResultWeek() {
            return resultWeek;
        }

        public void setResultWeek(List<ResultWeekBean> resultWeek) {
            this.resultWeek = resultWeek;
        }

        public List<ResultMonthBean> getResultMonth() {
            return resultMonth;
        }

        public void setResultMonth(List<ResultMonthBean> resultMonth) {
            this.resultMonth = resultMonth;
        }

        public static class ResultDayBean {
            /**
             * sumafter : 1.2
             * days : 20
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

        public static class ResultWeekBean {
            /**
             * sumafter : 1.2
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

        public static class ResultMonthBean {
            /**
             * sumafter : 1.2
             * days : 05
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
    }
}
