package com.example.paneninmobile.Models;

public class KategoriModel {
    private String id_jenis_produk;
    private String nama_jenis_produk;
    private String foto_jenis_produk;

    public KategoriModel(String id_jenis_produk, String nama_jenis_produk, String foto_jenis_produk) {
        this.id_jenis_produk = id_jenis_produk;
        this.nama_jenis_produk = nama_jenis_produk;
        this.foto_jenis_produk = foto_jenis_produk;
    }

    public String getId_jenis_produk() {

        return id_jenis_produk;
    }

    public void setId_jenis_produk(String id_jenis_produk) {
        this.id_jenis_produk = id_jenis_produk;
    }

    public String getNama_jenis_produk() {

        return nama_jenis_produk;
    }

    public void setNama_jenis_produk(String nama_jenis_produk) {
        this.nama_jenis_produk = nama_jenis_produk;
    }

    public String getFoto_jenis_produk() {

        return foto_jenis_produk;
    }

    public void setFoto_jenis_produk(String foto_jenis_produk) {
        this.foto_jenis_produk = foto_jenis_produk;
    }
}
