package com.example.demorcyclelife;
import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demor_cyclelife.R;


public class MainActivity extends AppCompatActivity{

    Button btnCall;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiển thị thông báo ngắn khi Activity vừa mở
        Toast.makeText(this, "CR424 - onCreate()", Toast.LENGTH_SHORT).show();

        // Ánh xạ button từ layout
        btnCall = findViewById(R.id.btnCall);

        // Gán sự kiện click cho button
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi click nút, mở SubActivity
                Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent1);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "CR424 - onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "CR424 - onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "CR424 - onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "CR424 - onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "CR424 - onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "CR424 - onStop", Toast.LENGTH_SHORT).show();
    }

}
