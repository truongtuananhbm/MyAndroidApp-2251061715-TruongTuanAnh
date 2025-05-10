package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnBai1, btnBai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBai1 = findViewById(R.id.btnBai1);
        btnBai2 = findViewById(R.id.btnBai2);

        btnBai1.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Bai1Activity.class));
        });

        btnBai2.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Bai2Activity.class));
        });
    }
}
