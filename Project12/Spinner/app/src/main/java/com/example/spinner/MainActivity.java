package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] arr1 = {
            "Hàng tiêu dùng",
            "Hàng hóa chất",
            "Hàng gia dụng",
            "Hàng xây dựng",
            "Hàng thời trang"
    };

    TextView txt1;
    Spinner spin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        spin1 = findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                arr1
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adapter1);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt1.setText("Loại hàng đã chọn: " + arr1[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txt1.setText("Bạn chưa chọn loại hàng.");
            }
        });
    }
}
