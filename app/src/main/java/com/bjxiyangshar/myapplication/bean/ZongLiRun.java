package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class ZongLiRun {

    /**
     * code : 0
     * msg :
     * result : {"resultDay":[{"days":"22","sumafter":196},{"days":"23","sumafter":157},{"days":"24","sumafter":215},{"days":"25","sumafter":291},{"days":"26","sumafter":255},{"days":"27","sumafter":7610},{"days":"28","sumafter":252},{"days":"29","sumafter":533},{"days":"30","sumafter":232},{"days":"31","sumafter":204}],"resultMonth":[{"days":"06","sumafter":251},{"days":"07","sumafter":3462},{"days":"08","sumafter":2993},{"days":"09","sumafter":13240}],"resultWeek":[{"days":"30","sumafter":1462},{"days":"31","sumafter":534},{"days":"32","sumafter":1029},{"days":"33","sumafter":822},{"days":"34","sumafter":482},{"days":"35","sumafter":1196},{"days":"36","sumafter":1719},{"days":"37","sumafter":2384},{"days":"38","sumafter":1043},{"days":"39","sumafter":7126}]}
     * time : 1506577946386
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
        private List<ResultDayBean> resultDay;
        private List<ResultMonthBean> resultMonth;
        private List<ResultWeekBean> resultWeek;

        public List<ResultDayBean> getResultDay() {
            return resultDay;
        }

        public void setResultDay(List<ResultDayBean> resultDay) {
            this.resultDay = resultDay;
        }

        public List<ResultMonthBean> getResultMonth() {
            return resultMonth;
        }

        public void setResultMonth(List<ResultMonthBean> resultMonth) {
            this.resultMonth = resultMonth;
        }

        public List<ResultWeekBean> getResultWeek() {
            return resultWeek;
        }

        public void setResultWeek(List<ResultWeekBean> resultWeek) {
            this.resultWeek = resultWeek;
        }

        public static class ResultDayBean {
            /**
             * days : 22
             * sumafter : 196
             */

            private String days;
            private int sumafter;

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public int getSumafter() {
                return sumafter;
            }

            public void setSumafter(int sumafter) {
                this.sumafter = sumafter;
            }
        }

        public static class ResultMonthBean {
            /**
             * days : 06
             * sumafter : 251
             */

            private String days;
            private int sumafter;

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public int getSumafter() {
                return sumafter;
            }

            public void setSumafter(int sumafter) {
                this.sumafter = sumafter;
            }
        }

        public static class ResultWeekBean {
            /**
             * days : 30
             * sumafter : 1462
             */

            private String days;
            private int sumafter;

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public int getSumafter() {
                return sumafter;
            }

            public void setSumafter(int sumafter) {
                this.sumafter = sumafter;
            }
        }
    }
}
