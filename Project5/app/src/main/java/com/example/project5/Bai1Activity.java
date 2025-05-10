package com.example.project5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity; // ✅ Bắt buộc phải có

public class Bai1Activity extends AppCompatActivity {
    EditText edtNamDuong;
    Button btnChuyenDoi, btnBack1;
    TextView tvNamAm;

    String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mẹo", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        edtNamDuong = findViewById(R.id.edtNamDuong);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);
        btnBack1 = findViewById(R.id.btnBack1);
        tvNamAm = findViewById(R.id.tvNamAm);

        btnChuyenDoi.setOnClickListener(v -> {
            String s = edtNamDuong.getText().toString();
            if (!s.isEmpty()) {
                int year = Integer.parseInt(s);
                String namAm = can[year % 10] + " " + chi[year % 12];
                tvNamAm.setText("Năm âm lịch: " + namAm);
            } else {
                tvNamAm.setText("Vui lòng nhập năm dương lịch.");
            }
        });

        btnBack1.setOnClickListener(v -> finish());
    }
}
