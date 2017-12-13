package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.adutil.APP_ID;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.bean.ShangQuanLiRun;
import com.bjxiyangshar.myapplication.bean.XiaoShouE;
import com.bjxiyangshar.myapplication.bean.ZongLiRun;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
import com.bjxiyangshar.myapplication.until.MyUntil;
import com.bjxiyangshar.myapplication.update.network.RequestCenter;
import com.bjxiyangshar.myapplication.view.MyMarkerView;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class XinZengTongJiActivity extends MySwipeBackActivity implements View.OnClickListener{
    @BindView(R.id.linechart)
    LineChart mChart;
    @BindView(R.id.rl_yanzhengxinxi_fanhui)
    RelativeLayout rl_yanzhengxinxi_fanhui;
    @BindView(R.id.ll_quanbu)
    LinearLayout ll_quanbu;
    @BindView(R.id.tv_liruncount)
    TextView tv_liruncount;
    @BindView(R.id.tv_goodscount)
    TextView tv_goodscount;
    @BindView(R.id.tv_xinzengyonghu)
    TextView tv_xinzengyonghu;
    @BindView(R.id.tv_baifenbi)
    TextView tv_baifenbi;
    @BindView(R.id.tv_shangyuexinzengyonghu)
    TextView tv_shangyuexinzengyonghu;
    @BindView(R.id.ll_horizontal)
    LinearLayout ll_horizontal;
    @BindView(R.id.ll_vertical)
    LinearLayout ll_vertical;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_jinrixinzengyonghu)
    TextView tv_jinrixinzengyonghu;
    @BindView(R.id.tv_jinriyonghushu)
    TextView tv_jinriyonghushu;
    @BindView(R.id.tv_danwei)
    TextView tv_danwei;
    @BindView(R.id.tv_danwei2)
    TextView tv_danwei2;
    @BindView(R.id.ll_yue)
    LinearLayout ll_yue;
    @BindView(R.id.ll_zhou)
    LinearLayout ll_zhou;
    @BindView(R.id.ll_tian)
    LinearLayout ll_tian;
    @BindView(R.id.iv_mouth)
    ImageView iv_mouth;
    @BindView(R.id.iv_week)
    ImageView iv_week;
    @BindView(R.id.iv_day)
    ImageView iv_day;
    @BindView(R.id.ll_title)
    LinearLayout ll_title;
    @BindView(R.id.menu)
    LinearLayout menu;


    /**
     * Data
     */
    private PopupWindow popupWindow;
    private LinearLayout layout;
    private ListView listView;
    private int shopId;


    //商圈
    List<ShangQuanLiRun.ResultBean.BussnesslistmBean> mMonthsList;
    List<ShangQuanLiRun.ResultBean.BussnesslistwBean> mWeeksList;
    List<ShangQuanLiRun.ResultBean.BussnesslistdBean> mDaysList;
    List<ShangQuanLiRun.ResultBean.SellerlistBean> mSellerList;
    ShangQuanLiRun shangQuanLiRun;
    //总利润
    List<ZongLiRun.ResultBean.ResultMonthBean> mZongLiRunMonthsList;
    List<ZongLiRun.ResultBean.ResultWeekBean> mZongLiRunWeeksList;
    List<ZongLiRun.ResultBean.ResultDayBean> mZongLiRunDaysList;
    ZongLiRun zongLiRun;
    //销售额
    List<XiaoShouE.ResultBean.ResultMonthBean> mXiaoShouEMonthsList;
    List<XiaoShouE.ResultBean.ResultWeekBean> mXiaoShouEWeeksList;
    List<XiaoShouE.ResultBean.ResultDayBean> mXiaoShouEDaysList;
    XiaoShouE xiaoShouE;

    private int communityId;
    private int type;

    private int mType=YUE;
    private boolean isOne=true;
    private boolean isOne1=true;
    private boolean isOne2=true;
    private static final int YUE=1;
    private static final int ZHOU=2;
    private static final int TIAN=3;



    DecimalFormat df =new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xinzengyonghutongji);
        ButterKnife.bind(this);
        initUI();
        showYue();
        Intent intent=getIntent();
        type=intent.getIntExtra("type",-1);

        switch (type){
            case APP_ID.TODAY_ALL_LIRUN:
                showZongLiRun();
                getDataZongLiRun();
                break;
            case APP_ID.TODAY_ALL_SP_COUNT:
                showYongHuTongJi();
                getDataXiaoShouE();
                break;
            case APP_ID.SHANGQUAN:
                communityId=intent.getIntExtra("communityId",-1);
                showShangQuan();
                getDataShangQuan();
                break;
        }

    }

    private void initUI() {

        ll_yue.setOnClickListener(this);
        ll_zhou.setOnClickListener(this);
        ll_tian.setOnClickListener(this);
        rl_yanzhengxinxi_fanhui.setOnClickListener(this);
        ll_quanbu.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_yanzhengxinxi_fanhui:
                finish();
                break;
            case R.id.ll_quanbu:
                ll_quanbu.getTop();
                int y = ll_quanbu.getBottom() * 7/3;
                int x = getWindowManager().getDefaultDisplay().getWidth();
                menu.setBackgroundColor(0xffdddddd);
                ll_title.setBackgroundColor(0xffffffff);
                mChart.setBackgroundColor(0xffdddddd);
                mChart.setGridBackgroundColor(0xffdddddd);
                Log.i("LLL","x="+x);
                showMorePopupWindow(x, y);


                break;
            case R.id.ll_yue:
                showYue();
                break;
            case R.id.ll_zhou:
                showZhou();
                break;
            case R.id.ll_tian:
                showTian();
                break;

        }
    }
    public void showMorePopupWindow(int x, int y) {
        layout = (LinearLayout) LayoutInflater.from(XinZengTongJiActivity.this).inflate(
                R.layout.popupwindow_dialog, null);
        listView = (ListView) layout.findViewById(R.id.lv_dialog);
        List<String> list=new ArrayList<>();
        list.add("全部");
        if (mSellerList!=null) {
            for (int i = 0; i < mSellerList.size(); i++) {
                list.add(mSellerList.get(i).getName());
            }
        }


        listView.setAdapter(new ArrayAdapter<String>(XinZengTongJiActivity.this,
                R.layout.menu_item_text, R.id.tv_text, list));

        popupWindow = new PopupWindow(XinZengTongJiActivity.this);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow
                .setWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);
        popupWindow.setHeight(measureListViewWrongHeight(listView));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setContentView(layout);
        popupWindow.showAtLocation(findViewById(R.id.menu), Gravity.LEFT
                | Gravity.TOP, x, y);//需要指定Gravity，默认情况是center.
        listView.setBackgroundResource(R.drawable.e_a_bg_bombbox);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (arg2==0){
                    shopId=0;
                }else {
                    shopId = mSellerList.get(arg2 - 1).getSellerId();
                }
                popupWindow.dismiss();
                getDataShangQuan();
                popupWindow = null;
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                menu.setBackgroundColor(0xffffffff);
                mChart.setBackgroundColor(Color.rgb(255, 255, 255));
                mChart.setGridBackgroundColor(Color.rgb(255, 255, 255));
            }
        });
    }




    private void showYue(){
        mType=YUE;
        iv_mouth.setVisibility(View.VISIBLE);
        iv_week.setVisibility(View.GONE);
        iv_day.setVisibility(View.GONE);
        if (!isOne) {
            switch (type) {
                case APP_ID.TODAY_ALL_LIRUN:
                    setDataZongLiRun(zongLiRun.getResult());
                    break;
                case APP_ID.TODAY_ALL_SP_COUNT:
                    setDataXiaoShouE(xiaoShouE.getResult());
                    break;
                case APP_ID.SHANGQUAN:
                    setDataShangQuan(shangQuanLiRun.getResult());
                    break;
            }
        }
        isOne=false;


    }
    private void showZhou(){
        mType=ZHOU;
        iv_mouth.setVisibility(View.GONE);
        iv_week.setVisibility(View.VISIBLE);
        iv_day.setVisibility(View.GONE);
        switch (type){
            case APP_ID.TODAY_ALL_LIRUN:
                setDataZongLiRun(zongLiRun.getResult());
                break;
            case APP_ID.TODAY_ALL_SP_COUNT:
                setDataXiaoShouE(xiaoShouE.getResult());
                break;
            case APP_ID.SHANGQUAN:
                setDataShangQuan(shangQuanLiRun.getResult());
                break;
        }

    }
    private void showTian(){
        mType=TIAN;
        iv_mouth.setVisibility(View.GONE);
        iv_week.setVisibility(View.GONE);
        iv_day.setVisibility(View.VISIBLE);
        switch (type){
            case APP_ID.TODAY_ALL_LIRUN:
                setDataZongLiRun(zongLiRun.getResult());
                break;
            case APP_ID.TODAY_ALL_SP_COUNT:
                setDataXiaoShouE(xiaoShouE.getResult());
                break;
            case APP_ID.SHANGQUAN:
                setDataShangQuan(shangQuanLiRun.getResult());
                break;
        }

    }



    private void showShangQuan(){
        tv_goodscount.setVisibility(View.INVISIBLE);
        tv_danwei2.setVisibility(View.INVISIBLE);
        tv_danwei.setText("本月商圈总利润（元）");
        tv_danwei2.setText("商品交易总数（个)");
        tv_title.setText("商圈");
    }
    private void showZongLiRun(){
        tv_danwei.setText("本月总利润（元）");
        tv_danwei2.setText("较上月上涨");
        ll_quanbu.setVisibility(View.INVISIBLE);
        tv_title.setText("总利润统计");
    }
    private void showYongHuTongJi(){
        tv_danwei.setText("本月商品交易总数（个）");
        tv_danwei2.setText("较上月上涨");
        ll_quanbu.setVisibility(View.INVISIBLE);
        tv_title.setText("交易商品数统计");
    }
    private void getDataShangQuan(){
        String url= XY_Response.URL_QUERYBUSINESS
                +"sharerId="+ SPManager.getInstance().getString("sharerId","")
                +"&communityId="+communityId
                +"&shopId="+shopId;
        RequestCenter.all(url, ShangQuanLiRun.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                 shangQuanLiRun= (ShangQuanLiRun) responseObj;
                if (shangQuanLiRun.getCode()==0){
                    setDataShangQuan(shangQuanLiRun.getResult());
                }else {
                    MyUntil.show(XinZengTongJiActivity.this,shangQuanLiRun.getMsg());
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }
    private void getDataXiaoShouE(){
//        String url= XY_Response.URL_QUREYPROFIT
//                +"sharerId="+ SPManager.getInstance().getString("sharerId","");

        String url= XY_Response.URL_QUREYPROFIT
                +"sharerId="+SPManager.getInstance().getString("sharerId","");

        RequestCenter.all(url, XiaoShouE.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                 xiaoShouE= (XiaoShouE) responseObj;
                if (xiaoShouE.getCode()==0){
                    setDataXiaoShouE(xiaoShouE.getResult());
                }else {
                    MyUntil.show(XinZengTongJiActivity.this,xiaoShouE.getMsg());
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }
    private void getDataZongLiRun(){

        String url= XY_Response.URL_QUERYTURNOVER
                +"sharerId="+SPManager.getInstance().getString("sharerId","");

        RequestCenter.all(url, ZongLiRun.class,new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                 zongLiRun= (ZongLiRun) responseObj;
                if (zongLiRun.getCode()==0){
                    setDataZongLiRun(zongLiRun.getResult());
                }else {
                    MyUntil.show(XinZengTongJiActivity.this,zongLiRun.getMsg());
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });
    }
    private void setDataZongLiRun(ZongLiRun.ResultBean resultBean){
        mZongLiRunMonthsList=resultBean.getResultMonth();
        mZongLiRunWeeksList=resultBean.getResultWeek();
        mZongLiRunDaysList=resultBean.getResultDay();
        List<String> mStringList=new ArrayList<>();
        List<Float> mIntegerList=new ArrayList<>();
        switch (mType){
            case YUE:
                for (int i=0;i<mZongLiRunMonthsList.size();i++){
                    mStringList.add(mZongLiRunMonthsList.get(i).getDays().substring(mZongLiRunMonthsList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mZongLiRunMonthsList.get(i).getSumafter())));
                }
                break;
            case ZHOU:
                for (int i=0;i<mZongLiRunWeeksList.size();i++){
                    mStringList.add(mZongLiRunWeeksList.get(i).getDays().substring(mZongLiRunWeeksList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mZongLiRunWeeksList.get(i).getSumafter())));
                }
                break;
            case TIAN:
                for (int i=0;i<mZongLiRunDaysList.size();i++){
                    mStringList.add(mZongLiRunDaysList.get(i).getDays().substring(mZongLiRunDaysList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mZongLiRunDaysList.get(i).getSumafter())));
                }
                break;
        }
        setData(mStringList,mIntegerList);

    }
    private void setDataXiaoShouE(XiaoShouE.ResultBean resultBean){
        //销售额
        mXiaoShouEMonthsList=resultBean.getResultMonth();
        mXiaoShouEWeeksList=resultBean.getResultWeek();
        mXiaoShouEDaysList=resultBean.getResultDay();
        List<String> mStringList=new ArrayList<>();
        List<Float> mIntegerList=new ArrayList<>();
        switch (mType){
            case YUE:
                for (int i=0;i<mXiaoShouEMonthsList.size();i++){
                    mStringList.add(mXiaoShouEMonthsList.get(i).getDays().substring(mXiaoShouEMonthsList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mXiaoShouEMonthsList.get(i).getSumafter())));
                }
                break;
            case ZHOU:
                for (int i=0;i<mXiaoShouEWeeksList.size();i++){
                    mStringList.add(mXiaoShouEWeeksList.get(i).getDays().substring(mXiaoShouEWeeksList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mXiaoShouEWeeksList.get(i).getSumafter())));
                }
                break;
            case TIAN:
                for (int i=0;i<mXiaoShouEDaysList.size();i++){
                    mStringList.add(mXiaoShouEDaysList.get(i).getDays().substring(mXiaoShouEDaysList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mXiaoShouEDaysList.get(i).getSumafter())));
                }
                break;
        }
        setData(mStringList,mIntegerList);
    }
    private void setDataShangQuan(ShangQuanLiRun.ResultBean resultBean){
        mMonthsList=resultBean.getBussnesslistm();
        mWeeksList=resultBean.getBussnesslistw();
        mDaysList=resultBean.getBussnesslistd();
        if (isOne2){
            mSellerList=resultBean.getSellerlist();
            isOne2=false;
        }

        List<String> mStringList=new ArrayList<>();
        List<Float> mIntegerList=new ArrayList<>();
        switch (mType){
            case YUE:
                for (int i=0;i<mMonthsList.size();i++){
                    mStringList.add(mMonthsList.get(i).getDays().substring(mMonthsList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mMonthsList.get(i).getSumafter())));
                }
                break;
            case ZHOU:
                for (int i=0;i<mWeeksList.size();i++){
                    mStringList.add(mWeeksList.get(i).getDays().substring(mWeeksList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mWeeksList.get(i).getSumafter())));
                }
                break;
            case TIAN:
                for (int i=0;i<mDaysList.size();i++){
                    mStringList.add(mDaysList.get(i).getDays().substring(mDaysList.get(i).getDays().length()-2));
                    mIntegerList.add(Float.valueOf(df.format(mDaysList.get(i).getSumafter())));
                }
                break;
        }
        setData(mStringList,mIntegerList);
    }

    private void setData(List<String> xList,List<Float> yList) {

        Matrix m=new Matrix();
        m.postScale(1f, 1f);//两个参数分别是x,y轴的缩放比例。例如：将x轴的数据放大为之前的1.5倍
        mChart.getViewPortHandler().refresh(m, mChart, false);//将图表动画显示之前进行缩放
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
//                iEntry = (int) e.getXIndex();
//                valEntry = e.getVal();
                // 获取选中value的坐标
//                MPPointD p = this.getPixelForValues(e.getX(), e.getY(), YAxis.AxisDependency.LEFT);
//                xValuePos = p.x;
//                yValuePos = p.y;
                Log.i("LLLL",e.getXIndex()+"---"+e.getVal());


            }

            @Override
            public void onNothingSelected() {

            }
        });
        mChart.animateX(1000); // 立即执行的动画,x轴
        mChart.setEnabled(true);
        mChart.setBackgroundColor(0xffffffff);
        mChart.setTouchEnabled(true);
        mChart.setNoDataText("无数据");//没有数据时显示的文字
