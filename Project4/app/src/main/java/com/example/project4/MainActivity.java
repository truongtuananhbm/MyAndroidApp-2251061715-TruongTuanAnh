package com.example.project4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

    EditText edtF, edtC;
    Button btnC, btnF, btnClear, btnGoToBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtF = findViewById(R.id.edtF);
        edtC = findViewById(R.id.edtC);
        btnC = findViewById(R.id.btnC);
        btnF = findViewById(R.id.btnF);
        btnClear = findViewById(R.id.btnClear);
        btnGoToBMI = findViewById(R.id.btnGoToBMI);

        btnC.setOnClickListener(v -> {
            DecimalFormat df = new DecimalFormat("##.##");
            double f = Double.parseDouble(edtF.getText().toString());
            double c = (f - 32) * 5 / 9;
            edtC.setText(df.format(c));
        });

        btnF.setOnClickListener(v -> {
            DecimalFormat df = new DecimalFormat("##.##");
            double c = Double.parseDouble(edtC.getText().toString());
            double f = c * 9 / 5 + 32;
            edtF.setText(df.format(f));
        });

        btnClear.setOnClickListener(v -> {
            edtF.setText("");
            edtC.setText("");
        });

        // 👉 THÊM CHUYỂN MÀN
        btnGoToBMI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BMIActivity.class);
            startActivity(intent);
        });
    }
}
