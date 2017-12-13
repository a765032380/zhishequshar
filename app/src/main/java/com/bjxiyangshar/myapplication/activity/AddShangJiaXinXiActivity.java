package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.until.MyUntil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/26 0026.
 */

public class AddShangJiaXinXiActivity extends MySwipeBackActivity implements View.OnClickListener {
    /***
     * UI
     */
    @BindView(R.id.rl_tianjiashangjiaxinxi_fanhui)
    RelativeLayout rl_tianjiashangjiaxinxi_fanhui;
    @BindView(R.id.et_shangjianame)
    EditText et_shangjianame;
    @BindView(R.id.et_lianxiren)
    EditText et_lianxiren;
    @BindView(R.id.et_lianxidianhua)
    EditText et_lianxidianhua;
    @BindView(R.id.et_address)
    EditText et_address;
    @BindView(R.id.ll_address)
    LinearLayout ll_address;
    @BindView(R.id.ll_shangjiafenlei)
    LinearLayout ll_shangjiafenlei;
    @BindView(R.id.iv_next)
    ImageView iv_next;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_shangjiafenlei)
    TextView tv_shangjiafenlei;

    /**
     * Data
     */
    private String mSJName;
    private String mName;
    private String mPhone;
    private String mAddress;
    private String mfenlei;
    private String mSelectAddress;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianjiashangjiaxinxi);
        ButterKnife.bind(this);
        initUI();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SPManager.getInstance().getString("xiaoqu",null)!=null){
            tv_address.setText(SPManager.getInstance().getString("xiaoqu",""));
        }
    }

    private void initUI() {
        iv_next.setOnClickListener(this);
        rl_tianjiashangjiaxinxi_fanhui.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        ll_shangjiafenlei.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_tianjiashangjiaxinxi_fanhui:
                finish();
                break;
            case R.id.ll_address:
                MyUntil.StartActivity(this,XuanZeXiaoQuActivity.class);
                break;
            case R.id.ll_shangjiafenlei:
                break;
            case R.id.iv_next:
                mSJName = String.valueOf(et_shangjianame.getText());
                mName= String.valueOf(et_shangjianame.getText());
                mPhone= String.valueOf(et_shangjianame.getText());
                mAddress= String.valueOf(tv_address.getText());
                mfenlei= String.valueOf(tv_shangjiafenlei.getText());
                mSelectAddress= String.valueOf(et_shangjianame.getText());
//                if (isNull(mSJName))break;
//                if (isNull(mName))break;
//                if (isNull(mPhone))break;
//                if (isNull(mAddress))break;
//                if (isNull(mfenlei))break;
//                if (isNull(mSelectAddress))break;
                Intent intent=new Intent(this,AddShangJiaXinXiNextActivity.class);
                intent.putExtra("mSJName",mSJName);
                intent.putExtra("mName",mName);
                intent.putExtra("mPhone",mPhone);
                intent.putExtra("mAddress",mAddress);
                intent.putExtra("mfenlei",mfenlei);
                intent.putExtra("mSelectAddress",mSelectAddress);
                startActivity(intent);
                break;
        }
    }
    private boolean isNull(String str){
        if (str.equals("")||str==null){
            Toast.makeText(this,"请补全信息",Toast.LENGTH_LONG).show();
            return true;
        }else {
            return false;
        }
    }



}
