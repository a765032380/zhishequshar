package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baisi.imoocsdk.imageloader.ImageLoaderManager;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.adapter.LiShiZhangDanAdapter;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.until.MyUntil;
import com.bjxiyangshar.myapplication.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/5 0005.
 *
 */

public class GeRenZhongXinActivity extends MySwipeBackActivity implements View.OnClickListener{


    protected static final String TRANSITION_DATA = "data";

    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.viv_touxiang)
    CircleImageView viv_touxiang;
    @BindView(R.id.tv_phone)
    TextView tv_phone;
    @BindView(R.id.ll_gerenxinxi)
    LinearLayout ll_gerenxinxi;
    @BindView(R.id.tv_menjinjilu)
    TextView tv_menjinjilu;
    @BindView(R.id.tv_yaoshishouquan)
    TextView tv_yaoshishouquan;
    @BindView(R.id.tv_kefurexian)
    TextView tv_kefurexian;
    @BindView(R.id.ll_setting)
    LinearLayout ll_setting;
    @BindView(R.id.iv_xitongxiaoxi)
    ImageView iv_xitongxiaoxi;

    public static GeRenZhongXinActivity geRenZhongXinActivity;
//    BaseViewHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenzhongxin);
        ButterKnife.bind(this);
        geRenZhongXinActivity=this;
        switch (getIntent().getIntExtra("id",-1)){
            case R.id.ll_setting:
//                startTranslation1();
                break;
        }



        initUI();
        setHongDian();//设置红点
//        TransitionsHeleper.getInstance()
//                .setShowMethod(new ColorShowMethod(R.color.white,R.color.white) {
//                    @Override
//                    public void loadCopyView(InfoBean bean, ImageView copyView) {
//                        AnimatorSet set = new AnimatorSet();
//                        set.playTogether(
//                                ObjectAnimator.ofFloat(copyView,"rotation",0,180),
//                                ObjectAnimator.ofFloat(copyView, "scaleX", 1, 0),
//                                ObjectAnimator.ofFloat(copyView, "scaleY", 1, 0)
//                        );
//                        set.setInterpolator(new AccelerateInterpolator());
//                        set.setDuration(duration / 4 * 5).start();
//                    }
//
//                    @Override
//                    public void loadTargetView(InfoBean bean, ImageView targetView) {
//
//                    }
//
//                })
//                .show(this,null);
//


//        Intent intent = getIntent();
//        if (intent != null) {
////            tv.setText(intent.getStringExtra(TRANSITION_DATA));
//        }
//        TransitionsHeleper.getInstance()
//                .show(this, null);
    }
    //设置红点
    private void setHongDian(){
//        if (SPManager.getInstance().getInt("xiaoxi",0)!=0){
//            iv_xitongxiaoxi.setImageResource(R.drawable.b_btn_notice_pre);
//        }else {
//            iv_xitongxiaoxi.setImageResource(R.drawable.b_btn_notice);
//        }
    }

    //初始化设置各种监听事件
    private void initUI() {
        iv_xitongxiaoxi.setOnClickListener(this);
        tv_phone.setText(SPManager.getInstance().getString("mobilePhone",""));
        tv_yaoshishouquan.setOnClickListener(this);
        iv_close.setOnClickListener(this);
        viv_touxiang.setOnClickListener(this);
        tv_phone.setOnClickListener(this);
        ll_gerenxinxi.setOnClickListener(this);
        tv_menjinjilu.setOnClickListener(this);
        tv_kefurexian.setOnClickListener(this);
        ll_setting.setOnClickListener(this);

//        if (!SPManager.getInstance().getString("headPhotoUrl","").equals("")) {
//            ImageLoaderManager.getInstance(this)
//                    .displayImage(viv_touxiang, SPManager.getInstance().getString("headPhotoUrl", ""));
//        }

    }

    //点击事件的监听回掉
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //关闭
            case R.id.iv_close:
//                startTranslation1();
//                if (helper!=null && helper.isShowing()){
//                    helper.backActivity(this);
//                }
                finish();
                break;
            //头像
            case R.id.viv_touxiang:
                startIntent(MyXinXiActivity.class);
                break;
            //手机号
            case R.id.tv_phone:
                break;
            //个人信息
            case R.id.ll_gerenxinxi:
                startIntent(MyXinXiActivity.class);
                break;
            //客服热线
            case R.id.tv_kefurexian:

//                startIntent(MyKeFuActivity.class);
                Intent j = new Intent();
                j.setAction(Intent.ACTION_DIAL);
                j.setData(Uri.parse("tel:4000080828"));
                startActivity(j);
                break;
            //设置
            case R.id.ll_setting:
                startIntent(SheZhiActivity.class);
                break;
            case R.id.tv_yaoshishouquan:
                startIntent(LiShiZhangDanActivity.class);
                break;
            case R.id.iv_xitongxiaoxi:
//                startIntent(HuiFuActivity.class);
                break;
            case R.id.tv_menjinjilu:
                MyUntil.StartActivity(this,AddShangJiaXinXiActivity.class);
                break;
        }
    }
    //跳转
    private void startIntent(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
//    public void startTranslation1(){
//        helper = new BaseViewHelper
//                .Builder(GeRenZhongXinActivity.this)
//                //.setEndView()//如果是两个切换的视图  这里设定最终显示的视图
//                //.setTranslationView(viewById)//设置过渡视图
//                .isFullWindow(true)//是否全屏显示
//                .isShowTransition(false)//是否显示过渡动画
//                .setDimColor(Color.WHITE)//遮罩颜色
//                .setDimAlpha(205)//遮罩透明度
//                .setTranslationX(0)//x轴平移
//                .setRotation(360)//旋转
//                .setScaleX(0)//x轴缩放
//                .setScaleY(0)//y轴缩放
//                .setTranslationY(0)//y轴平移
//                .setDuration(500)//过渡时长
//                .setInterpolator(new AccelerateDecelerateInterpolator())//设置插值器
//                //设置监听
//                .setOnAnimationListener(new BaseViewHelper.OnAnimationListener() {
//                    @Override
//                    public void onAnimationStartIn() {
//                        Log.e("TAG","onAnimationStartIn");
//                    }
//
//                    @Override
//                    public void onAnimationEndIn() {
//                        Log.e("TAG","onAnimationEndIn");
//                    }
//
//                    @Override
//                    public void onAnimationStartOut() {
//                        Log.e("TAG","onAnimationStartOut");
//                    }
//
//                    @Override
//                    public void onAnimationEndOut() {
//                        Log.e("TAG","onAnimationEndOut");
//                    }
//                })
//                .create();//开始动画
//    }

//    @Override
//    public void onBackPressed() {
//
//        if (helper!=null && helper.isShowing()){
//            helper.backActivity(this);
//        }else {
//            super.onBackPressed();
//        }
//    }

}
