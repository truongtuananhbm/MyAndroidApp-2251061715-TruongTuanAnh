package com.example.quanlysinhvien;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.content.ContentValues;

public class MainActivity extends AppCompatActivity {

    EditText edmalop, edtenlop, edsiso;
    Button btninsert, btndelete, btnupdate, btnquery;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edmalop = findViewById(R.id.edmalop);
        edtenlop = findViewById(R.id.edtenlop);
        edsiso = findViewById(R.id.edsiso);
        btninsert = findViewById(R.id.btninsert);
        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnupdate);
        btnquery = findViewById(R.id.btnquery);
        lv = findViewById(R.id.lv);

        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        mydatabase = openOrCreateDatabase("qlsinhvien.db", MODE_PRIVATE, null);
        String sql = "CREATE TABLE IF NOT EXISTS tblLop(malop TEXT PRIMARY KEY, tenlop TEXT, siso INTEGER)";
        mydatabase.execSQL(sql);

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edmalop.getText().toString();
                String tenlop = edtenlop.getText().toString();
                int siso = Integer.parseInt(edsiso.getText().toString());

                ContentValues values = new ContentValues();
                values.put("malop", malop);
                values.put("tenlop", tenlop);
                values.put("siso", siso);

                long kq = mydatabase.insert("tblLop", null, values);
                if (kq == -1)
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Insert success", Toast.LENGTH_SHORT).show();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edmalop.getText().toString();
                int kq = mydatabase.delete("tblLop", "malop = ?", new String[]{malop});
                if (kq == 0)
                    Toast.makeText(MainActivity.this, "No record to delete", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edmalop.getText().toString();
                String tenlop = edtenlop.getText().toString();
                int siso = Integer.parseInt(edsiso.getText().toString());

                ContentValues values = new ContentValues();
                values.put("tenlop", tenlop);
                values.put("siso", siso);

                int kq = mydatabase.update("tblLop", values, "malop = ?", new String[]{malop});
                if (kq == 0)
                    Toast.makeText(MainActivity.this, "No record to update", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mylist.clear();
                Cursor c = mydatabase.query("tblLop", null, null, null, null, null, null);
                while (c.moveToNext()) {
                    String data = c.getString(0) + " - " + c.getString(1) + " - " + c.getInt(2);
                    mylist.add(data);
                }
                c.close();
                myadapter.notifyDataSetChanged();
            }
        });
    }
}
