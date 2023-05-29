package com.example.paneninmobile.Home;

import android.graphics.drawable.Drawable;

public class ItemTerlaris {
    private String title, harga;
    private Drawable gambar;


    public ItemTerlaris(String title, String harga) {
        this.title = title;
        this.harga = harga;

    }
    public Drawable getGambar() {
        return gambar;
    }

    public String getTitle() {
        return title;
    }

    public String getHarga() {
        return harga;
    }

}
