package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.adapter.LiShiZhangDanAdapter;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.bean.LiShiZhangDan;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.until.MyUntil;
import com.bjxiyangshar.myapplication.update.network.RequestCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/26 0026.
 */

public class LiShiZhangDanActivity extends MySwipeBackActivity implements AdapterView.OnItemClickListener {
    /***
     * UI
     */
    @BindView(R.id.rl_lishizhangdan_fanhui)
    RelativeLayout rl_lishizhangdan_fanhui;
    @BindView(R.id.lv_xuanzeshangquan)
    ListView lv_xuanzeshangquan;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    /**
     * Data
     */
    LiShiZhangDanAdapter adapter;
    List<LiShiZhangDan.ResultBean.SettlelistBean> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lishizhnagdan);
        ButterKnife.bind(this);
        initUI();
        getData();
    }

    private void initUI() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        rl_lishizhangdan_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        lv_xuanzeshangquan.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this,LiShiZhangDanXiangQingActivity.class);
        intent.putExtra("begin",mList.get(i).getCycle_begin());
        intent.putExtra("end",mList.get(i).getCycle_end());
        intent.putExtra("money",mList.get(i).getSettlement_total());
        startActivity(intent);

    }
    private void getData(){
//        String url= XY_Response.URL_QUERYSETTLEMENT
//                +"sharerId="+ SPManager.getInstance().getString("sharerId","");

        String url= XY_Response.URL_QUERYSETTLEMENT
                +"sharerId="+SPManager.getInstance().getString("sharerId","");

        RequestCenter.all(url, LiShiZhangDan.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                swipeRefreshLayoutHide();
                LiShiZhangDan liShiZhangDan= (LiShiZhangDan) responseObj;
                if (liShiZhangDan.getCode()==0){
                    setData(liShiZhangDan.getResult());
                }

            }

            @Override
            public void onFailure(Object reasonObj) {
                swipeRefreshLayoutHide();
            }
        });



    }
    private void setData(LiShiZhangDan.ResultBean resultBean){
        mList=resultBean.getSettlelist();
        adapter=new LiShiZhangDanAdapter(this,mList);
        lv_xuanzeshangquan.setAdapter(adapter);

    }
    private void swipeRefreshLayoutHide(){
        if (swipeRefreshLayout.isRefreshing()){
            swipeRefreshLayout.setRefreshing(false);
        }

    }


}
