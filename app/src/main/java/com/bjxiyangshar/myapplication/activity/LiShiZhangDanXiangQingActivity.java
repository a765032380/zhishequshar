package com.bjxiyangshar.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baisi.myapplication.okhttp.listener.DisposeDataListener;
import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.base.MySwipeBackActivity;
import com.bjxiyangshar.myapplication.bean.LiShiZhangDanXiangQing;
import com.bjxiyangshar.myapplication.bean.ShangQuanLiRun;
import com.bjxiyangshar.myapplication.connectionsURL.XY_Response;
import com.bjxiyangshar.myapplication.manager.SPManager;
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
 * Created by Administrator on 2017/9/26 0026.
 */

public class LiShiZhangDanXiangQingActivity extends MySwipeBackActivity
        implements View.OnClickListener{
    /**
     * UI
     */
    @BindView(R.id.rl_lishizhnagdnaxiangqing_fanhui)
    RelativeLayout rl_lishizhnagdnaxiangqing_fanhui;
    @BindView(R.id.tv_start_data)
    TextView tv_start_data;
    @BindView(R.id.tv_end_data)
    TextView tv_end_data;
    @BindView(R.id.tv_zonglirun)
    TextView tv_zonglirun;
    @BindView(R.id.tv_zuigaoshouru)
    TextView tv_zuigaoshouru;
    @BindView(R.id.linechart)
    LineChart mChart;


    private String begin;
    private String end;
    private double money;
    List<LiShiZhangDanXiangQing.ResultBean.SettleMentDetailBean> mLiShiZhangDanList;
    DecimalFormat df =new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lishizhangdanxiangqing);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        begin=intent.getStringExtra("begin");
        end=intent.getStringExtra("end");
        money=intent.getDoubleExtra("money",0);
        initUI();
        initData();
        getData();

    }

    private void initUI() {
        rl_lishizhnagdnaxiangqing_fanhui.setOnClickListener(this);
    }

    private void initData() {
        Matrix m=new Matrix();
        m.postScale(1.5f, 1f);//两个参数分别是x,y轴的缩放比例。例如：将x轴的数据放大为之前的1.5倍
        mChart.getViewPortHandler().refresh(m, mChart, false);//将图表动画显示之前进行缩放
        mChart.animateX(1000); // 立即执行的动画,x轴
        mChart.setEnabled(true);
        mChart.setBackgroundColor(0xffffffff);
        mChart.setTouchEnabled(true);

//        //设置是否可以拖拽，缩放
        mChart.setDragEnabled(true);
        mChart.animateY(8000, Easing.EasingOption.EaseOutQuart  ); //设置折线的动画
        mChart.setGridBackgroundColor(0xff000000);
        mChart.setDragDecelerationEnabled(true);
        mChart.setDragDecelerationFrictionCoef(0.5f);
        mChart.setDescription("");//设置颜色
        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
//        mChart.setNoDataTextDescription("You need to provide data for the chart.");
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
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("一");
        xValues.add("二");
        xValues.add("三");
        xValues.add("四");
        xValues.add("五");
        xValues.add("六");
        xValues.add("七");
        xValues.add("八");
        xValues.add("九");
        xValues.add("十");
        xValues.add("十一");
        xValues.add("十二");
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> yValue1 = new ArrayList<>();
        yValue1.add(new Entry(7, 0));
        yValue1.add(new Entry(17, 1));
        yValue1.add(new Entry(3, 2));
        yValue1.add(new Entry(5, 3));
        yValue1.add(new Entry(4, 4));
        yValue1.add(new Entry(3, 5));
        yValue1.add(new Entry(7, 6));
        yValue1.add(new Entry(5, 7));
        yValue1.add(new Entry(4, 8));
        yValue1.add(new Entry(8, 9));
        yValue1.add(new Entry(3, 10));
        yValue1.add(new Entry(7, 11));
        LineDataSet dataSet1 = new LineDataSet(yValue1,"");
//        dataSet1.setColor(Color.BLACK);
        //构建一个类型为LineDataSet的ArrayList 用来存放所有 y的LineDataSet   他是构建最终加入LineChart数据集所需要的参数
        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSet1.setDrawCubic(false);  //设置曲线为圆滑的线
        dataSet1.setCubicIntensity(2f);
        dataSet1.setValueTextSize(15f);
        dataSet1.setHighlightEnabled(true);
        dataSet1.setDrawFilled(false);  //设置包括的范围区域填充颜色
        dataSet1.setDrawCircles(false);  //设置有圆点
        dataSet1.setLineWidth(3f);    //设置线的宽度
//        dataSet1.setCircleSize(5f);   //设置小圆的大小
        dataSet1.setHighLightColor(Color.rgb(33,108,255));
        dataSet1.setColor(Color.rgb(33,108,255));    //设置曲线的颜色
        //将数据加入dataSets
        dataSets.add(dataSet1);
        //构建一个LineData  将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);
//        if (Utils.getSDKInt() >= 18) {
//            // fill drawable only supported on api level 18 and above
//            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
//            dataSet1.setFillDrawable(drawable);
//        }
//        else {
//            dataSet1.setFillColor(Color.BLACK);
//        }
        //将数据插入
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_lishizhnagdnaxiangqing_fanhui:
                finish();
                break;
        }
    }
    private void getData(){
//        String url= XY_Response.URL_QUERYSETTLEMENT_DETAIL
//                +"sharerId="+ SPManager.getInstance().getString("sharerId","")
//                +"&beginDate="+begin
//                +"&endDate="+end;
        String url= XY_Response.URL_QUERYSETTLEMENT_DETAIL
                +"sharerId="+ SPManager.getInstance().getString("sharerId","")
                +"&beginDate="+begin
                +"&endDate="+end;



        RequestCenter.all(url, LiShiZhangDanXiangQing.class, new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                LiShiZhangDanXiangQing liShiZhangDanXiangQing= (LiShiZhangDanXiangQing) responseObj;
                if (liShiZhangDanXiangQing.getCode()==0){
                    tv_zuigaoshouru.setText(liShiZhangDanXiangQing.getResult().getMaxsettle()+"");
                    mLiShiZhangDanList=liShiZhangDanXiangQing.getResult().getSettleMentDetail();
                    List<String> mStringList=new ArrayList<>();
                    List<Float> mIntegerList=new ArrayList<>();
                    for (int i=0;i<mLiShiZhangDanList.size();i++){
                        mStringList.add(mLiShiZhangDanList.get(i).getDays().substring(mLiShiZhangDanList.get(i).getDays().length()-2));
                        mIntegerList.add(Float.valueOf(df.format(mLiShiZhangDanList.get(i).getSumafter())));
                    }
                    setData(mStringList,mIntegerList);
                }
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        });

    }
    private void setData(List<String> xList, List<Float> yList) {
        tv_start_data.setText(begin);
        tv_end_data.setText(end);
        tv_zonglirun.setText(money+"");
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
        mChart.setGridBackgroundColor(0xff000000);
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
        dataSet1.setLineWidth(1f);
        //设置曲线值的圆点是实心还是空心
        dataSet1.setDrawCircleHole(false);
        dataSet1.setValueTextSize(9f);
        //设置折线图填充
        dataSet1.setDrawFilled(true);
//设置圆心半径
        dataSet1.setCircleSize(3f);
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


}
