package com.example.register_personal_information;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    EditText editTen, editCMND, ediBosung;
    CheckBox chkDocBao, chkDocSach, chkCode;
    Button btnSend;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTen = findViewById(R.id.editTen);
        editCMND = findViewById(R.id.editCMND);
        ediBosung = findViewById(R.id.ediBosung);

        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkCode = findViewById(R.id.chkCode);

        group = findViewById(R.id.id_radiogroup);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShowInformation();
            }
        });
    }

    public void doShowInformation() {
        // Kiểm tra tên
        String ten = editTen.getText().toString().trim();
        if (ten.length() < 3) {
            editTen.requestFocus();
            Toast.makeText(this, "Tên phải > 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra CMND
        String cmnd = editCMND.getText().toString().trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra bằng cấp
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rdo = findViewById(id);
        String bangcap = rdo.getText().toString();

        // Kiểm tra sở thích
        String sothich = "";
        if (chkDocBao.isChecked()) sothich += chkDocBao.getText() + "\n";
        if (chkDocSach.isChecked()) sothich += chkDocSach.getText() + "\n";
        if (chkCode.isChecked()) sothich += chkCode.getText() + "\n";

        // Lấy bổ sung
        String bosung = ediBosung.getText().toString();

        // Hiện Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        String msg = "Họ tên: " + ten + "\n"
                + "CMND: " + cmnd + "\n"
                + "Bằng cấp: " + bangcap + "\n"
                + "Sở thích:\n" + sothich
                + "Thông tin bổ sung:\n" + bosung;

        builder.setMessage(msg);
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    // Ghi đè nút back
    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(android.R.drawable.ic_dialog_info);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        b.create().show();
    }
}
