package com.bjxiyangshar.myapplication.update.network;

import com.baisi.myapplication.okhttp.CommonOkHttpClient;
import com.baisi.myapplication.okhttp.listener.DisposeDataHandle;
import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.baisi.myapplication.okhttp.listener.DisposeDownloadListener;
import com.baisi.myapplication.okhttp.request.CommonRequest;
import com.baisi.myapplication.okhttp.request.RequestParams;
import com.bjxiyangshar.myapplication.bean.FanHui;
import com.bjxiyangshar.myapplication.bean.UpdateVersion;
import com.bjxiyangshar.myapplication.bean.Users;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.manager.UserManager;
import com.bjxiyangshar.myapplication.update.util.GetHeaders;

import java.util.Map;

/**
 * Created by gll on 17-3-9.
 * 存放应用中所有的请求
 */
public class RequestCenter {
    public static void postRequest1(String url, RequestParams params,RequestParams headers,
                                    DisposeDataListener disposeDataListener, Class<?> clazz){
        CommonOkHttpClient.post(CommonRequest.createPostRequest1(url,params,headers)
                ,new DisposeDataHandle(disposeDataListener,clazz));
    }
    public static void postRequest(String url, RequestParams params,
                                    DisposeDataListener disposeDataListener, Class<?> clazz){
        CommonOkHttpClient.post(CommonRequest.createPostRequest1(url,params, GetHeaders.getHeaders())
                ,new DisposeDataHandle(disposeDataListener,clazz));
    }
    /**
     * 应用版本号请求
     *
     * @param listener
     */
    public static void checkVersion(DisposeDataListener listener) {
        RequestCenter.postRequest(XY_Response.URL_UPDATEVERSION +"mobilePhone="+
                       SPManager.getInstance().getString("mobilePhone","")+"&vertype="+5,
                null, listener, UpdateVersion.class);
    }

//    public static void uploadPictures(String url, Map<String, Object> map,DisposeDataListener listener){
//       CommonOkHttpClient.uploadImgAndParameter(map,null,url,new DisposeDataHandle(listener,ImageUrl.class));
//    }

//    public static void uploadPictures1(String url, Map<String, Object> map,DisposeDataListener listener){
//        CommonOkHttpClient.uploadImgAndParameter(map,GetHeaders.getHeaders(),url,new DisposeDataHandle(listener,ImageUrl.class));
//    }

//    public static void uploadPicturesList(String url, Map<String, Object> map,DisposeDataListener listener){
//        CommonOkHttpClient.uploadImgAndParameterList(map,url,new DisposeDataHandle(listener,ImageUrl.class));
//    }


    public static void cancel(){
        CommonOkHttpClient.breakLink();
    }
    /**
     * 应用版本号请求
     *
     * @param listener
     */
//    public static void checkVersion(DisposeDataListener listener) {
//        RequestCenter.postRequest(XY_Response.URL_UPDATEVERSION +"cmemberId="+
//                        SPManager.getInstance().getString("c_memberId",null),
//                null, listener, UpdateVersion.class);
//    }
    public static void downloadFile(String url, String path, DisposeDownloadListener listener) {
        CommonOkHttpClient.downloadFile(CommonRequest.createGetRequest(url, null),
                new DisposeDataHandle(listener, path));
    }
    //获取JSON并转化为实体类的请求。
    public static void requestRecommandData(DisposeDataListener listener){
        //第一个参数为请求的地址
        //第二个参数为上传的参数。请求的时候为null
        //第三个参数为监听事件
        //第四个参数为JSON的实体类
        RequestParams params=new RequestParams("TEXT","我是测试数据");
        RequestCenter.postRequest(HttpConstants.TEXT,
                params,listener, null);
    }
    public static void login(String url,RequestParams headers,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,headers,listener,Users.class);
    }
    public static void register(String url,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, FanHui.class);
    }
    public static void init(String url,Class mClass,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,GetHeaders.getHeaders(),listener, mClass);
    }
    public static void qureyProfit(String url,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, FanHui.class);
    }
    public static void queryTurnover(String url,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, FanHui.class);
    }
    public static void all(String url,Class mClass,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, mClass);
    }
    public static void addBusiness(String url,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, FanHui.class);
    }
    public static void querySettleMent(String url,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, FanHui.class);
    }
    public static void querySettleMentDetail(String url,DisposeDataListener listener){
        RequestCenter.postRequest1(url,null,null,listener, FanHui.class);
    }







}
