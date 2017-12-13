package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.adapter.HomeAdapter;
import com.bjxiyangshar.myapplication.adutil.APP_ID;
import com.bjxiyangshar.myapplication.base.BaseActivity;
import com.bjxiyangshar.myapplication.bean.FanHui;
import com.bjxiyangshar.myapplication.bean.Init;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.until.MyUntil;
import com.bjxiyangshar.myapplication.update.network.RequestCenter;
import com.bjxiyangshar.myapplication.view.MyListView;
import com.bjxiyangshar.myapplication.view.PullListView;
import com.bjxiyangshar.myapplication.view.RefreshLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class HomeActivty extends BaseActivity implements View.OnClickListener
        ,AdapterView.OnItemClickListener,SwipeRefreshLayout.OnRefreshListener {
    /**
     * UI
     */
    @BindView(R.id.iv_menu)
    ImageView iv_menu;
    @BindView(R.id.tv_jiesuanshenyushijian)
    TextView tv_jiesuanshenyushijian;
    @BindView(R.id.tv_zongshouru)
    TextView tv_zongshouru;
    @BindView(R.id.iv_shenhepaicuo)
    ImageView iv_shenhepaicuo;
    @BindView(R.id.iv_tijiaocaiwu)
    ImageView iv_tijiaocaiwu;
    @BindView(R.id.iv_caiwushenhe)
    ImageView iv_caiwushenhe;
    @BindView(R.id.iv_jiesuanzhifu)
    ImageView iv_jiesuanzhifu;
    @BindView(R.id.tv_shenhepaicuo)
    TextView tv_shenhepaicuo;
    @BindView(R.id.tv_tijiaocaiwu)
    TextView tv_tijiaocaiwu;
    @BindView(R.id.tv_caiwushenhe)
    TextView tv_caiwushenhe;
    @BindView(R.id.tv_jiesuanzhifu)
    TextView tv_jiesuanzhifu;
    @BindView(R.id.lv_home_listview)
    MyListView lv_home_listview;
    @BindView(R.id.ll_gone_jincheng)
    LinearLayout ll_gone_jincheng;
    @BindView(R.id.ll_jiesuanshijian)
    LinearLayout ll_jiesuanshijian;
    @BindView(R.id.ll_zongshouru)
    LinearLayout ll_zongshouru;
    @BindView(R.id.tv_yanzhengxinxi)
    TextView tv_yanzhengxinxi;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.scrollview)
    NestedScrollView scrollview;
    @BindView(R.id.tv_count)
    TextView tv_count;
    @BindView(R.id.tv_spcount_num)
    TextView tv_spcount_num;
    @BindView(R.id.ll_jinrizonglirun)
    LinearLayout ll_jinrizonglirun;
    @BindView(R.id.ll_jinrishangpincount)
    LinearLayout ll_jinrishangpincount;

    /**
     * DATA
     */
    List<Init.ResultBean.TradingListBean> mList;
    private boolean isShuaXin=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
//        SPManager.getInstance().putString("sharerId","2");
        initUI();
//        scrollview.smoothScrollTo(0, 0);
        getData();
        showYouShangQuan();
    }


    private void initUI() {
        ll_jinrizonglirun.setOnClickListener(this);
        ll_jinrishangpincount.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        iv_menu.setOnClickListener(this);
        lv_home_listview.setOnItemClickListener(this);
        tv_yanzhengxinxi.setOnClickListener(this);
    }

    private void showkongxin(ImageView miv,TextView mtv){
        miv.setImageResource(R.drawable.a_bg_notshow);
        mtv.setTextColor(0x8cb0ff);
    }
    private void showshixin(ImageView miv,TextView mtv){
        miv.setImageResource(R.drawable.a_bg_display);
        mtv.setTextColor(0x216cff);
    }
    private void showJinCheng(){
        ll_gone_jincheng.setVisibility(View.VISIBLE);
    }
    private void hideJinCheng(){
        ll_gone_jincheng.setVisibility(View.GONE);
    }
    private void showYouShangQuan(){
        ll_jiesuanshijian.setVisibility(View.VISIBLE);
        ll_zongshouru.setVisibility(View.VISIBLE);
        tv_zongshouru.setVisibility(View.VISIBLE);
        tv_yanzhengxinxi.setVisibility(View.GONE);
    }
    private void showWuShangQuan(){
        ll_jiesuanshijian.setVisibility(View.GONE);
        ll_zongshouru.setVisibility(View.GONE);
        tv_zongshouru.setVisibility(View.GONE);
        tv_yanzhengxinxi.setVisibility(View.VISIBLE);
        hideJinCheng();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_menu:
                MyUntil.StartActivity(this,GeRenZhongXinActivity.class);

                break;
            case R.id.tv_yanzhengxinxi:
                MyUntil.StartActivity(this,SelectShangQuanActivity.class);
                break;
            case R.id.ll_jinrizonglirun:
                Intent intent=new Intent(this,XinZengTongJiActivity.class);
                intent.putExtra("type", APP_ID.TODAY_ALL_LIRUN);
                startActivity(intent);
                break;
            case R.id.ll_jinrishangpincount:
                Intent intent1=new Intent(this,XinZengTongJiActivity.class);
                intent1.putExtra("type", APP_ID.TODAY_ALL_SP_COUNT);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this,XinZengTongJiActivity.class);
        intent.putExtra("type",APP_ID.SHANGQUAN);
        intent.putExtra("communityId",mList.get(i).getCommunityId());
        startActivity(intent);
