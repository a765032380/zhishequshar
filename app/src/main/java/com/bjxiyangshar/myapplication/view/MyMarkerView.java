package com.bjxiyangshar.myapplication.view;

import android.content.Context;
import android.widget.TextView;

import com.bjxiyangshar.myapplication.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

/**
 * Created by Administrator on 2017/9/26 0026.
 */

public class MyMarkerView extends MarkerView {
    private TextView mContentTv;

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        mContentTv = (TextView) findViewById(R.id.tv_content_marker_view);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        mContentTv.setText("" + e.getVal());
    }

    @Override
    public int getXOffset(float xpos) {
        return -(getWidth() / 2);
    }

    @Override
    public int getYOffset(float ypos) {
        return -getHeight();
    }
}