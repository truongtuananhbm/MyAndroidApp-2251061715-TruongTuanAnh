package com.example.intent_filter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB, edtKQ;
    Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnRequest = findViewById(R.id.btnrequest);

        btnRequest.setOnClickListener(v -> {
            Intent myIntent = new Intent(MainActivity.this, ChildActivity.class);
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            myIntent.putExtra("soa", a);
            myIntent.putExtra("sob", b);
            startActivityForResult(myIntent, 99);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 99 && resultCode == 33) {
            int sum = data.getIntExtra("kq", 0);
            edtKQ.setText("Tổng là: " + sum);
        }

        if (requestCode == 99 && resultCode == 34) {
            int sub = data.getIntExtra("kq", 0);
            edtKQ.setText("Hiệu là: " + sub);
        }
    }
}
