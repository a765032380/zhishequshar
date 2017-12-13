package com.bjxiyangshar.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28 0028.
 */

public class SelectXiaoQu {

    /**
     * code : 0
     * time : 1506585120673
     * msg :
     * result : [{"communityId":1,"communityName":"华彩国际","city":"","foundTime":"2017-07-26 13:55:01","creater":"admin"},{"communityId":2,"communityName":"国风美唐","city":"","foundTime":"2017-07-26 13:55:01","creater":"admin"},{"communityId":4,"communityName":"鹏景阁大厦","city":"","foundTime":"2017-07-27 09:06:14","creater":"admin"},{"communityId":6,"communityName":"宏源公寓","city":"北京市","foundTime":"2017-08-17 16:41:08","creater":"lishangsheng"},{"communityId":7,"communityName":"测试小区","city":"","foundTime":"2017-09-13 09:26:18","creater":"admin"},{"communityId":8,"communityName":"精英家园","city":"","foundTime":"2017-09-13 09:52:44","creater":"litao"}]
     */

    private int code;
    private long time;
    private String msg;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * communityId : 1
         * communityName : 华彩国际
         * city :
         * foundTime : 2017-07-26 13:55:01
         * creater : admin
         */

        private int communityId;
        private String communityName;
        private String city;
        private String foundTime;
        private String creater;

        public int getCommunityId() {
            return communityId;
        }

        public void setCommunityId(int communityId) {
            this.communityId = communityId;
        }

        public String getCommunityName() {
            return communityName;
        }

        public void setCommunityName(String communityName) {
            this.communityName = communityName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getFoundTime() {
            return foundTime;
        }

        public void setFoundTime(String foundTime) {
            this.foundTime = foundTime;
        }

        public String getCreater() {
            return creater;
        }

        public void setCreater(String creater) {
            this.creater = creater;
        }
    }
}
