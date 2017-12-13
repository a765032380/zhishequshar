package com.bjxiyangshar.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.adapter.XYXuanZeXiaoQuAdapter;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.bean.SelectXiaoQu;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.update.network.RequestCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/26 0026.
 */

public class XuanZeXiaoQuActivity extends MySwipeBackActivity {
    /**
     * UI
     */
    @BindView(R.id.ib_menjinjilu_fanghui)
    RelativeLayout ib_menjinjilu_fanghui;
    @BindView(R.id.lv_xuanzexiaoqu)
    ListView lv_xuanzexiaoqu;

    /***
     * Data
     */
    private XYXuanZeXiaoQuAdapter adapter;
    private List<SelectXiaoQu.ResultBean> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuanzexiaoqu);
        ButterKnife.bind(this);
        initUI();
        initData();
    }

    private void initData() {
        String url= XY_Response.URL_QUERY_COMMUNITY;
        RequestCenter.all(url, SelectXiaoQu.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                SelectXiaoQu selectXiaoQu= (SelectXiaoQu) responseObj;
                if (selectXiaoQu.getCode()==0){
                    mList = selectXiaoQu.getResult();
                    adapter=new XYXuanZeXiaoQuAdapter(XuanZeXiaoQuActivity.this,mList);
                    lv_xuanzexiaoqu.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }

    private void initUI() {
        ib_menjinjilu_fanghui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lv_xuanzexiaoqu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SPManager.getInstance().putString("xiaoqu",mList.get(i).getCommunityName());
                SPManager.getInstance().putInt("communityId_one",mList.get(i).getCommunityId());
                finish();
            }
        });
    }
}
