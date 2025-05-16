package com.example.intent_filter_next;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SendSMSActivity extends AppCompatActivity {
    EditText edtNumber, edtMessage;
    ImageButton btnSend;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtNumber = findViewById(R.id.edtSMSNumber);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSendSMS);
        btnBack = findViewById(R.id.btnBackSMS);

        btnSend.setOnClickListener(v -> {
            String number = edtNumber.getText().toString();
            String message = edtMessage.getText().toString();
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
            smsIntent.putExtra("sms_body", message);
            startActivity(smsIntent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