//        //设置是否可以拖拽，缩放
        mChart.setDragEnabled(true);
        mChart.animateY(8000, Easing.EasingOption.EaseOutQuart  ); //设置折线的动画
        mChart.setDragDecelerationEnabled(true);
        mChart.setDragDecelerationFrictionCoef(0.5f);
        mChart.setDescription("");//设置描述信息

        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
        mChart.setNoDataTextDescription("无数据");
        mChart.setDrawGridBackground(true); // 是否显示表格颜色
        mChart.setScaleEnabled(true);
        XAxis xAxis = mChart.getXAxis();
        YAxis lAxis = mChart.getAxisLeft();
        YAxis rAxis = mChart.getAxisRight();
        rAxis.setEnabled(false);
        //设置X轴的文字在底部
        xAxis.setSpaceBetweenLabels(1);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(0xff216cff);
        xAxis.setTextSize(16);
        lAxis.setTextColor(0xff216cff);
        lAxis.setTextSize(16);
        xAxis.setGridColor(0xffeef3ff);
        lAxis.setGridColor(0xffeef3ff);
        //保证Y轴从0开始，不然会上移一点
        lAxis.setAxisMinValue(0f);
        rAxis.setAxisMinValue(0f);


//        ArrayList<String> xValues = new ArrayList<>();
//        xValues.add("一");
//        xValues.add("二");
//        xValues.add("三");
//        xValues.add("四");
//        xValues.add("五");
//        xValues.add("六");
//        xValues.add("七");
//        xValues.add("八");
//        xValues.add("九");
//        xValues.add("十");
//        xValues.add("十一");
//        xValues.add("十二");
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> yValue1 = new ArrayList<>();
        for (int i=0;i<yList.size();i++){
            yValue1.add(new Entry(yList.get(i), i));
        }
        if (isOne1) {
            if (yList.size() > 0) {
                tv_liruncount.setText(yList.get(yList.size() - 1) + "");
            } else {
                tv_liruncount.setText("0");
            }
            if (yList.size() > 1) {
                tv_goodscount.setText(df.format((yList.get(yList.size() - 1) - yList.get(yList.size() - 2)) / yList.get(yList.size() - 2)) + "%");
            } else {
                tv_goodscount.setText("0");
            }
            isOne1=false;
        }





