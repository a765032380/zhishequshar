package com.bjxiyangshar.myapplication.bean;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class AddShangJiao {

    /**
     * code : 0
     * msg :
     * result : {"msg":"保存成功","status":true}
     * time : 1506502423060
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
         * msg : 保存成功
         * status : true
         */

        private String msg;
        private boolean status;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
}
