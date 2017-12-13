package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.update.network.RequestCenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/26 0026.
 */

public class AddShangJiaXinXiNextActivity extends MySwipeBackActivity implements View.OnClickListener {
    /**
     * UI
     */
    @BindView(R.id.rl_shangjiazhanghuxinxi_fanhui)
    RelativeLayout rl_shangjiazhanghuxinxi_fanhui;
    @BindView(R.id.et_yinhangkahao)
    EditText et_yinhangkahao;
    @BindView(R.id.et_kaihuhang)
    EditText et_kaihuhang;
    @BindView(R.id.et_kaihuzhihang)
    EditText et_kaihuzhihang;
    @BindView(R.id.et_kaihuren)
    EditText et_kaihuren;
    @BindView(R.id.et_weixinzhanghao)
    EditText et_weixinzhanghao;
    @BindView(R.id.et_zhifubao)
    EditText et_zhifubao;
    @BindView(R.id.iv_tijiao)
    ImageView iv_tijiao;

    /**
     * Data
     */
    private String kahao;           //卡号
    private String kaihuhang;       //开户行
    private String zhihang;         //开户支行
    private String name;            //开户人
    private String weixin;          //微信
    private String zhifubao;        //支付宝
    private String mSJName;         //商家名字
    private String mName;           //联系人
    private String mPhone;          //手机号
    private String mAddress;        //具体地址
    private String mfenlei;         //分类
    private String mSelectAddress;  //选择的地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangjiazhanghuxinxi);
        ButterKnife.bind(this);
        initData();
        initUI();
    }

    private void initData() {
        Intent intent=getIntent();
        mSJName=intent.getStringExtra("mSJName");
        mName=intent.getStringExtra("mName");
        mPhone=intent.getStringExtra("mPhone");
        mAddress=intent.getStringExtra("mAddress");
        mfenlei=intent.getStringExtra("mfenlei");
        mSelectAddress=intent.getStringExtra("mSelectAddress");
    }

    private void initUI() {
        iv_tijiao.setOnClickListener(this);
        rl_shangjiazhanghuxinxi_fanhui.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_tijiao:
                tijiao();
                break;
            case R.id.rl_shangjiazhanghuxinxi_fanhui:
                finish();
                break;
        }
    }
    private void tijiao(){
        kahao = String.valueOf(et_yinhangkahao.getText());
        kaihuhang = String.valueOf(et_kaihuhang.getText());
        zhihang = String.valueOf(et_kaihuzhihang.getText());
        name = String.valueOf(et_kaihuren.getText());
        weixin = String.valueOf(et_weixinzhanghao.getText());
        zhifubao = String.valueOf(et_zhifubao.getText());
        String url= XY_Response.URL_ADDBUSINESS+
                "loginName="+""
                +"&password="+""
                +"&shopName="+mSJName
                +"&linkman="+mName
                +"&linkphone="+mPhone
                +"&communityId="+ SPManager.getInstance().getInt("communityId_one",0)

                +"&address="+mAddress
                +"&bankCard="+kahao
                +"&bankName="+kaihuhang
                +"&bankSubName="+zhihang
                +"&bankUser="+name
                +"&wxNo="+weixin
                +"&alipayNo="+zhifubao
                +"&sellerTypeId=1"
                +"&des=";
//        String url= XY_Response.URL_ADDBUSINESS+
//                "loginName="+"123"
//                +"&password="+"123"
//                +"&shopName="+"123"
//                +"&linkman="+"123"
//                +"&linkphone="+"123"
//                +"&communityId="+"123"
//                +"&sellerTypeId="+"123"
//                +"&address="+"123"
//                +"&bankCard="+"123"
//                +"&bankName="+"123"
//                +"&bankSubName="+"123"
//                +"&bankUser="+"123"
//                +"&wxNo="+"123"
//                +"&alipayNo="+"123"
//                +"&des="+"123";


        RequestCenter.addBusiness(url, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }















}
