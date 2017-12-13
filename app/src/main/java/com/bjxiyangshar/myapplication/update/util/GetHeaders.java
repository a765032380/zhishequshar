package com.bjxiyangshar.myapplication.update.util;


import com.baisi.myapplication.okhttp.request.RequestParams;
import com.bjxiyangshar.myapplication.manager.SPManager;

/**
 * Created by Administrator on 2017/7/3 0003.
 *
 */

public class GetHeaders {
    public static RequestParams getHeaders(){
        RequestParams headers=new RequestParams();
        headers.put("private-token","2950B701-A720-4D4D-8CE4-C333ABF00E0F");
//        headers.put("private-token", SPManager.getInstance().getString("mobilePhone",null)
//                +"_"+SPManager.getInstance().getString("loginKey",""));

//        UserManager.getInstance().getUser().getObj().getMobilePhone()+
//                "_"+

//        headers.put("private-token", "a600dd01ffefbaf03d670bf5e20743e1");
//                UserManager.getInstance().getUser().getResult().getLoginKey());
        return headers;
    }

}
