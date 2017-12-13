package com.bjxiyangshar.myapplication.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class SelectShangQuanActivity extends MySwipeBackActivity implements SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.rl_zhekouquan_fanhui)
    RelativeLayout rl_zhekouquan_fanhui;
    @BindView(R.id.lv_xuanzeshangquan)
    ListView lv_xuanzeshangquan;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;





//    private IDataSource mDataSource = new SucRateDataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuanzeshangquan);
        ButterKnife.bind(this);
        initUI();
//        initData();

    }



    private void initUI() {
        rl_zhekouquan_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);

    }

//    private onDataChangedListener listener = new onDataChangedListener() {
//        @Override
//        public void onChanged(String[] xx, String[] yy) {
//            notifyDataChanged(xx, yy);
//        }
//    };


}
