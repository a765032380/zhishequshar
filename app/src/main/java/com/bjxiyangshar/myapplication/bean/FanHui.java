package com.bjxiyangshar.myapplication.bean;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class FanHui {

    /**
     * code : 0
     * time : 1506496984613
     * msg :
     * result : {"mobilePhone":"18813045215"}
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
         * mobilePhone : 18813045215
         */

        private String mobilePhone;

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }
    }
}
