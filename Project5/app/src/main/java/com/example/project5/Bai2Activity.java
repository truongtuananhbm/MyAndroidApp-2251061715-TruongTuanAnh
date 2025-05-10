package com.example.project5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity; // ✅ Phải thêm dòng này

public class Bai2Activity extends AppCompatActivity {
    EditText editA, editB, editC;
    TextView tvKetQua;
    Button btnGiai, btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        editC = findViewById(R.id.editC);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnGiai = findViewById(R.id.btnGiai);
        btnBack2 = findViewById(R.id.btnBack2);

        btnGiai.setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(editA.getText().toString());
                double b = Double.parseDouble(editB.getText().toString());
                double c = Double.parseDouble(editC.getText().toString());

                String result;
                if (a == 0) {
                    result = (b == 0) ? "PT vô nghiệm" : "PT có 1 nghiệm: x = " + (-c / b);
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) result = "PT vô nghiệm";
                    else if (delta == 0) result = "PT có nghiệm kép x = " + (-b / (2 * a));
                    else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        result = "PT có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2;
                    }
                }
                tvKetQua.setText(result);
            } catch (Exception e) {
                tvKetQua.setText("Vui lòng nhập đúng dữ liệu.");
            }
        });

        btnBack2.setOnClickListener(v -> finish());
    }
}
