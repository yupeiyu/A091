package com.example.android.a091;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExamplesAdapter extends BaseAdapter { //把東西補足
    ArrayList<String> exs;
    LayoutInflater inflater;

    public ExamplesAdapter(Context context, ArrayList<String> exs) {//產生建構  ??
        this.exs = exs; //建構子 generate Constructor
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return exs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            view=inflater.inflate(R.layout.list_item,null);
            holder.ex=(TextView) view.findViewById(R.id.textView);
        view.setTag(holder);}
        else {
            holder=(ViewHolder)view.getTag();
        }
        String item=exs.get(position);
        if(item!=null&holder.ex!=null) {
            holder.ex.setText(item);  //Bug處!!!!!!!!
        }
        return view;// bug處!!!!!!!!
    }
    static class ViewHolder{ //不用new就可以用 static，holder=支架支撐範例
        TextView ex;

    }
}
