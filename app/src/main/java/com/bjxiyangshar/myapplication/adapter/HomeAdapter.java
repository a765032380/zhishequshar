package com.bjxiyangshar.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bjxiyangshar.myapplication.R;
import com.bjxiyangshar.myapplication.bean.Init;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class HomeAdapter extends BaseAdapter {
    private Context mContext;
    private List<Init.ResultBean.TradingListBean> mList;

    public HomeAdapter(Context mContext, List<Init.ResultBean.TradingListBean> mList) {
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
            view= LayoutInflater.from(mContext).inflate(R.layout.item_home,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.tv_title.setText(mList.get(i).getCommunityName()+"今日总利润");
        if (mList.get(i).getSummoney()==null){
            holder.tv_count.setText("0");
        }else {
            holder.tv_count.setText(mList.get(i).getSummoney()+"");
        }

        holder.tv_gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到更多
            }
        });

        return view;
    }
    class ViewHolder{

        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_gengduo)
        TextView tv_gengduo;
        @BindView(R.id.tv_count)
        TextView tv_count;



        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }



}
