package com.example.vnexpress;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;
public class MyArrayAdapter extends ArrayAdapter<List> {
    private Activity context;
    private int layoutID;
    private ArrayList<List> arr;

    public MyArrayAdapter(Activity context, int layoutID, ArrayList<List> arr) {
        super(context, layoutID, arr);
        this.context = context;
        this.layoutID = layoutID;
        this.arr = arr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);

        ImageView img = convertView.findViewById(R.id.imgView);
        TextView title = convertView.findViewById(R.id.txtTitle);
        TextView info = convertView.findViewById(R.id.txtInfo);

        List item = arr.get(position);
        img.setImageBitmap(item.getImg());
        title.setText(item.getTitle());
        info.setText(item.getInfo());

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
            context.startActivity(intent);
        });

        return convertView;
    }
}

