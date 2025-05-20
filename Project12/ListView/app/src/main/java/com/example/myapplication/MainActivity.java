package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> adapter;
    EditText edthour, edtmin, edtwork;
    TextView txtdate;
    Button btnwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edthour = findViewById(R.id.edithour);
        edtmin = findViewById(R.id.editmin);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnwork);
        txtdate = findViewById(R.id.txtdate);
        lv = findViewById(R.id.lv1);

        arraywork = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: " + sdf.format(calendar.getTime()));

        btnwork.setOnClickListener(view -> {
            String hour = edthour.getText().toString().trim();
            String minute = edtmin.getText().toString().trim();
            String content = edtwork.getText().toString().trim();

            if (hour.isEmpty() || minute.isEmpty() || content.isEmpty()) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thiếu thông tin")
                        .setMessage("Vui lòng nhập đầy đủ nội dung, giờ và phút!")
                        .setPositiveButton("OK", null)
                        .show();
            } else {
                String result = content + " - " + hour + ":" + minute;
                arraywork.add(result);
                adapter.notifyDataSetChanged();

                edtwork.setText("");
                edthour.setText("");
                edtmin.setText("");
            }
        });
    }
}
