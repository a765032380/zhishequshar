package com.bjxiyangshar.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bjxiyangshar.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class SelectShangQuanAdapter extends BaseAdapter {
    private Context mContext;
    private List mList;

    public SelectShangQuanAdapter(Context mContext, List mList) {
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
            view= LayoutInflater.from(mContext).inflate(R.layout.item_xuanzeshangquan,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.tv_shangquan.setText("");
        holder.tv_shangquanlirun.setText("");

        return view;
    }
    class ViewHolder{

        @BindView(R.id.tv_shangquan)
        TextView tv_shangquan;
        @BindView(R.id.tv_shangquanlirun)
        TextView tv_shangquanlirun;



        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }

    }
}
