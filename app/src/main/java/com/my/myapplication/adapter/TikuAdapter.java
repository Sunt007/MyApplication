package com.my.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.my.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/19.
 */

public class TikuAdapter extends BaseAdapter {
    private ArrayList<Map<String, Object>> lists;
    private Context context;
    public TikuAdapter(ArrayList<Map<String, Object>> lists,Context context){
        this.lists = lists;
        this.context = context;
    }
    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tiku,null);
            holder.tiku_icon = (ImageView) convertView.findViewById(R.id.tiku_icon);
            holder.tiku_name = (TextView) convertView.findViewById(R.id.tiku_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tiku_icon.setImageResource(R.drawable.ic_launcher);
        holder.tiku_name.setText(lists.get(position).get("ItemTitle").toString());
        return convertView;
    }

    class ViewHolder{
        ImageView tiku_icon;
        TextView tiku_name;
    }
}
