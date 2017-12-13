package com.bjxiyangshar.myapplication.connectionsURL;

/**
 * Created by gll on 17-5-23.
 */

public class XY_Response {


    public static final String URL_WEIXIAPI = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    public static final String URL="http://192.168.1.229:8080/zsqAPI/api/";

    public static final String URL3="http://192.168.1.229:8080/zsq/";
//    public static final String URL = "http://47.92.106.249:8088/zsq/";
    public static final String URL2 = "http://47.92.106.249:8088/zsq/v2/";
    //检查版本信息
    public static final String URL_UPDATEVERSION=URL3+"usercenter/queryLastVersion?";
    //获取验证码
    public static final String URL_LOGIN = URL + "shareman/login?";
    //登陆
    public static final String URL_SED_MSM = URL + "shareman/getDynamic?";
    //首页初始化
    public static final String URL_INIT = URL + "shareman/init?";
    //总利润统计
    public static final String URL_QUREYPROFIT = URL + "shareman/qureyProfit?";
    //总销售额统计
    public static final String URL_QUERYTURNOVER = URL + "shareman/queryTurnover?";
    //查询商圈利润统计
    public static final String URL_QUERYBUSINESS = URL + "shareman/queryBusiness?";
    //添加商家
    public static final String URL_ADDBUSINESS = URL + "shareman/addBusiness?";
    //查询历史账单
    public static final String URL_QUERYSETTLEMENT = URL + "shareman/querySettleMent?";
    //查询历史账单详单
    public static final String URL_QUERYSETTLEMENT_DETAIL = URL + "shareman/querySettleMentDetail?";
    //查询小区
    public static final String URL_QUERY_COMMUNITY = URL + "shareman/queryCommunity?";


}