//        MyUntil.StartActivity(this,XinZengTongJiActivity.class);
    }

    @Override
    public void onRefresh() {
        getData();
        swipeRefreshLayout.setRefreshing(false);
    }
    private void showJinCheng0(){
        iv_shenhepaicuo.setImageResource(R.drawable.a_bg_notshow);
        tv_shenhepaicuo.setTextColor(0xff8cb0ff);
    }
    private void showShenHePaiCuo(){
        iv_shenhepaicuo.setImageResource(R.drawable.a_bg_display);
        tv_shenhepaicuo.setTextColor(0xff216cff);

    }
    private void showTiJiaoCaiWu(){
        iv_shenhepaicuo.setImageResource(R.drawable.a_bg_display);
        iv_tijiaocaiwu.setImageResource(R.drawable.a_bg_display);
        tv_shenhepaicuo.setTextColor(0xff216cff);
        tv_tijiaocaiwu.setTextColor(0xff216cff);
    }
    private void showCaiWuShenHe(){
        iv_shenhepaicuo.setImageResource(R.drawable.a_bg_display);
        iv_tijiaocaiwu.setImageResource(R.drawable.a_bg_display);
        iv_caiwushenhe.setImageResource(R.drawable.a_bg_display);
        tv_shenhepaicuo.setTextColor(0xff216cff);
        tv_tijiaocaiwu.setTextColor(0xff216cff);
        tv_caiwushenhe.setTextColor(0xff216cff);
    }
    private void showJieSuanZhiFu(){
        iv_shenhepaicuo.setImageResource(R.drawable.a_bg_display);
        iv_tijiaocaiwu.setImageResource(R.drawable.a_bg_display);
        iv_caiwushenhe.setImageResource(R.drawable.a_bg_display);
        iv_jiesuanzhifu.setImageResource(R.drawable.a_bg_display);
        tv_shenhepaicuo.setTextColor(0xff216cff);
        tv_tijiaocaiwu.setTextColor(0xff216cff);
        tv_caiwushenhe.setTextColor(0xff216cff);
        tv_jiesuanzhifu.setTextColor(0xff216cff);
    }
    private void getData(){
        scrollview.smoothScrollTo(0, 0);
//        String url= XY_Response.URL_INIT
//                +"sharerId="+ SPManager.getInstance().getString("sharerId","");
        String url= XY_Response.URL_INIT
                +"sharerId="+SPManager.getInstance().getString("sharerId","");
        RequestCenter.init(url, Init.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                Init init= (Init) responseObj;
                if (init.getCode()==0){
                    setData(init.getResult());
                }else {
                    MyUntil.show(HomeActivty.this,init.getMsg());
                }

            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }
    private void setData(Init.ResultBean resultBean){
        mList=resultBean.getTradingList();
        tv_zongshouru.setText(String.valueOf(resultBean.getTotalmoney()));
        tv_count.setText(String.valueOf(resultBean.getTodaymoney()));
        tv_jiesuanshenyushijian.setText(String.valueOf(resultBean.getRemaining()));
        tv_spcount_num.setText(String.valueOf(resultBean.getTodaycommodity()));


        HomeAdapter adapter=new HomeAdapter(this,mList);
        lv_home_listview.setAdapter(adapter);
        switch (resultBean.getSettlement()){
            case -1:
                hideJinCheng();
                break;
            case 0:
                showJinCheng0();
                break;
            case 1:
                showShenHePaiCuo();
                break;
            case 2:
                showTiJiaoCaiWu();
                break;
            case 3:
                showCaiWuShenHe();
                break;
            case 4:
                showJieSuanZhiFu();
                break;
        }
    }



}
