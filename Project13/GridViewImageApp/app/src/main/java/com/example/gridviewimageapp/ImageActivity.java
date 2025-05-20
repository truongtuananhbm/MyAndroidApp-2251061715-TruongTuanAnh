package com.example.gridviewimageapp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imgDetail);

        String imgName = getIntent().getStringExtra("imgName");
        int resId = getResources().getIdentifier(imgName, "drawable", getPackageName());

        imageView.setImageResource(resId);
    }
}
