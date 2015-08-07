package com.fyales.expanddemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author fyales
 * @since 8/7/15.
 */
public class CountryAdapter extends BaseAdapter{

    private Context mContext;
    private String[] mList;

    public CountryAdapter(Context context,String[] countrys){
        mContext = context;
        mList = countrys;
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public String getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item,null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv1);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String s = getItem(position);
        holder.tv.setText(s);

        return convertView;
    }

    static class ViewHolder{
        TextView tv;
    }
}
