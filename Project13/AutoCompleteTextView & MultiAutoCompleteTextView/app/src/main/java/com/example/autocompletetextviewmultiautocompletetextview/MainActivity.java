package com.example.autocompletetextviewmultiautocompletetextview;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;

    String[] items = {"Hà nội", "Huế", "Hà giang", "Hải phòng", "Nam định", "Long khánh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = findViewById(R.id.selection);
        singleComplete = findViewById(R.id.editAuto);
        multiComplete = findViewById(R. id.editMultiAutoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, items
        );

        singleComplete.setAdapter(adapter);
        multiComplete.setAdapter(adapter);
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        singleComplete.setOnItemClickListener((parent, view, position, id) -> {
            selection.setText(parent.getItemAtPosition(position).toString());
        });
    }
}
