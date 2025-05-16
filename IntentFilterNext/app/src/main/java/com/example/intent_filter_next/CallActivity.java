package com.example.intent_filter_next;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class CallActivity extends AppCompatActivity {
    EditText edtPhone;
    ImageButton btnCall;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        edtPhone = findViewById(R.id.edtPhone);
        btnCall = findViewById(R.id.btnCall);
        btnBack = findViewById(R.id.btnBack);

        btnCall.setOnClickListener(v -> {
            String phone = edtPhone.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            startActivity(callIntent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
