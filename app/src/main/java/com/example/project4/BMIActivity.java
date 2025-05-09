package com.example.project4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class BMIActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText h = findViewById(R.id.editChieuCao);
        EditText w = findViewById(R.id.editCanNang);
        EditText bmi = findViewById(R.id.editBMI);
        EditText chandoan = findViewById(R.id.editChuanDoan);
        Button tinh = findViewById(R.id.btnTinh);

        tinh.setOnClickListener(v -> {
            double H = Double.parseDouble(h.getText().toString());
            double W = Double.parseDouble(w.getText().toString());
            double value = W / Math.pow(H, 2);

            bmi.setText(String.format("%.1f", value));
            String result;
            if (value < 18) result = "Gầy";
            else if (value < 24.9) result = "Bình thường";
            else if (value < 29.9) result = "Béo phì độ I";
            else if (value < 34.9) result = "Béo phì độ II";
            else result = "Béo phì độ III";
            chandoan.setText(result);
        });
    }
}
