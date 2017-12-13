package com.bjxiyangshar.myapplication.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;


/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class GuanYuWoMenActivity extends MySwipeBackActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanyuwomen);
        RelativeLayout rl_guanyuwomen_fanghui= (RelativeLayout) findViewById(R.id.rl_guanyuwomen_fanghui);
        rl_guanyuwomen_fanghui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
