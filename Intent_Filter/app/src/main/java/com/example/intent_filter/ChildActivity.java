package com.example.intent_filter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {

    EditText edtAA, edtBB;
    Button btnTong, btnHieu;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtAA = findViewById(R.id.edtAA);
        edtBB = findViewById(R.id.edtBB);
        btnTong = findViewById(R.id.btnsenttong);
        btnHieu = findViewById(R.id.btnsenthieu);

        myIntent = getIntent();
        int a = myIntent.getIntExtra("soa", 0);
        int b = myIntent.getIntExtra("sob", 0);
        edtAA.setText(String.valueOf(a));
        edtBB.setText(String.valueOf(b));

        btnTong.setOnClickListener(v -> {
            int sum = a + b;
            myIntent.putExtra("kq", sum);
            setResult(33, myIntent);
            finish();
        });

        btnHieu.setOnClickListener(v -> {
            int sub = a - b;
            myIntent.putExtra("kq", sub);
            setResult(34, myIntent);
            finish();
        });
    }
}
