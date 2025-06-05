package com.example.parsejsonapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnparse;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnparse = findViewById(R.id.btnparse);
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();

        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        btnparse.setOnClickListener(v -> parsejson());
    }

    private void parsejson() {
        String json = null;

        try {
            InputStream inputStream = getAssets().open("computer.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, "UTF-8");

            JSONObject reader = new JSONObject(json);

            mylist.add(reader.getString("MaDM"));
            mylist.add(reader.getString("TenDM"));

            JSONArray array = reader.getJSONArray("Sanphams");

            for (int i = 0; i < array.length(); i++) {
                JSONObject sp = array.getJSONObject(i);
                String item = sp.getString("MaSP") + " - " + sp.getString("TenSP");
                mylist.add(item);

                String tinhTien = sp.getInt("SoLuong") + " * " + sp.getInt("DonGia") + " = " + sp.getInt("ThanhTien");
                mylist.add(tinhTien);

                mylist.add(sp.getString("Hinh"));
            }

            myadapter.notifyDataSetChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
