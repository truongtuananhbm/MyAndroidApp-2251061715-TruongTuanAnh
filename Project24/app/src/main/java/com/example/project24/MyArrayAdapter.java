package com.example.project24;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class MyArrayAdapter extends ArrayAdapter<Tygia> {
    private Activity context;
    private int resource;
    private List<Tygia> objects;

    public MyArrayAdapter(Activity context, int resource, List<Tygia> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(resource, null);

        Tygia tygia = objects.get(position);

        ImageView imgAnh = row.findViewById(R.id.imgAnh);
        TextView txtType = row.findViewById(R.id.txtType);
        TextView txtMuack = row.findViewById(R.id.txtMuack);
        TextView txtBanra = row.findViewById(R.id.txtBanra);
        TextView txtBank = row.findViewById(R.id.txtBank);

        imgAnh.setImageBitmap(tygia.getBitmap());
        txtType.setText(tygia.getType());
        txtMuack.setText("Mua CK: " + tygia.getMuack());
        txtBanra.setText("Bán TM: " + tygia.getBantienmat());
        txtBank.setText(tygia.getBank());

        return row;
    }
}

