package com.example.paneninmobile.Home;

import android.graphics.drawable.Drawable;

public class ProdukListGet {
    private String title, harga;
    private Drawable gambar;


    public ProdukListGet(String title, String harga) {
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
