package bmi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.project4.R;

import java.text.DecimalFormat;

public class BMIActivity extends Activity {

    EditText editTen, editChieuCao, editCanNang, editBMI, editChuanDoan;
    Button btnTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        editTen = findViewById(R.id.editTen);
        editChieuCao = findViewById(R.id.editChieuCao);
        editCanNang = findViewById(R.id.editCanNang);
        editBMI = findViewById(R.id.editBMI);
        editChuanDoan = findViewById(R.id.editChuanDoan);
        btnTinh = findViewById(R.id.btnTinh);

        btnTinh.setOnClickListener(v -> {
            double H = Double.parseDouble(editChieuCao.getText().toString());
            double W = Double.parseDouble(editCanNang.getText().toString());
            double BMI = W / Math.pow(H, 2);

            DecimalFormat df = new DecimalFormat("#.0");
            editBMI.setText(df.format(BMI));

            String chandoan;
            if (BMI < 18)
                chandoan = "Bạn gầy";
            else if (BMI < 24.9)
                chandoan = "Bạn bình thường";
            else if (BMI < 29.9)
                chandoan = "Bạn béo phì độ 1";
            else if (BMI < 34.9)
                chandoan = "Bạn béo phì độ 2";
            else
                chandoan = "Bạn béo phì độ 3";

            editChuanDoan.setText(chandoan);
        });
    }
}
