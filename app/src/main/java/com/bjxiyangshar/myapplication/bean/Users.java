package com.bjxiyangshar.myapplication.bean;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class Users {


    /**
     * code : 0
     * time : 1506497020618
     * msg :
     * result : {"linkPhone":"","salesmanId":0,"address":"","bankCard":"","sharerId":1,"loginKey":"a247bc16fad8544e92f6a2bd90c274b3","accountTotal":0,"creatorId":0,"bankName":"","serviceTime":0,"alipayNo":"","bankSubName":"","wxNo":"","createTime":"","loginName":"18813045215","bankUser":"","shareName":"","communityId":0,"status":0}
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
         * linkPhone :
         * salesmanId : 0
         * address :
         * bankCard :
         * sharerId : 1
         * loginKey : a247bc16fad8544e92f6a2bd90c274b3
         * accountTotal : 0
         * creatorId : 0
         * bankName :
         * serviceTime : 0
         * alipayNo :
         * bankSubName :
         * wxNo :
         * createTime :
         * loginName : 18813045215
         * bankUser :
         * shareName :
         * communityId : 0
         * status : 0
         */

        private String linkPhone;
        private int salesmanId;
        private String address;
        private String bankCard;
        private int sharerId;
        private String loginKey;
        private int accountTotal;
        private int creatorId;
        private String bankName;
        private int serviceTime;
        private String alipayNo;
        private String bankSubName;
        private String wxNo;
        private String createTime;
        private String loginName;
        private String bankUser;
        private String shareName;
        private int communityId;
        private int status;

        public String getLinkPhone() {
            return linkPhone;
        }

        public void setLinkPhone(String linkPhone) {
            this.linkPhone = linkPhone;
        }

        public int getSalesmanId() {
            return salesmanId;
        }

        public void setSalesmanId(int salesmanId) {
            this.salesmanId = salesmanId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBankCard() {
            return bankCard;
        }

        public void setBankCard(String bankCard) {
            this.bankCard = bankCard;
        }

        public int getSharerId() {
            return sharerId;
        }

        public void setSharerId(int sharerId) {
            this.sharerId = sharerId;
        }

        public String getLoginKey() {
            return loginKey;
        }

        public void setLoginKey(String loginKey) {
            this.loginKey = loginKey;
        }

        public int getAccountTotal() {
            return accountTotal;
        }

        public void setAccountTotal(int accountTotal) {
            this.accountTotal = accountTotal;
        }

        public int getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public int getServiceTime() {
            return serviceTime;
        }

        public void setServiceTime(int serviceTime) {
            this.serviceTime = serviceTime;
        }

        public String getAlipayNo() {
            return alipayNo;
        }

        public void setAlipayNo(String alipayNo) {
            this.alipayNo = alipayNo;
        }

        public String getBankSubName() {
            return bankSubName;
        }

        public void setBankSubName(String bankSubName) {
            this.bankSubName = bankSubName;
        }

        public String getWxNo() {
            return wxNo;
        }

        public void setWxNo(String wxNo) {
            this.wxNo = wxNo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getBankUser() {
            return bankUser;
        }

        public void setBankUser(String bankUser) {
            this.bankUser = bankUser;
        }

        public String getShareName() {
            return shareName;
        }

        public void setShareName(String shareName) {
            this.shareName = shareName;
        }

        public int getCommunityId() {
            return communityId;
        }

        public void setCommunityId(int communityId) {
            this.communityId = communityId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
