package com.example.gridviewimageapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView selection;
    GridView gridView;

    // Danh sách tên ảnh (không có đuôi .png)
    String[] items = {"hinh1", "hinh2", "hinh3", "hinh4", "hinh5", "hinh6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = findViewById(R.id.selection);
        gridView = findViewById(R.id.gridview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            selection.setText("Bạn chọn: " + items[i]);

            // Mở màn hình mới và gửi tên ảnh
            Intent intent = new Intent(MainActivity.this, ImageActivity.class);
            intent.putExtra("imgName", items[i]);
            startActivity(intent);
        });
    }
}
