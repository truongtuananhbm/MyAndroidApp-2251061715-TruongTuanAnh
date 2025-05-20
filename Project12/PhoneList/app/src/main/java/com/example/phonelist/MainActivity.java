package com.example.phonelist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    ListView lv1;

    String[] arr = {
            "Iphone 7", "Samsung Galaxy S7",
            "Nokia Lumia 730", "Sony Xperia XZ", "HTC One E9"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv_selection);
        lv1 = findViewById(R.id.lv1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener((adapterView, view, position, id) -> {
            String selected = arr[position];
            tv1.setText("Bạn chọn: " + selected + " (vị trí " + position + ")");
        });
    }
}
