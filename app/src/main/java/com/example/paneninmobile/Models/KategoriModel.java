package com.example.paneninmobile.Models;

public class KategoriModel {
    private String idJenisProduk;
    private String namaJenisProduk;
    private String fotoJenisProduk;

    public KategoriModel(String idJenisProduk, String namaJenisProduk, String fotoJenisProduk) {
        this.idJenisProduk = idJenisProduk;
        this.namaJenisProduk = namaJenisProduk;
        this.fotoJenisProduk = fotoJenisProduk;
    }

    public String getIdJenisProduk() {
        return idJenisProduk;
    }

    public String getNamaJenisProduk() {
        return namaJenisProduk;
    }

    public String getFotoJenisProduk() {
        return fotoJenisProduk;
    }
}

