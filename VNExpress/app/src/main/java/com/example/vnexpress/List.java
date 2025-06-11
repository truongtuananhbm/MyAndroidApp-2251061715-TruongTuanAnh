package com.example.vnexpress;

import android.graphics.Bitmap;

public class List {
    private Bitmap img;
    private String title, info, link;

    public List(Bitmap img, String title, String info, String link) {
        this.img = img;
        this.title = title;
        this.info = info;
        this.link = link;
    }

    public Bitmap getImg() { return img; }
    public String getTitle() { return title; }
    public String getInfo() { return info; }
    public String getLink() { return link; }
}

