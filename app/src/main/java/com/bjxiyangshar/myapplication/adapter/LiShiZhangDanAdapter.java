package com.bjxiyangshar.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.bean.LiShiZhangDan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class LiShiZhangDanAdapter extends BaseAdapter {
    private Context mContext;
    private List<LiShiZhangDan.ResultBean.SettlelistBean> mList;

    public LiShiZhangDanAdapter(Context mContext, List<LiShiZhangDan.ResultBean.SettlelistBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_lishizhangdan,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.tv_lishijine.setText(mList.get(i).getSettlement_total()+"");
        holder.tv_shangquanlirun.setText(mList.get(i).getCycle_begin());
        holder.tv_jiezhishijian.setText(mList.get(i).getCycle_end());
//        holder.ll_gengduoxinxi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到更多
//            }
//        });

        return view;
    }
    class ViewHolder{

        @BindView(R.id.tv_lishijine)
        TextView tv_lishijine;
        @BindView(R.id.tv_shangquanlirun)
        TextView tv_shangquanlirun;
        @BindView(R.id.tv_jiezhishijian)
        TextView tv_jiezhishijian;
        @BindView(R.id.ll_gengduoxinxi)
        LinearLayout ll_gengduoxinxi;



        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }



}
