package com.example.paneninmobile.Models;

import com.google.gson.annotations.SerializedName;

public class TerlarisModel {
    @SerializedName("id_produk")
    private String idProduk;

    @SerializedName("nama_produk")
    private String namaProduk;

    @SerializedName("foto_produk")
    private String fotoProduk;

    @SerializedName("harga_produk")
    private String hargaProduk;

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getFotoProduk() {
        return fotoProduk;
    }

    public void setFotoProduk(String fotoProduk) {
        this.fotoProduk = fotoProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }
}