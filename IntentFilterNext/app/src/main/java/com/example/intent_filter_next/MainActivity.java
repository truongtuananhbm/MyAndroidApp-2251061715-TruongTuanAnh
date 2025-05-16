package com.example.intent_filter_next;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCall, btnSMS, btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        btnCamera = findViewById(R.id.btnCamera);
        btnCall.setOnClickListener(v -> startActivity(new Intent(this, CallActivity.class)));
        btnSMS.setOnClickListener(v->startActivity(new Intent(this, SendSMSActivity.class)));
        btnCamera.setOnClickListener(v->startActivity(new Intent(this, CameraActivity.class)));
    }
}