//        yValue1.add(new Entry(17, 1));
//        yValue1.add(new Entry(3, 2));
//        yValue1.add(new Entry(5, 3));
//        yValue1.add(new Entry(4, 4));
//        yValue1.add(new Entry(3, 5));
//        yValue1.add(new Entry(7, 6));
//        yValue1.add(new Entry(5, 7));
//        yValue1.add(new Entry(4, 8));
//        yValue1.add(new Entry(8, 9));
//        yValue1.add(new Entry(3, 10));
//        yValue1.add(new Entry(7, 11));
        LineDataSet dataSet1 = new LineDataSet(yValue1,"");
//        dataSet1.setColor(Color.BLACK);
        //构建一个类型为LineDataSet的ArrayList 用来存放所有 y的LineDataSet   他是构建最终加入LineChart数据集所需要的参数
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSet1.setDrawCubic(false);  //设置曲线为圆滑的线
        dataSet1.setCubicIntensity(2f);
        dataSet1.setValueTextSize(15f);
        dataSet1.setHighlightEnabled(true);
        dataSet1.setDrawCircles(true);  //设置有圆点
        dataSet1.setLineWidth(3f);    //设置线的宽度
//        dataSet1.setCircleSize(5f);   //设置小圆的大小
        dataSet1.setHighLightColor(Color.rgb(33,108,255));
        dataSet1.setColor(Color.rgb(33,108,255));    //设置曲线的颜色

        dataSet1.setColor(Color.rgb(33,108,255));
        dataSet1.setCircleColor(Color.rgb(33,108,255));
