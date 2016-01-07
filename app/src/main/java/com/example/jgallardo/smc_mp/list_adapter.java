package com.example.jgallardo.smc_mp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class list_adapter extends BaseAdapter{

    private ArrayList<?> in;
    private int R_layout_IdView;
    private Context context;

    public list_adapter(Context context, int R_layout_IdView, ArrayList<?> in){
        super();
        this.context = context;
        this.in = in;
        this.R_layout_IdView = R_layout_IdView;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        if(view == null){
            LayoutInflater v = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = v.inflate(R_layout_IdView, null);
        }
        onEntrance(in.get(position), view);
        return view;
    }

    protected abstract void onEntrance(Object in, View view);

    @Override
    public int getCount(){
        return in.size();
    }

    @Override
    public Object getItem(int  position){
        return in.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }
}
