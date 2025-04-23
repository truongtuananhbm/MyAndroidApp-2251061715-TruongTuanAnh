package com.example.mobie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến giao diện
    EditText edtA, edtB, edtKQ;
    Button btnCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Gắn layout

        // Ánh xạ ID cho các thành phần trong layout
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnCong = findViewById(R.id.btnCong);

        // Xử lý khi click nút "Cộng"
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Lấy dữ liệu từ EditText và chuyển sang số nguyên
                    int a = Integer.parseInt(edtA.getText().toString());
                    int b = Integer.parseInt(edtB.getText().toString());

                    // Cộng hai số lại
                    int c = a + b;

                    // Hiển thị kết quả ra EditText KQ
                    edtKQ.setText(String.valueOf(c));

                } catch (NumberFormatException e) {
                    edtKQ.setText("Lỗi nhập số!");
                }
            }
        });
    }
}