//        dataSet1.setLineWidth(1f);
        //设置曲线值的圆点是实心还是空心
        dataSet1.setDrawCircleHole(false);
        dataSet1.setValueTextSize(9f);
        //设置折线图填充
        dataSet1.setDrawFilled(true);
//设置圆心半径
        dataSet1.setCircleSize(1.6f);
//设置曲线值的圆点是实心还是空心
        dataSet1.setDrawCircleHole(false);


        //将数据加入dataSets
        dataSets.add(dataSet1);
        //构建一个LineData  将dataSets放入
        LineData lineData = new LineData(xList, dataSets);
//        if (Utils.getSDKInt() >= 18) {
//            // fill drawable only supported on api level 18 and above
//            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
//            dataSet1.setFillDrawable(drawable);
//        }
//        else {
//            dataSet1.setFillColor(Color.BLACK);
//        }
        //将数据插入

        Legend l = mChart.getLegend();//图例
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_INSIDE);//设置图例的位置
        l.setTextSize(0f);//设置文字大小
        l.setForm(Legend.LegendForm.CIRCLE);//正方形，圆形或线
        l.setFormSize(0f); // 设置Form的大小
        l.setWordWrapEnabled(true);//是否支持自动换行 目前只支持BelowChartLeft, BelowChartRight, BelowChartCenter
        l.setFormToTextSpace(0f);//设置Form的宽度

        lineData.setDrawValues(false);
        MarkerView mv = new MyMarkerView(this,R.layout.content_marker_view);
        mChart.setMarkerView(mv);
        mChart.setData(lineData);

        mChart.setBackgroundColor(Color.rgb(255, 255, 255));
        mChart.setGridBackgroundColor(Color.rgb(255, 255, 255));
