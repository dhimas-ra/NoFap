package com.example.nofap.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nofap.Home_Activity;
import com.example.nofap.R;
import com.example.nofap.database.tobat;

import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {


    Context mContext;
    LayoutInflater inflater;
    private ArrayList<tobat> listdata;

    public DataAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.listdata = new ArrayList<tobat>();
        this.listdata.addAll(Home_Activity.tobatArrayList);
    }

    public class ViewHolder {
        TextView judul;
    }


    @Override
    public int getCount() {
        return Home_Activity.tobatArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Activity.tobatArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview, null);
            holder.judul = (TextView) view.findViewById(R.id.textJudul);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        holder.judul.setText(Home_Activity.tobatArrayList.get(i).getJudul());
        return view;
    }
}



