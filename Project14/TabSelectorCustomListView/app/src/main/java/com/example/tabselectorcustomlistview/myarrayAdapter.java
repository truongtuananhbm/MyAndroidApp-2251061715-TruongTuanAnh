package com.example.tabselectorcustomlistview;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class myarrayAdapter extends ArrayAdapter<Item> {
    Activity context;
    int layoutId;
    ArrayList<Item> myarray;

    public myarrayAdapter(Activity context, int layoutId, ArrayList<Item> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myarray = arr;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        Item item = myarray.get(pos);

        TextView maso = convertView.findViewById(R.id.txtmaso);
        TextView tieude = convertView.findViewById(R.id.txttieude);
        ImageView btnlike = convertView.findViewById(R.id.btnlike);

        maso.setText(item.getMaso());
        tieude.setText(item.getTieude());

        if (item.getThich() == 1) {
            btnlike.setImageResource(R.drawable.like);
        } else {
            btnlike.setImageResource(R.drawable.unlike);
        }

        return convertView;
    }
}

