package com.example.project24;

import android.graphics.Bitmap;

public class Tygia {
    private String type, imageurl, muack, bantienmat, bank;
    private Bitmap bitmap;

    public Tygia(String type, String imageurl, Bitmap bitmap, String muack, String bantienmat, String bank) {
        this.type = type;
        this.imageurl = imageurl;
        this.bitmap = bitmap;
        this.muack = muack;
        this.bantienmat = bantienmat;
        this.bank = bank;
    }

    // Getter + Setter
    public String getType() { return type; }
    public String getImageurl() { return imageurl; }
    public Bitmap getBitmap() { return bitmap; }
    public String getMuack() { return muack; }
    public String getBantienmat() { return bantienmat; }
    public String getBank() { return bank; }

    public void setBitmap(Bitmap bitmap) { this.bitmap = bitmap; }
}