//        //设置Y轴前后倒置
////        mChart.setInvertYAxisEnabled(false);
////        //设置高亮显示
////        mChart.setHighlightEnabled(true);
//        //设置是否可以触摸，如为false，则不能拖动，缩放等
//        mChart.setTouchEnabled(true);
//        //设置是否可以拖拽，缩放
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//        //设置是否能扩大扩小
//        mChart.setPinchZoom(true);
//        // 设置背景颜色
////         mChart.setBackgroundColor(Color.GRAY);
//        //设置点击chart图对应的数据弹出标注
////        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
//        // define an offset to change the original position of the marker
//        // (optional)
////        mv.setOffsets(-mv.getMeasuredWidth() / 2, -mv.getMeasuredHeight());
////        mv.setMinimumHeight(80);
////        // set the marker to the chart
////        mChart.setMarkerView(mv);
////        // enable/disable highlight indicators (the lines that indicate the
////        // highlighted Entry)
////        mChart.setHighlightIndicatorEnabled(false);
//        //设置字体格式，如正楷
////        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/HanYi.ttf");
//        Typeface tf = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
//        mChart.setDescriptionTypeface(tf);
//        LimitLine ll1 = new LimitLine(95f, "警戒值 95%");
//        ll1.setLineWidth(2f);
////        ll1.setLineColor(Color.rgb(0,0,0));
////        ll1.enableDashedLine(10f, 10f, 0f);
//        ll1.setLabelPosition(LimitLine.LimitLabelPosition.LEFT_TOP);
//        ll1.setTextSize(15f);
//        ll1.setTypeface(tf);
//        XAxis xl = mChart.getXAxis();
////      xl.setAvoidFirstLastClipping(true);
////      xl.setAdjustXLabels(true);
//        xl.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的数据在底部显示
//        xl.setTypeface(tf); // 设置字体
//        xl.setTextSize(10f); // 设置字体大小
//        xl.setSpaceBetweenLabels(0); // 设置数据之间的间距'
//        YAxis yl = mChart.getAxisLeft();
//        yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
////      yl.setAxisMaxValue(220f);
//        yl.addLimitLine(ll1);
//        yl.setTypeface(tf); // 设置字体
//        yl.setTextSize(10f); // s设置字体大小
//        yl.setTypeface(tf);
//        yl.setAxisMinValue(90f);
//        yl.setStartAtZero(false);
////      yl.setLabelCount(5); // 设置Y轴最多显示的数据个数
//        YAxis y2 = mChart.getAxisRight();
//        y2.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//        y2.setTypeface(tf); // 设置字体
//        y2.setTextSize(10f); // s设置字体大小
//        y2.setTypeface(tf);
//        y2.setAxisMinValue(90f);
//        y2.setStartAtZero(false);
//        getData();
//        new Thread(mRunnable).start();
    }

    public int measureListViewWrongHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return 0;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight +=  listItem.getMeasuredHeight();
        }
        // 减掉底部分割线的高度
        int historyHeight = totalHeight
                + (listView.getDividerHeight() * listAdapter.getCount() - 1);
        return historyHeight; //输出最终ListView的高度
    }


}
